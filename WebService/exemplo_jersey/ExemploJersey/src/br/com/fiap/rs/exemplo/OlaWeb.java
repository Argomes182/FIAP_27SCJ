package br.com.fiap.rs.exemplo;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path(value="exemplows")
public class OlaWeb {

//	@GET
//	@Produces(TEXT_PLAIN)
//	public String ola(){
//		return "Ol�, amiguinho, sou o Dollynho vamos brincar?";
//	}

	@GET
	@Produces(TEXT_PLAIN)
	public Response ola(){
		return Response.status(Response.Status.OK).entity("Deu Certo").build();
	}
	
	
}
