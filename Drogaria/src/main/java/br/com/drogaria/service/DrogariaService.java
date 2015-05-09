package br.com.drogaria.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/drogaria")
public class DrogariaService {
	@GET 
	@Produces(MediaType.TEXT_PLAIN)
	public String testar(){
		String mensagem = "Olá Mundo";
		return mensagem;
	}
}
