package entities;


//Cada classe implementa Notification e define um comportamento específico para o envio.
public class Email implements Notification{
	
	@Override
	public void send(String message) {
		System.out.println("Enviando e-mail: " + message);
	}
}

