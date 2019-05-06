package br.com.haras.interceptor;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;


public class AuditInterceptor extends EmptyInterceptor {

	private static final long serialVersionUID = -4793458457954382708L;
	
	
	public AuditInterceptor() {
	}
	
	
	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		
		boolean mudouEstado = false;
		
		for (int i = 0; i < propertyNames.length; i++) {
			if ("dataRegistro".equals(propertyNames[i])){
				state[i] = new Date();
				mudouEstado = true;
			}	
			if ("estaAtivo".equals(propertyNames[i])){
				state[i] = true;
				mudouEstado = true;
			}	
		}

		return mudouEstado;

	}

	
	@Override
	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		
		
		boolean mudouEstado = false;
				
		for (int i = 0; i < propertyNames.length; i++) {
			if ("dataAtualizacao".equals(propertyNames[i])){
				currentState[i] = new Date();
				mudouEstado = true;
			}	
		}
		return mudouEstado;
	}
	
	
}
