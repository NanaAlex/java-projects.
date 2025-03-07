package main;

import java.util.Scanner;

import entities.PaymentFactory;
import entities.PaymentProcessor;

//Exibe um menu de opções para o usuário escolher um método de pagamento
//Instancia a classe correspondente com base na escolha do usuário.
//Cria um PaymentProcessor e executa o pagamento.
//Permite que o usuário continue fazendo pagamentos até selecionar a opção de sair.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Exibe opções para o usuário
        System.out.println("Escolha o método de pagamento:");
        System.out.println("1. Pix");
        System.out.println("2. Cartão de Crédito");
        System.out.println("3. Boleto");

        int choice = scanner.nextInt();
        scanner.nextLine(); 

        // Converte a escolha para a string correspondente
        String paymentType = "";
        switch (choice) {
            case 1:
                paymentType = "pix";
                break;
            case 2:
                paymentType = "credit_card";
                break;
            case 3:
                paymentType = "boleto";
                break;
            default:
                System.out.println("Opção inválida.");
                System.exit(0);
        }

        // Solicita o valor da transação
        System.out.println("Digite o valor da transação:");
        double amount = scanner.nextDouble();

        // Cria o PaymentProcessor usando o Factory Method
        PaymentProcessor paymentProcessor = PaymentFactory.createPaymentProcessor(paymentType);

        // Processa o pagamento
        paymentProcessor.executePayment(amount);

        scanner.close();
    }
}
