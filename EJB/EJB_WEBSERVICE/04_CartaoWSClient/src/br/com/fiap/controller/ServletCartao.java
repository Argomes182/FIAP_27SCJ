package br.com.fiap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.webservice.CartaoWebService;
import br.com.fiap.webservice.CartaoWebServiceProxy;

@WebServlet("/cartao")
public class ServletCartao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCartao() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try {
			String cartao = request.getParameter("cartao");
			double valor = Double.parseDouble(request.getParameter("valor"));
			CartaoWebService card = new CartaoWebServiceProxy();
			out.print(card.validarCartao(cartao, valor));
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}
}
