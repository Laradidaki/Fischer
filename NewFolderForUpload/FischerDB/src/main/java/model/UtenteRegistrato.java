package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;



@Entity
@Inheritance(strategy =InheritanceType.JOINED)
public class UtenteRegistrato {

	@Id
	@Column(length=50)
	private String idUtente;
	private String nomeUtente;
	private String password;
	private String numeroTel;
	private Boolean statoUtente = false;
	private Boolean attivo = true;
	private Boolean ban = false;
	private Boolean admin = false;
	
	@ManyToOne
	private Indirizzo indirizzo;
	
	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	public void setAttivo(Boolean attivo) {
		this.attivo = attivo;
	}

	public Boolean getBan() {
		return ban;
	}

	public void setBan(Boolean ban) {
		this.ban = ban;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public String getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Boolean getStatoUtente() {
		return statoUtente;
	}

	public void setStatoUtente(Boolean statoUtente) {
		this.statoUtente = statoUtente;
	}

	public boolean getAttivo() {
		return attivo;
	}

	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}

	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}
	
}
