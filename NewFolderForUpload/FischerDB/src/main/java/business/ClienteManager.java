package business;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import model.Cliente;
import model.Indirizzo;
import utility.ProgrammaEntityManagerFactory;

public class ClienteManager {

	
	private static Logger log = Logger.getLogger("fischer-business");

	public static void aggiungiCliente(String email, String nome, String cognome, String username, String password,
			String cf) {
		EntityManager em = ProgrammaEntityManagerFactory.getEm();
		Cliente c = null;
		c = em.find(Cliente.class, email);
		if (c != null) {
			log.log(Level.WARNING, "il cliente esiste già");
		} else {
			Cliente cDb = new Cliente();
			Indirizzo i = new Indirizzo();
			cDb.setIdUtente(email);
			cDb.setCodiceFiscale(cf);
			cDb.setCognome(cognome);
			cDb.setNome(nome);
			cDb.setNomeUtente(username);
			cDb.setPassword(password);
			cDb.setAdmin(true);
			cDb.setAttivo(true);
			cDb.setStatoUtente(false);
			cDb.setBan(false);
			i.addUtenti(cDb);

			em.getTransaction().begin();
			em.persist(cDb);
			em.persist(i);
			em.getTransaction().commit();

			log.log(Level.INFO, "aggiunto cliente");

		}
	}

	public static Cliente trovaCliente(String idUtente) {
		EntityManager em = ProgrammaEntityManagerFactory.getEm();
		Cliente cDb = null;
		cDb = em.find(Cliente.class, idUtente);
		if (cDb != null) {
			return cDb;
		} else
			return null;

	}

	public static List<Cliente> elencoClienti() {
		EntityManager em = ProgrammaEntityManagerFactory.getEm();
		return em.createQuery("select c from Cliente c", Cliente.class).getResultList();
	}

	public static void aggiungiCliente(String codiceFiscale, String nome, String cognome, Date dataNascita) {
		EntityManager em = ProgrammaEntityManagerFactory.getEm();
	}

	public static List<Cliente> elencoClientiPerStato(String stato) {
		EntityManager em = ProgrammaEntityManagerFactory.getEm();
		switch (stato) {
		case "ban":
			return em.createQuery("select c from Cliente s where c.ban=:true", Cliente.class)
					.setParameter("true", true).getResultList();
		case "online":
			return em.createQuery("select c from Cliente s where c.statoUtente=:true", Cliente.class)
					.setParameter("true", true).getResultList();
		case "attivi":
			return em.createQuery("select c from Cliente s where c.attivo=:true", Cliente.class)
					.setParameter("true", true).getResultList();
		case "admin":
			return em.createQuery("select c from Cliente s where c.admin=:true", Cliente.class)
					.setParameter("true", true).getResultList();
		default:
			return null;
		}

	}

	public static List<Cliente> elencoClientiNonPerStato(String stato) {
		EntityManager em = ProgrammaEntityManagerFactory.getEm();
		return em.createQuery("select c from Cliente s where c.statoUtente <> :stato", Cliente.class)
				.setParameter("stato", stato).getResultList();
	}

	public static void modificaCliente(Cliente c, Indirizzo i) {
		EntityManager em = ProgrammaEntityManagerFactory.getEm();
		Cliente cDb = em.find(Cliente.class, c.getIdUtente());
		Indirizzo iDb =em.find(Indirizzo.class, cDb.getIndirizzo().getId());

		if (cDb != null) {
			em.getTransaction().begin();

			cDb.setNome(c.getNome());
			cDb.setCognome(c.getCognome());
			cDb.setNumeroTel(c.getNumeroTel());
			cDb.setDataNascita(c.getDataNascita());
			cDb.setNomeUtente(c.getNomeUtente());
			cDb.setPassword(c.getPassword());
			if(iDb != null) {
				iDb.setCap(i.getCap());
				iDb.setCitta(i.getCitta());
				iDb.setCivico(i.getCivico());
				iDb.setInterno(i.getInterno());
				iDb.setProvincia(i.getProvincia());
				iDb.setVia(i.getVia());
				
			} else {
				cDb.setIndirizzo(i);
				i.addUtenti(cDb);		
			}
			
			em.getTransaction().commit();
		}

	}
}
