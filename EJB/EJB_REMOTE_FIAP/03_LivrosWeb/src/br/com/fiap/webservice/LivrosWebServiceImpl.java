package br.com.fiap.webservice;


import java.util.Collections;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.bean.LivroBeanRemote;
import br.com.fiap.Livro;

@WebService(serviceName = "livroendpoint")
public class LivrosWebServiceImpl implements LivrosWebService {

	@Override
	public void add(Livro livro) {
		try {
			InitialContext ctx = new InitialContext();
			LivroBeanRemote service = (LivroBeanRemote) ctx.lookup("ejb:/03_LivrosWeb/LivroBean!br.com.bean.LivroBeanRemote");
			service.add(livro);
		} catch (NamingException e) {
		}
	}

	@Override
	@WebMethod
	public List<Livro> getAll() {
		try {
			InitialContext ctx = new InitialContext();
			LivroBeanRemote service = (LivroBeanRemote) ctx.lookup("ejb:/03_LivrosWeb/LivroBean!br.com.bean.LivroBeanRemote");
			return service.getAll();
		} catch (NamingException e) {
			return Collections.emptyList();
		}
	}

}
