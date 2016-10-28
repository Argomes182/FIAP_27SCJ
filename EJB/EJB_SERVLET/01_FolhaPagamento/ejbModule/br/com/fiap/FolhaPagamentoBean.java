package br.com.fiap;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateful;

@Stateful
@Local(FolhaPagamento.class)
public class FolhaPagamentoBean implements FolhaPagamento {

	private double salario, taxa;
	private List<String> nomes;
	
    public FolhaPagamentoBean() {
    	this.nomes = new ArrayList<>();
    }

	@Override
	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public void setDesconto(double taxa) {
		this.taxa = taxa;
	}

	@Override
	public double calcularINSS() {
		return salario * taxa / 100;
	}

	@Override
	public double calcularSalarioLiquido() {
		return salario - calcularINSS();
	}

	@Override
	public List<String> buscarNomes() {
		return this.nomes;
	}

	@Override
	public void incluirNome(String nome) {
		this.nomes.add(nome);
	}

}