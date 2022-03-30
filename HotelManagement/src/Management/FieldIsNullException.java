package Management;

public class FieldIsNullException extends Exception{

	private static final long serialVersionUID = 1L;

		public FieldIsNullException() {
			super("All fields are necessary for check-in, please fill all fields.");
		}
	}
