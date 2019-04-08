package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Cliente extends UtenteRegistrato {

	private String codiceFiscale; 
	private String nome;
	private String cognome;
	@Temporal (TemporalType.DATE)
	private Date dataNascita;
	private Integer dislike;

	@OneToMany(mappedBy="cliente")
	private List<CommentoPrenotazione> commenti;
	
	
	@OneToMany(mappedBy= "cliente")
	private List<Prenotazione> prenotazioni;

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public Integer getDislike() {
		return dislike;
	}

	public void setDislike(Integer dislike) {
		this.dislike = dislike;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public List<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(List<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public void addPrenotazioni(Prenotazione p) {
		if (this.prenotazioni == null) {
			this.prenotazioni = new ArrayList<Prenotazione>();
		}
		this.prenotazioni.add(p);
		p.setCliente(this);
	}
	
}
