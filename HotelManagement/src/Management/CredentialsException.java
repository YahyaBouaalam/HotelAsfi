package Management;

public class CredentialsException extends Exception{

	private static final long serialVersionUID = 1L;

		public CredentialsException() {
			super("Incorrect Password or Username, Try again.");
		}
	}
