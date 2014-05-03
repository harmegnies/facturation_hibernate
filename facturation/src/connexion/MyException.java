package connexion;
/*
 * classe qui va permettre de g�rer mes propres exceptions
 * h�rite de la classe Exception
 */
public class MyException extends Exception {

	private int code = 0;
	public MyException(String message) {
		super(message);
	}
	public MyException(String message, int code) {
		super(message);
		this.code = code;
	}	
	public String getGeneratedMessage() {
		if ( code != 0 )
			return "Code erreur: " + this.code + "; Message erreur: " + getMessage();
		else
			return "Message erreur: " + getMessage();
	}
	// attention ne pas nommer la m�thode getMessage
	// Design Pattern Decorator
}
