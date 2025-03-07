package entities;

public class NotificationFactory {
	public static Notification createNotification(String type) {
	    String formattedType = type.toLowerCase(); // nova string criada em minúscula
	    switch (formattedType) { // Usamos ela na comparação
	        case "email":
	            return new Email();
	        case "sms":
	            return new SMS();
	        case "push":
	            return new Push();
	        default:
	            throw new IllegalArgumentException("Tipo de notificação inválido.");
	    }
	}

}
