package com.unicesumar;

import com.unicesumar.entities.Product;
import com.unicesumar.entities.User;
import com.unicesumar.repository.ProductRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        ProductRepository listaDeProdutos = null;
        UserRepository userRepository = null;
        Connection conn = null;

        String url = "jdbc:sqlite:database.sqlite";

        try {
            conn = DriverManager.getConnection(url);
            if (conn != null) {
                listaDeProdutos = new ProductRepository(conn);
                userRepository = new UserRepository(conn);  // Agora funcionando!
                System.out.println("Conectado ao banco com sucesso!");
            } else {
                System.out.println("Falha na conexão.");
                System.exit(1);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            System.exit(1);
        }

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n---MENU---");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Cadastrar Usuário");
            System.out.println("4 - Listar Usuários");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Cadastrar Produto");
                    listaDeProdutos.save(new Product("Teste", 10));
                    listaDeProdutos.save(new Product("Computador", 3000));
                    break;
                case 2:
                    System.out.println("Listar Produtos");
                    List<Product> products = listaDeProdutos.findAll();
                    products.forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Cadastrar Usuário");
                    cadastrarUsuario(scanner, userRepository);
                    break;
                case 4:
                    System.out.println("Listar Usuários");
                    listarUsuarios(userRepository);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (option != 5);

        scanner.close();
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void cadastrarUsuario(Scanner scanner, UserRepository userRepository) {
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String password = scanner.nextLine();

        UUID uuid = UUID.randomUUID();
        User newUser = new User(uuid, name, email, password);

        try {
            userRepository.save(newUser);
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar o usuário: " + e.getMessage());
        }
    }

    private static void listarUsuarios(UserRepository userRepository) {
        try {
            List<User> users = userRepository.findAll();

            if (users.isEmpty()) {
                System.out.println("Nenhum usuário encontrado.");
            } else {
                System.out.println("Lista de Usuários:");
                for (User user : users) {
                    System.out.println("UUID: " + user.getUuid() + ", Nome: " + user.getName() + ", E-mail: " + user.getEmail());
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar os usuários: " + e.getMessage());
        }
    }

    public static class UserRepository {
        private final Connection connection;

        public UserRepository(Connection connection) {
            this.connection = connection;
        }

        public void save(User user) throws SQLException {
            String sql = "INSERT INTO users (uuid, name, email, password) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, user.getUuid().toString());
                stmt.setString(2, user.getName());
                stmt.setString(3, user.getEmail());
                stmt.setString(4, user.getPassword());
                stmt.executeUpdate();
            }
        }

        public List<User> findAll() throws SQLException {
            List<User> users = new ArrayList<>();
            String sql = "SELECT uuid, name, email, password FROM users";

            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    User user = new User(
                            UUID.fromString(rs.getString("uuid")),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("password")
                    );
                    users.add(user);
                }
            }

            return users;
        }
    }
}
