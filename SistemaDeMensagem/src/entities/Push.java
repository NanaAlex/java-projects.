package entities;

public class Push implements Notification{
	
	@Override
	public void send(String message) {
		System.out.println("Enviando Push Notification: " + message);
	}
}