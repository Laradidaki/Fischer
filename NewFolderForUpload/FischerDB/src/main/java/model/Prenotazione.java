package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Prenotazione {

	
	@Id
	@GeneratedValue
	private Integer idPrenotazione;
	private String note;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@ManyToOne()
	private LavoroPrenotato lavoro;
	
	@OneToMany(mappedBy ="prenotazione")
	private List<CommentoPrenotazione> commenti;
	
	@JsonIgnore
	@ManyToOne()
	private Cliente cliente;

	public Integer getIdPrenotazione() {
		return idPrenotazione;
	}

	public void setIdPrenotazione(Integer idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public LavoroPrenotato getLavoro() {
		return lavoro;
	}

	public void setLavoro(LavoroPrenotato lavoro) {
		this.lavoro = lavoro;
	}

	public List<CommentoPrenotazione> getCommenti() {
		return commenti;
	}

	public void setCommenti(List<CommentoPrenotazione> commenti) {
		this.commenti = commenti;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}


	




	
}
