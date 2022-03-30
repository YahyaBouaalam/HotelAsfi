package Management;

public class FieldTakenException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FieldTakenException() {
		super("Username already taken, please choose another username.");
	}



}
