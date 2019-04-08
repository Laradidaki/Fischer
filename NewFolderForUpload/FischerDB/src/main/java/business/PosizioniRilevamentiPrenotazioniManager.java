package business;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import model.LavoroPrenotato;
import model.PosizioniRilevamentiPrenotazioni;
import utility.ProgrammaEntityManagerFactory;

public class PosizioniRilevamentiPrenotazioniManager {
private static Logger log = Logger.getLogger("fischer-business");
	
	public static void aggiungiPosizioniRilevamentiPrenotazioni(PosizioniRilevamentiPrenotazioni p) {
		EntityManager em = ProgrammaEntityManagerFactory.getEm();
		LavoroPrenotato lDb = null;
		if(p.getIdPosizione() != null) {
			lDb = em.find(LavoroPrenotato.class,p.getIdPosizione());
		}
		if (lDb == null) {
			em.getTransaction().begin();
			em.persist(p); 
			em.getTransaction().commit();
			log.log(Level.INFO, "aggiunta prenotazione");
		} else {
			log.log(Level.WARNING, "la prenotazione esiste già");
		}
	}
}
