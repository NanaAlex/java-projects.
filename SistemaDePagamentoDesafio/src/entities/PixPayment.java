package entities;

import java.util.Random;

//Gera um pix random para siumulação de transação

public class PixPayment implements PaymentStrategy{

	@Override
	public void processPayment(double amount) {
		String pixCode = generatePixCode();
		System.out.println("Pagamento via Pix selecionado.");
        System.out.println("Valor: R$" + amount);
        System.out.println("Código Pix gerado: " + pixCode);
        System.out.println("Pagamento processado com sucesso!\n");
		
	}

	private String generatePixCode() {
		Random rand = new Random();
		return "PIX-" + rand.nextInt(999999);
	}

}
