package entities;

import java.util.Scanner;

//Gera numero random do cartao
//mascara o numero do cartao e exibe apenas os 4 ultimos digitos
public class CreditCardPayment implements PaymentStrategy {

	@Override
	public void processPayment(double amount) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Pagamento via Cartão de Crédito selecionado.");
        System.out.println("Valor: R$" + amount);
        
        System.out.print("Digite o número do cartão (fictício): ");
        String cardNumber = scanner.nextLine();
        
        System.out.println("Pagamento de R$" + amount + " realizado com sucesso no cartão: " + maskCardNumber(cardNumber) + "\n");
	}
	
	private String maskCardNumber(String cardNumber) {
		if (cardNumber.length() >= 4) {
			return "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
		}
		
		return "**** **** **** ****";
	}

}
