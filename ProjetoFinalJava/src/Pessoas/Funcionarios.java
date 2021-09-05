package Pessoas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Exception.CpfException;
import FuncoesCalculo.AliquotasDeducoes;
import FuncoesCalculo.Calculos;

public class Funcionarios extends Pessoa implements Calculos {
	protected double salarioBruto;
	protected double descontoInss;
	protected double descontoIR;
	protected double salarioLiquido;
	protected double numeroDependentes = 189.59;

	List<Dependentes> listaDependentes = new ArrayList<>();

	public Funcionarios() {
	}

	public Funcionarios(String nome, String cpf, LocalDate dataNasc, double salarioBruto) throws CpfException {
		super(nome, cpf, dataNasc);
		this.salarioBruto = salarioBruto;

	}

	public Funcionarios(String nome, String cpf, LocalDate dataNasc, double salarioBruto,
			List<Dependentes> listaDependentes) throws CpfException {
		super(nome, cpf, dataNasc);
		this.salarioBruto = salarioBruto;
		this.listaDependentes = listaDependentes;
	}

	public double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public List<Dependentes> getListaDependentes() {
		return listaDependentes;
	}

	public void setListaDependentes(List<Dependentes> listaDependentes) {
		this.listaDependentes = listaDependentes;
	}

	public double getDescontoInss() {
		return descontoInss;
	}

	public void setDescontoInss(double descontoInss) {
		this.descontoInss = descontoInss;
	}

	public double getDescontoIR() {
		return descontoIR;
	}

	public void setDescontoIR(double descontoIR) {
		this.descontoIR = descontoIR;
	}

	public double getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}

	public double getNumeroDependentes() {
		return numeroDependentes;
	}

	public void setNumeroDependentes(double numeroDependentes) {
		this.numeroDependentes = numeroDependentes;
	}

	@Override
	public double calculoINSS() {
		if (salarioBruto <= 1100) {
			return descontoInss = (salarioBruto * AliquotasDeducoes.ALIQUOTAINSS.getA())
					- AliquotasDeducoes.DEDUCAOINSS.getA();
		} else if (salarioBruto > 1100 && salarioBruto <= 2203.48) {
			return descontoInss = (salarioBruto * AliquotasDeducoes.ALIQUOTAINSS.getB())
					- AliquotasDeducoes.DEDUCAOINSS.getB();
		} else if (salarioBruto > 2203.48 && salarioBruto <= 3305.22) {
			return descontoInss = (salarioBruto * AliquotasDeducoes.ALIQUOTAINSS.getC())
					- AliquotasDeducoes.DEDUCAOINSS.getC();
		} else if (salarioBruto > 3305.23 && salarioBruto <= 6433.57) {
			return descontoInss = (salarioBruto * AliquotasDeducoes.ALIQUOTAINSS.getD())
					- AliquotasDeducoes.DEDUCAOINSS.getD();
		} else {
			return descontoInss = (6433.57 * AliquotasDeducoes.ALIQUOTAINSS.getD())
					- AliquotasDeducoes.DEDUCAOINSS.getD();
		}
	}

	@Override
	public double calculoIR() {
		if (salarioBruto <= 1903.98) {
			return descontoIR = 0;
		} else if (salarioBruto > 1903.98 && salarioBruto < 2826.65) {
			return descontoIR = ((salarioBruto - numeroDependentes - descontoInss)
					* AliquotasDeducoes.ALIQUOTAIR.getA()) - AliquotasDeducoes.DEDUCAOIR.getA();
		} else if (salarioBruto > 2826.65 && salarioBruto <= 3751.05) {
			return descontoIR = ((salarioBruto - numeroDependentes - descontoInss)
					* AliquotasDeducoes.ALIQUOTAIR.getB()) - AliquotasDeducoes.DEDUCAOIR.getB();
		} else if (salarioBruto > 3751.05 && salarioBruto <= 4664.68) {
			return descontoIR = ((salarioBruto - numeroDependentes - descontoInss)
					* AliquotasDeducoes.ALIQUOTAIR.getC()) - AliquotasDeducoes.DEDUCAOIR.getC();
		} else {
			return descontoIR = ((salarioBruto - numeroDependentes - descontoInss)
					* AliquotasDeducoes.ALIQUOTAIR.getD()) - AliquotasDeducoes.DEDUCAOIR.getD();
		}
	}

	@Override
	public double calculoSalario() {

		return salarioLiquido = salarioBruto - descontoInss - descontoIR;
	}

	@Override
	public void addDep() {
		numeroDependentes = numeroDependentes * listaDependentes.size();

	}
}
