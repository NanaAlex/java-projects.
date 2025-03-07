package entities;

//Interface que define o comportamento de um método de pagamento
//Garante que todos os tipos de pagamentos sejam uniformes
public interface PaymentStrategy {
	
	void processPayment(double amount);
}
