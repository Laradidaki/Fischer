package business;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import model.LavoroPrenotato;
import utility.ProgrammaEntityManagerFactory;

public class LavoroPrenotatoManager {

	private static Logger log = Logger.getLogger("fischer-business");

	public static void aggiungiLavoroPrenotato(LavoroPrenotato l) {
		EntityManager em = ProgrammaEntityManagerFactory.getEm();
		LavoroPrenotato lDb = null;
		if (l.getIdLavoro() != null) {
			lDb = em.find(LavoroPrenotato.class, l.getIdLavoro());
		}
		if (lDb == null) {
			em.getTransaction().begin();
			em.persist(l);
			em.getTransaction().commit();
			log.log(Level.INFO, "aggiunto lavoro");
		} else {
			log.log(Level.WARNING, "lavoro già esistente");
		}
	}

	public static List<LavoroPrenotato> elencoLavoriPrenotati() {
		EntityManager em = ProgrammaEntityManagerFactory.getEm();
		return em.createQuery("select l from LavoroPrenotato l", LavoroPrenotato.class).getResultList();
	}

	public static void aggiungiLavoroPrenotato(String tipologiaCopertura, String statoCopertura, 
			String livelloUrgenza) {
		EntityManager em = ProgrammaEntityManagerFactory.getEm();
		/*
		 * if (r != null && s != null) { LavoroPrenotato l = new LavoroPrenotato(); l.setPrenotazione(p);
		 * l.setCliente(r); l.setData(data); aggiungiLavoroPrenotato(l); } else {
		 * log.log(Level.WARNING, "cliente o prenotazione inesistenti"); }
		 */
	}

	public static void eliminaLavoroPrenotato(Integer idDaEliminare) {
		EntityManager em = ProgrammaEntityManagerFactory.getEm();
		LavoroPrenotato lp = em.find(LavoroPrenotato.class, idDaEliminare);
		if (lp != null) {
			em.getTransaction().begin();
			em.remove(lp);
			em.getTransaction().commit();
		}

	}

	public static LavoroPrenotato perId(Integer parameter) {
		if (parameter != null) {
			EntityManager em = ProgrammaEntityManagerFactory.getEm();
			return em.find(LavoroPrenotato.class, parameter);
		}
		return null;
	}

	public static void modificaLavoroPrenotato(LavoroPrenotato l, Integer id) {
		EntityManager em = ProgrammaEntityManagerFactory.getEm();
		LavoroPrenotato lDb = em.find(LavoroPrenotato.class, id);
		
		if (lDb != null) {

			em.getTransaction().begin();
			
			lDb.setTipologiaCopertura(l.getTipologiaCopertura());
			lDb.setStatoCopertura(l.getStatoCopertura());
			lDb.setLivelloUrgenza(l.getLivelloUrgenza());
			
			em.getTransaction().commit();
			log.log(Level.INFO, "aggiunto lavoro");
		} else {
			log.log(Level.WARNING, "lavoro inesistente");
		}
	}
	
}
