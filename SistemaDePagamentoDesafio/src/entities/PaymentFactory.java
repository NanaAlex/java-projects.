package entities;

public class PaymentFactory {
    // Método que cria a estratégia de pagamento com base na escolha do tipo
    public static PaymentProcessor createPaymentProcessor(String paymentType) {
        PaymentStrategy strategy;

        switch (paymentType.toLowerCase()) {
            case "pix":
                strategy = new PixPayment();
                break;
            case "credit_card":
                strategy = new CreditCardPayment();
                break;
            case "boleto":
                strategy = new BoletoPayment();
                break;
            default:
                throw new IllegalArgumentException("Tipo de pagamento inválido");
        }

        return new PaymentProcessor(strategy); // Retorna o PaymentProcessor com a estratégia correta
    }
}
