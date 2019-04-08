package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Indirizzo {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String via;
	private String civico;
	private String interno;
	private String citta;
	private String provincia;
	private Integer cap;
	
	@JsonIgnore
	@OneToMany(mappedBy="indirizzo")
	private List<UtenteRegistrato> utenti;
	
	public List<UtenteRegistrato> getUtenti() {
		return utenti;
	}
	public void setUtenti(List<UtenteRegistrato> utenti) {
		this.utenti = utenti;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getCivico() {
		return civico;
	}
	public void setCivico(String civico) {
		this.civico = civico;
	}
	public String getInterno() {
		return interno;
	}
	public void setInterno(String interno) {
		this.interno = interno;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public Integer getCap() {
		return cap;
	}
	public void setCap(Integer cap) {
		this.cap = cap;
	}
	
	public void addUtenti(UtenteRegistrato u) {
		if (this.utenti == null) {
			this.utenti = new ArrayList<UtenteRegistrato>();
		}
		this.utenti.add(u);
		u.setIndirizzo(this);
	}
	
}
