package br.com.bean;

import java.util.List;

import javax.ejb.Remote;

import br.com.fiap.Livro;

@Remote
public interface LivroBeanRemote {
	void add(Livro livro);
	List<Livro> getAll();
}
