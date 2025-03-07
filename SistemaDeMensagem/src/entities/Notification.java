package entities;

//A interface garante que todas as notificações tenham um método comum (send), promovendo o polimorfismo.
public interface Notification {
	void send(String message);
}
