package br.com.fiap;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bean.LivroBeanRemote;

/**
 * Servlet implementation class LivroServlet
 */
@WebServlet("/livro")
public class LivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LivroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			InitialContext ctx = new InitialContext();
			LivroBeanRemote service = (LivroBeanRemote) ctx
					.lookup("ejb:/03_LivrosWeb/LivroBean!br.com.bean.LivroBeanRemote");
			List<Livro> lista = service.getAll();
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("lista.jsp").forward(request, response);
		} catch (NamingException e) {
			out.print(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Livro livro = new Livro();
		livro.setAutor(request.getParameter("autor"));
		livro.setPreco(Double.parseDouble(request.getParameter("valor")));
		livro.setTitulo(request.getParameter("titulo"));
		
		try {
			InitialContext ctx = new InitialContext();
			LivroBeanRemote service = (LivroBeanRemote) ctx
			.lookup("ejb:/03_LivrosWeb/LivroBean!br.com.bean.LivroBeanRemote");
			service.add(livro);
			request.setAttribute("msg", "Livro Adicionado com sucesso.");
			doGet(request, response);
		} catch (NamingException e) {
			out.print(e.getMessage());
		}
		
	}

}
