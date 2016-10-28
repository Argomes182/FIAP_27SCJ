package br.com.fiap;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletNome
 */
@WebServlet("/nomes")
public class ServletNome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	FolhaPagamento fp;
	
    public ServletNome() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try {
			List<String> buscarNomes = fp.buscarNomes();
			out.println("<ul>");
			
			for (String nome : buscarNomes) {
				out.println("<li>" + nome + "</li>");
			}
			out.println("</ul>");
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		fp.incluirNome(nome);
		response.sendRedirect("index2.jsp");
	}

}
