package br.com.haras.ngc;

import br.com.haras.dao.GenericDao;
import br.com.haras.model.BaseModel;


public abstract class GenericNgc{	
	
	private final GenericDao genericDao;
	
    public GenericNgc(GenericDao genericDao) {
    	this.genericDao = genericDao;
    }
    
    public void salvar(BaseModel bm)throws Exception{
    	genericDao.salvar(bm);
    }
    
    public void update(BaseModel bm){
    	genericDao.update(bm);
    
    }
    
    public void merge(BaseModel bm){
    	genericDao.merge(bm);
    }
    
    public void deletar(BaseModel bm)throws Exception{
    	genericDao.deletar(bm);
    }

}
