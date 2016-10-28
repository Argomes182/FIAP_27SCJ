package br.com.fiap.bean;

import javax.ejb.Local;

import br.com.fiap.entity.Pessoa;

@Local
public interface IRPFLocal {

	double calcularIrpf(double salario);

	double calcularIrpf(Pessoa pessoa);
	
	double calcularINSS(double salario);

	void save(Pessoa pessoa);
	
}
