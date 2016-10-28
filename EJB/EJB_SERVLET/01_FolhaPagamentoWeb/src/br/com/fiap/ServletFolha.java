package br.com.fiap;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/folha")
public class ServletFolha extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	FolhaPagamento fp;

	public ServletFolha() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try {
			double salario = Double.parseDouble(request.getParameter("salario"));
			fp.setSalario(salario);
			fp.setDesconto(10);
			out.println("Salário Bruto: " + salario);
			out.println("<br/>Saláro Líquido: " + fp.calcularSalarioLiquido());
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}
}
