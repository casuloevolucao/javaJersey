package br.com.haras.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3621603409845177730L;

	public abstract Integer getId();
	
	public abstract void setId(Integer id);
	
	@Column(nullable=false, name="esta_ativo")
	protected Boolean estaAtivo;
	
	@Column(nullable = false,name="data_registro")	
	protected Date dataRegistro;
	
	@Column(nullable = true,name="data_atualizacao")	
	protected Date dataAtualizacao;	

	public Boolean getEstaAtivo() {
		return estaAtivo;
	}

	public void setEstaAtivo(Boolean estaAtivo) {
		this.estaAtivo = estaAtivo;
	}
	
	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
}
