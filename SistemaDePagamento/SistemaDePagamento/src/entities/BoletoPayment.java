package entities;

import java.util.Random;

//Gera numero random
//simula etapa de emissao de boleto
public class BoletoPayment implements PaymentStrategy {

	@Override
	public void processPayment(double amount) {
		String boletoCode = generateBoletoCode();
		System.out.println("Pagamento via Boleto selecionado.");
        System.out.println("Valor: R$" + amount);
        System.out.println("Código do Boleto: " + boletoCode);
        System.out.println("Boleto gerado com sucesso! Realize o pagamento antes do vencimento.\n");
	}

	private String generateBoletoCode() {
		Random rand = new Random();
        return "BOLETO-" + rand.nextInt(99999999);
	}

}
