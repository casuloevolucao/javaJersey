package br.com.haras.controller;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import br.com.haras.model.Usuario;
import br.com.haras.ngc.UsuarioNgc;



@Path("/usuario")
public class UsuarioController {
	
	private final UsuarioNgc usuarioNgc;
	
	@Inject
	public UsuarioController( UsuarioNgc usuarioNgc) {
		this.usuarioNgc = usuarioNgc;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public String init(){
		Usuario usuario = new Usuario();
		usuario.setEmail("teste@teste.com");
		usuario.setNome("ismael");
		usuarioNgc.salvarUsuario(usuario);
		return "oi...";
	}
}
