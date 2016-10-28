package br.com.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.bean.interceptor.MonitorInterceptor;
import br.com.fiap.Livro;

@Stateless
@Interceptors({MonitorInterceptor.class}) 
public class LivroBean implements LivroBeanRemote {

	@PersistenceContext(unitName = "fiapPU")
	private EntityManager em;

	public LivroBean() {
	}

	@Override
	public void add(Livro livro) {
		em.persist(livro);
	}

	@Override
	public List<Livro> getAll() {
		TypedQuery<Livro> query = em.createQuery("select u from Livro u", Livro.class);
		return query.getResultList();
	}
}