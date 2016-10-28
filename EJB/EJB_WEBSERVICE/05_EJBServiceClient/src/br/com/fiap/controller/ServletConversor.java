package br.com.fiap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import br.com.fiap.exemplos.jaxws.Conversor;
import br.com.fiap.exemplos.jaxws.ConversorLocator;
import br.com.fiap.exemplos.jaxws.ConversorPortType;

@WebServlet("/conversor")
public class ServletConversor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletConversor() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		double valor = 100;
		double real4dolar, dolar4real;
		try {
			Conversor service = new ConversorLocator();
			ConversorPortType port = service.getConversorPort();
			real4dolar = port.realParaDolar(valor);
			dolar4real = port.dolarParaReal(valor);
			out.print(valor + " reais = " + real4dolar + " dolares");
			out.print("<br/>");
			out.print(valor + " dolares = " + dolar4real + " reais");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
