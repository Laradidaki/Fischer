package business;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import model.LavoroPrenotato;
import model.Prenotazione;
import utility.ProgrammaEntityManagerFactory;


public class PrenotazioneManager {

	private static Logger log = Logger.getLogger("fischer-business");

	public static void aggiungiPrenotazione(Prenotazione p) {
		EntityManager em = ProgrammaEntityManagerFactory.getEm();
		Prenotazione pDb = null;
		if (p.getIdPrenotazione() != null) {
			pDb = em.find(Prenotazione.class, p.getIdPrenotazione());
		}
		if (pDb == null) {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			log.log(Level.INFO, "aggiunta prenotazione");
		} else {
			log.log(Level.WARNING, "la prenotazione esiste già");
		}
	}

	public static List<Prenotazione> elencoPrenotazioni() {
		EntityManager em = ProgrammaEntityManagerFactory.getEm();
		return em.createQuery("select p from Prenotazione p", Prenotazione.class).getResultList();
	}

	public static void eliminaPrenotazione(Integer idDaEliminare) {
		EntityManager em = ProgrammaEntityManagerFactory.getEm();
		Prenotazione pr = em.find(Prenotazione.class, idDaEliminare);
		if (pr != null) {
			LavoroPrenotato lp = pr.getLavoro();
			if (lp.getPrenotazioni().size() == 1) {
				em.getTransaction().begin();
				em.remove(lp);
				em.getTransaction().commit();
			} else {
				em.getTransaction().begin();
				em.remove(pr);
				em.getTransaction().commit();
			}
		}
	}

	public static Prenotazione perId(Integer parameter) {
		if (parameter != null) {
			EntityManager em = ProgrammaEntityManagerFactory.getEm();
			return em.find(Prenotazione.class, parameter);
		}
		return null;
	}

	public static void AggiungiPrenotazioneAndroid(Prenotazione p, LavoroPrenotato l) {
		EntityManager em = ProgrammaEntityManagerFactory.getEm();
		Prenotazione pDb = null;
		if (p.getIdPrenotazione() != null) {
			pDb = em.find(Prenotazione.class, p.getIdPrenotazione());
		}
		if (pDb == null) {
			em.getTransaction().begin();
			em.persist(p);
			em.persist(l);
			em.getTransaction().commit();
			log.log(Level.INFO, "aggiunta prenotazione");
		} else {
			log.log(Level.WARNING, "la prenotazione esiste già");
		}
		
	}

}
