package entities;

//Atributo strategy armazena a estrategia do pagamento selecionado
//No método executePayment(), apenas chama o processPayment() da estratégia escolhida.
public class PaymentProcessor {
	private PaymentStrategy strategy;

    public PaymentProcessor(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment(double amount) {
        strategy.processPayment(amount);
    }
}
