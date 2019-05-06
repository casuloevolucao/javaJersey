package br.com.haras.dao;

import org.hibernate.Session;
import br.com.haras.factory.HibernateFactory;
import br.com.haras.interceptor.AuditInterceptor;
import br.com.haras.model.BaseModel;
import br.com.haras.model.Usuario;

public abstract class GenericDao {	
	
	protected final Session session;
	
	 public GenericDao(AuditInterceptor audit) {
	    	this.session = HibernateFactory.getHibernateSession();
    }
    
    public void salvar(BaseModel bm){
    	session.saveOrUpdate(bm);
    }
    
    public void update(BaseModel bm){
    	session.update(bm);
    }
    public void merge(BaseModel bm){
    	session.merge(bm);
    }
    public void deletar(BaseModel bm){
    	session.delete(bm);
    }
    
}
