package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class LavoroPrenotato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idLavoro;
	private String tipologiaCopertura;
	private String statoCopertura;
	private String livelloUrgenza;

	@JsonIgnore
	@OneToMany(mappedBy = "lavoro", cascade = { CascadeType.REMOVE })
	private List<Prenotazione> prenotazioni;

	@JsonIgnore
	@ManyToMany(mappedBy = "lavoriPrenotati")
	private List<PosizioniRilevamentiPrenotazioni> posizioni;

	public Integer getIdLavoro() {
		return idLavoro;
	}

	public void setIdLavoro(Integer idLavoro) {
		this.idLavoro = idLavoro;
	}


	public String getTipologiaCopertura() {
		return tipologiaCopertura;
	}

	public void setTipologiaCopertura(String tipologiaCopertura) {
		this.tipologiaCopertura = tipologiaCopertura;
	}

	public String getStatoCopertura() {
		return statoCopertura;
	}

	public void setStatoCopertura(String statoCopertura) {
		this.statoCopertura = statoCopertura;
	}

	public String getLivelloUrgenza() {
		return livelloUrgenza;
	}

	public void setLivelloUrgenza(String livelloUrgenza) {
		this.livelloUrgenza = livelloUrgenza;
	}

	public List<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(List<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public List<PosizioniRilevamentiPrenotazioni> getPosizioni() {
		return posizioni;
	}

	public void setPosizioni(List<PosizioniRilevamentiPrenotazioni> posizioni) {
		this.posizioni = posizioni;
	}

	public void addPrenotazione(Prenotazione pn) {
		if (this.prenotazioni == null) {
			this.prenotazioni = new ArrayList<Prenotazione>();
		}
		this.prenotazioni.add(pn);
		pn.setLavoro(this);
	}

	

}
