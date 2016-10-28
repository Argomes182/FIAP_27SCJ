package br.com.fiap.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fiap.entity.Pessoa;
import br.com.fiap.util.Irpf;

@Stateless
public class IRPFBean implements IRPFRemote, IRPFLocal {

	@PersistenceContext(unitName = "fiapPU")
	private EntityManager em;
	
    public IRPFBean() {
    }

	@Override
	public double calcularIrpf(double salario) {
		Irpf irpf = new Irpf();
		return irpf.calcularIrpf(salario);
	}
	
	@Override
	public double calcularIrpf(Pessoa pessoa) {
		Double desconto = pessoa.getSalario() - pessoa.getInss();
		return calcularIrpf(desconto);
	}
	
	@Override
	public double calcularINSS(double salario) {
		return salario * 0.1;
	}

	@Override
	public void save(Pessoa pessoa) {
		em.persist(pessoa);
	}

}
