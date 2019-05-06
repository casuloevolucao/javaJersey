package br.com.haras.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.haras.interceptor.AuditInterceptor;
import br.com.haras.model.Usuario;


public class UsuarioDao extends GenericDao{	

	public UsuarioDao(AuditInterceptor audit) {
		super(audit);
		// TODO Auto-generated constructor stub
	}

	public Usuario getUsuario(String email) {
		Usuario u = (Usuario)super.session.createCriteria(Usuario.class)	
			    .add(Restrictions.eq("estaAtivo", true)) 
			    .add(Restrictions.eq("email", email).ignoreCase())
			    .setFetchMode("accessToken", FetchMode.JOIN)
			    .uniqueResult();
		return u;
	}
	
	public Usuario getUsuarioByToken(String token){
		 Usuario usuario = (Usuario)super.session.createCriteria(Usuario.class, "usuario")
					.createAlias("usuario.accessToken", "accessToken")
					.add(Restrictions.eq("accessToken.token", token));
		return usuario;
	}
	

	public boolean validarEmailExistente(Usuario usuario){
		Criteria criteria = session.createCriteria(Usuario.class, "usuario");
		criteria.setProjection(Projections.rowCount());
		criteria.add(Restrictions.eq("usuario.email", usuario.getEmail()).ignoreCase());
		Long numeroLinhas = (Long) criteria.uniqueResult();
		return numeroLinhas > 0;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listarUsuarioPorData(Date data) {
		Criteria criteria = session.createCriteria(Usuario.class, "usuario");
		criteria.add(Restrictions.eq("usuario.dataNascimento", data));
		return criteria.list();
	}


    
}
