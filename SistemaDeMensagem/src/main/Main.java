package main;

import java.util.Scanner;

import entities.Notification;
import entities.NotificationFactory;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o tipo de notificação:");
        System.out.println("1: Email");
        System.out.println("2: SMS");
        System.out.println("3: Push Notification");

     // Lê a opção escolhida pelo usuário
        int choice = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do teclado

        System.out.println("Digite a mensagem:");
        String message = scanner.nextLine();

     // Declara a variável de notificação que será criada
        Notification notification = null;

        switch (choice) {
            case 1:
                notification = NotificationFactory.createNotification("email");
                break;
            case 2:
                notification = NotificationFactory.createNotification("sms");
                break;
            case 3:
                notification = NotificationFactory.createNotification("push");
                break;
            default:
                System.out.println("Opção inválida.");
                System.exit(0);
        }

     // Envia a mensagem usando o método send() da notificação criada
        notification.send(message);
        scanner.close();
    }
}
