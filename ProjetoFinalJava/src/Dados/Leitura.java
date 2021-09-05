package Dados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Exception.CpfException;
import Pessoas.Dependentes;
import Pessoas.Funcionarios;

public class Leitura {

	public static List<Funcionarios> leitorPessoas(String nomeArquivo) throws IOException, CpfException {
		BufferedReader leitor = new BufferedReader(new FileReader("./src/Arquivos/" + nomeArquivo));

		String linha = "";

		List<Funcionarios> listaFuncionarios = new ArrayList<>();
		List<Dependentes> listaDependentes = new ArrayList<>();
		Funcionarios funcionario = new Funcionarios();
		while (true) {

			linha = leitor.readLine();

			if (linha == null) {
				funcionario.setListaDependentes(listaDependentes);
				listaFuncionarios.add(funcionario);
				break;
			}

			if (!linha.isEmpty()) {
				String[] campos = linha.split(";");
				if (campos[3].equalsIgnoreCase("sobrinho") || campos[3].equalsIgnoreCase("filho")
						|| campos[3].equalsIgnoreCase("outros")) {
					DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyyMMdd");
					LocalDate data = LocalDate.parse(campos[2], formato);
					Dependentes dependente = new Dependentes(campos[0], campos[1], data, campos[3]);
					listaDependentes = funcionario.getListaDependentes();
					listaDependentes.add(dependente);
				} else {

					DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyyMMdd");
					LocalDate data = LocalDate.parse(campos[2], formato);
					funcionario = new Funcionarios();
					funcionario.setNome(campos[0]);
					funcionario.setCpf(campos[1]);
					funcionario.setDataNasc(data);
					funcionario.setSalarioBruto(Double.parseDouble(campos[3]));

				}
			} else if (linha.isEmpty()) {
				funcionario.setListaDependentes(listaDependentes);
				listaFuncionarios.add(funcionario);

			}

		}

		leitor.close();
		return listaFuncionarios;
	}
}