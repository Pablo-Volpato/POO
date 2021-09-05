package Pessoas;

import java.time.LocalDate;
import java.time.Period;

import Exception.CpfException;
import Exception.DependenteException;

public class Dependentes extends Pessoa{
		protected String parentesco;
		
	public Dependentes(String nome, String cpf, LocalDate dataNasc, String parentesco) throws CpfException {
		super(nome, cpf, dataNasc);
		LocalDate dataHoje = LocalDate.now();
		if (Period.between(dataNasc, dataHoje).getYears() >= 18) {
			throw new DependenteException(nome, Period.between(dataNasc, dataHoje).getYears());
		}
		this.parentesco = parentesco;
	}

}
