package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class CommentoPrenotazione {


	@Id
	@GeneratedValue
	 private Integer Idcommento;
	 private String testoCommento;
	 @ManyToOne
	private Cliente cliente;
	 @ManyToOne
	 private Prenotazione prenotazione;
	 
	public Integer getIdcommento() {
		return Idcommento;
	}
	public void setIdcommento(Integer idcommento) {
		Idcommento = idcommento;
	}
	public String getTestoCommento() {
		return testoCommento;
	}
	public void setTestoCommento(String testoCommento) {
		this.testoCommento = testoCommento;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Prenotazione getPrenotazione() {
		return prenotazione;
	}
	public void setPrenotazione(Prenotazione prenotazione) {
		this.prenotazione = prenotazione;
	}

	 
	 

}
