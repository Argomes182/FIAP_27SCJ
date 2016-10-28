package br.com.fiap.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class TesteChamadaGet {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://127.0.0.1:8080/ExemploJersey").path("alunos").path("1");
		Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
		
		Response response = invocationBuilder.get();
		
		Aluno aluno = response.readEntity(Aluno.class);
		System.out.println("Nome: "+ aluno.getNome());
		System.out.println("Turma: "+ aluno.getTurma());
		System.out.println("Media: "+ aluno.getMedia());
		
	}
	
	
}
