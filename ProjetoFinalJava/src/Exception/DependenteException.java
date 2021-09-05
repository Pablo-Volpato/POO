package Exception;

public class DependenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DependenteException(String message) {
		super(message);
		
	}

	public DependenteException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DependenteException(String nome, int idade) {
		super();
		System.out.println("\nO dependente: " + nome + ", possui " + idade + " anos. \nNão são permitidos dependentes maiores de 18 anos.\nFalha ao exportar arquivo.\n\n");
		// TODO Auto-generated constructor stub
	}

	public DependenteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DependenteException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DependenteException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
