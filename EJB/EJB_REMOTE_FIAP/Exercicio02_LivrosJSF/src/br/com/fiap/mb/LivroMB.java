package br.com.fiap.mb;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.webservice.Livro;
import br.com.fiap.webservice.LivrosWebService;
import br.com.fiap.webservice.LivrosWebServiceProxy;

@ManagedBean(name="livromb")
@RequestScoped
public class LivroMB {

	private List<Livro> livro;
	
	public LivroMB() {
	}
	
	@PostConstruct
	public void init(){
		try {
			LivrosWebService livraria = new LivrosWebServiceProxy();
			this.setLivro(Arrays.asList(livraria.getAll()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public List<Livro> getLivro() {
		return livro;
	}

	public void setLivro(List<Livro> livro) {
		this.livro = livro;
	}
	
	
	
	
}
