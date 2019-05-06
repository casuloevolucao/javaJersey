package br.com.haras.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@SequenceGenerator(name="SEQUENCE", sequenceName="usuario_id_seq")
@Inheritance(strategy=InheritanceType.JOINED)
public class Usuario extends BaseModel{	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6442994206855050785L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE")
	protected Integer id;

	@Column(nullable = false, length=255, name="nome")
	private String nome;

	@Column(nullable = true,length=255, unique= true, name="email")	
	private String email;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
