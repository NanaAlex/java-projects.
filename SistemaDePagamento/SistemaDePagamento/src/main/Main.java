package main;

import java.util.Scanner;

import entities.BoletoPayment;
import entities.CreditCardPayment;
import entities.PaymentProcessor;
import entities.PaymentStrategy;
import entities.PixPayment;


//Exibe um menu de opções para o usuário escolher um método de pagamento
//Instancia a classe correspondente com base na escolha do usuário.
//Cria um PaymentProcessor e executa o pagamento.
//Permite que o usuário continue fazendo pagamentos até selecionar a opção de sair.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentStrategy strategy = null;

        while (true) {
            System.out.println("Selecione o método de pagamento:");
            System.out.println("1: Pix");
            System.out.println("2: Cartão de Crédito");
            System.out.println("3: Boleto");
            System.out.println("0: Sair");

            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Saindo do sistema...");
                break;
            }

            System.out.print("Digite o valor da transação: R$");
            double amount = scanner.nextDouble();

            switch (choice) {
                case 1:
                    strategy = new PixPayment();
                    break;
                case 2:
                    strategy = new CreditCardPayment();
                    break;
                case 3:
                    strategy = new BoletoPayment();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
            }

            PaymentProcessor processor = new PaymentProcessor(strategy);
            processor.executePayment(amount);
        }

        scanner.close();
    }
}
