package br.com.fiap.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bean.IRPFLocal;
import br.com.fiap.entity.Pessoa;

@WebServlet("/irpf")
public class IRPFServlet extends HttpServlet {

	private static final long serialVersionUID = 3249259142835793199L;

	@EJB
	private IRPFLocal service;

	public IRPFServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("nome");
		String cargo = request.getParameter("cargo");
		double salario = Double.parseDouble(request.getParameter("salario"));
		Pessoa pessoa = new Pessoa();
		pessoa.setCargo(cargo);
		pessoa.setCpf(cpf);
		pessoa.setNome(nome);
		pessoa.setSalario(salario);
		pessoa.setInss(service.calcularINSS(salario));
		pessoa.setIrpf(service.calcularIrpf(pessoa));
		service.save(pessoa);

		request.setAttribute("pessoa", pessoa);
		request.getRequestDispatcher("lista.jsp").forward(request, response);

	}

}
