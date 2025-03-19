package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> listaProdutos = new ArrayList<>();

        while (true) {
            System.out.println("\nMENU");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Buscar produto por código");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Código do produto: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();


                    boolean existe = false;
                    for (Produto p : listaProdutos) {
                        if (p.getCodigo() == codigo) {
                            existe = true;
                            break;
                        }
                    }

                    if (existe) {
                        System.out.println("Erro: Código já cadastrado!");
                        break;
                    }

                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.print("Preço do produto: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();

                    listaProdutos.add(new Produto(codigo, nome, preco));
                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o código do produto: ");
                    int codigoBusca = scanner.nextInt();
                    scanner.nextLine(); 

                    Produto produtoEncontrado = null;
                    for (Produto p : listaProdutos) {
                        if (p.getCodigo() == codigoBusca) {
                            produtoEncontrado = p;
                            break;
                        }
                    }

                    if (produtoEncontrado != null) {
                        System.out.println("\nProduto encontrado:");
                        System.out.println(produtoEncontrado);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}