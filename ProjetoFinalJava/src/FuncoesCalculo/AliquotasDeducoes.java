package FuncoesCalculo;

public enum AliquotasDeducoes {
	
	ALIQUOTAINSS (0.075, 0.09, 0.12, 0.14),
	DEDUCAOINSS (0, 16.5, 82.61, 148.72),
	ALIQUOTAIR (0.075, 0.15, 0.225, 0.275),
	DEDUCAOIR (142.80,354.80, 636.13, 869.36);
	
	private double a;
	private double b;
	private double c;
	private double d;
	
	private AliquotasDeducoes(double a, double b, double c, double d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public double getC() {
		return c;
	}

	public double getD() {
		return d;
	}

	
	
	
	

}
