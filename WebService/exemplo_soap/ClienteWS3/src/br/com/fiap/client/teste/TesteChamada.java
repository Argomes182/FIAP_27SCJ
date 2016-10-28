package br.com.fiap.client.teste;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

import br.com.fiap.client.Aluno;
import br.com.fiap.client.AlunoWeb;
import br.com.fiap.client.AlunoWebService;

public class TesteChamada {

	public static void main(String[] args) {
			Aluno aluno = new Aluno();
			aluno.setNome("Thiago");
			aluno.setMedia(10.5);
			aluno.setTurma("27SCJ");
			
			AlunoWeb port = new AlunoWebService().getAlunoWebPort();
				
			Map<String,Object> req_ctx = ((BindingProvider)port).getRequestContext();
			Map<String, List<String>> headers = new HashMap<>();
			headers.put("Username", Collections.singletonList("Thiago"));
			headers.put("Password", Collections.singletonList("123"));
			req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
			System.out.println(port.novo(aluno));
	}
	
}
