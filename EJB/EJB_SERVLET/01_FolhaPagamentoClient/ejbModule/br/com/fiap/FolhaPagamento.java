package br.com.fiap;

import java.util.List;

import javax.ejb.Local;

@Local
public interface FolhaPagamento {

	void setSalario(double salario);
	void setDesconto(double taxa);
	double calcularINSS();
	double calcularSalarioLiquido();
	
	List<String> buscarNomes();
	void incluirNome(String nome);
	
	
}
