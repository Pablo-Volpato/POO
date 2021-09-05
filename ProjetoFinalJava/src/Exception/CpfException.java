package Exception;

public class CpfException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CpfException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CpfException(String cpf, String nome, String tipo) {
		super();
		if(tipo == "d") {
			System.out.println("O CPF " + cpf + ", de " + nome + ", tem mais de 11 dígitos.\nFalha ao exportar arquivo.\n");
		} else if (tipo == "i"){
			System.out.println("O CPF " + cpf + ", de " + nome + ", está duplicado nos registros.\nFalha ao exportar arquivo.\n");
		}
		
		// TODO Auto-generated constructor stub
	}

	public CpfException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CpfException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CpfException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CpfException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
