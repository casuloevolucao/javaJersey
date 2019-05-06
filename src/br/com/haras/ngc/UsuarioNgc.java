package br.com.haras.ngc;

import br.com.haras.dao.GenericDao;
import br.com.haras.dao.UsuarioDao;
import br.com.haras.model.Usuario;

public class UsuarioNgc extends GenericNgc{
	
	private final UsuarioDao usuarioDao;
	
	public UsuarioNgc(UsuarioDao usuarioDao) {
		super(usuarioDao);
		this.usuarioDao = usuarioDao;
	}
	
	public void salvarUsuario (Usuario usuario) {
		usuarioDao.salvar(usuario);
	}
}
