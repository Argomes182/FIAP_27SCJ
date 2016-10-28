package br.com.fiap.client.teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

import br.com.fiap.client.Aluno;
import br.com.fiap.client.AlunoWeb;
import br.com.fiap.client.AlunoWebService;

public class TesteChamadaLista {

	public static void main(String[] args) {
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		AlunoWeb port = new AlunoWebService().getAlunoWebPort();
			
		Map<String,Object> req_ctx = ((BindingProvider)port).getRequestContext();
		Map<String, List<String>> headers = new HashMap<>();
		headers.put("Username", Collections.singletonList("Thiago"));
		headers.put("Password", Collections.singletonList("123"));
		req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

		try {
			alunos = port.listar();
			
			for (Aluno aluno : alunos) {
				System.out.println("Nome: " +aluno.getNome());
				System.out.println("Turma: " +aluno.getTurma());
				System.out.println("Media: " +aluno.getMedia());
				System.out.println("-----------------------------");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	
}
