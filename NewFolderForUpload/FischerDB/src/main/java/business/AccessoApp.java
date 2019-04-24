package business;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import model.UtenteRegistrato;
import utility.ProgrammaEntityManagerFactory;


public class AccessoApp {
	
	private static Logger log = Logger.getLogger("business");

	//public static void aggiungiAnimaleSegnalato(AnimaleSegnalato a) {
//		EntityManager em = Programma.getEm();
//		AnimaleSegnalato aDb = null;
//		if (a.getIdAnimale() != null) {
//			aDb = em.find(AnimaleSegnalato.class, a.getIdAnimale());

		public static List <UtenteRegistrato> elencoUtenti() {
			EntityManager em = ProgrammaEntityManagerFactory.getEm();
			return em.createQuery("select u from UtenteRegistrato u", UtenteRegistrato.class).getResultList();
		}

		public static Boolean login(String id, String password) {
			Boolean result = false;
			EntityManager em = ProgrammaEntityManagerFactory.getEm();
			UtenteRegistrato u = null;
			if (id != null) {
				u = em.find(UtenteRegistrato.class, id);
				if (u != null) {
					if (!u.getAdmin()) {
						log.warning("l' utente non ha i privilegi di amministrazione");
					}
					if (!u.getAttivo()) {
						log.warning("l'account è stato disattivato");
					}
					if (!u.getPassword().equals(password)) {
						log.warning("accesso con password errata");
					}
					result = u.getAdmin() && u.getAttivo() && u.getPassword().equals(password);
				} else {
					log.warning("l'utente " + id + " non esiste");
				}

			}
			log.info("accesso di " + id + ": " + result);
			return result;
			
		}
		public static UtenteRegistrato loginAndroid(String email, String password) {
			EntityManager em = ProgrammaEntityManagerFactory.getEm();
			UtenteRegistrato result = em.find(UtenteRegistrato.class, email);
			if (result != null && result.getPassword().equals(password)) {
				return result;
			} else {
				return null;
			}
		}

		
		public static void logout(String id) {
			EntityManager em = ProgrammaEntityManagerFactory.getEm();
			UtenteRegistrato ut = new UtenteRegistrato();
			
		}
	}


