package entities;

public class SMS implements Notification{
	
	@Override
	public void send(String message) {
		System.out.println("Enviando SMS: " + message);
	}
}