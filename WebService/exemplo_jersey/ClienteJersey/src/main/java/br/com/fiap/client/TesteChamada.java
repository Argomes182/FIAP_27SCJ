package br.com.fiap.client;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class TesteChamada {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://127.0.0.1:8080/ExemploJersey").path("exemplows");
		Builder invocationBuilder = webTarget.request(TEXT_PLAIN);
		
		Response response = invocationBuilder.get();
		
		String retorno = response.readEntity(String.class);
		System.out.println(retorno);
		
	}
}
