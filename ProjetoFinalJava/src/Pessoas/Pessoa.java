package Pessoas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Exception.CpfException;

public abstract class Pessoa {
	protected String nome;
	protected String cpf;
	protected LocalDate dataNasc;
	static protected List<String> listaCpfs = new ArrayList<>();
	
	public Pessoa() {
		super();
	}

	public Pessoa(String nome, String cpf, LocalDate dataNasc) throws CpfException {
		super();
		this.nome = nome;
		//Tratamento de erro para CPFs iguais
		for(int i = 0; i < listaCpfs.size();i++) {
			if (listaCpfs.get(i).contentEquals(cpf)){
				throw new CpfException(cpf, this.nome, "i");
			}
		}
		listaCpfs.add(cpf);
		
		//Tratamento de erro para CPF maior que 11 dígitos
		if (cpf.length() > 11) {
			throw new CpfException(cpf, this.nome, "d");
		} else {
		this.cpf = cpf;
		}
		
		this.dataNasc = dataNasc;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws CpfException {
		//Tratamento de erro para CPFs iguais
		for(int i = 0; i < listaCpfs.size();i++) {
			if (listaCpfs.get(i).contentEquals(cpf)){
				throw new CpfException(cpf, this.nome, "i");
			}
		}
		listaCpfs.add(cpf);
		
		//Tratamento de erro para CPF maior que 11 dígitos
		if (cpf.length() > 11) {
			throw new CpfException(cpf, this.nome, "d");
		} else {
		this.cpf = cpf;
		}
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	
}
