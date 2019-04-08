package utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Cliente;
import model.Indirizzo;
import model.LavoroPrenotato;
import model.Prenotazione;

public class Aggiungo {

	public static void main(String[] args) {

		EntityManagerFactory emf;
		EntityManager em;
		emf = Persistence.createEntityManagerFactory("Fischer");
		em = emf.createEntityManager();
		
			
		Cliente cl = new Cliente();
		Indirizzo i = new Indirizzo();
		cl.setIdUtente("lara@corona.it");
		cl.setPassword("babbala");
		cl.setNomeUtente("lara");
		cl.setCodiceFiscale("crnlcn90c47l400j");
		cl.setCognome("Corona");
		cl.setNome("Lara");
		cl.setAdmin(true);
		cl.setAttivo(true);

		cl.setNumeroTel("+393289999999");

		i.setVia("Manzoni");
		i.setProvincia("Roma");
		i.setCivico("100");
		i.setInterno("A");
		i.setCitta("Roma");
		i.setCap(10010);
		i.addUtenti(cl);
		
		Cliente cl1 = new Cliente();
		Indirizzo i1 = new Indirizzo();
		cl1.setIdUtente("diego.corona@hotmail.it");
		cl1.setPassword("pass");
		cl1.setNomeUtente("diego");
		cl1.setCodiceFiscale("dgncrn87d67p300g");
		cl1.setCognome("Corona");
		cl1.setNome("Diego");
		cl1.setAdmin(false);
		cl1.setAttivo(true);
		cl1.setNumeroTel("+393289999999");
		i1.setVia("Manzoni");
		i1.setProvincia("Roma");
		i1.setCivico("100");
		i1.setInterno("A");
		i1.setCitta("Roma");
		i1.setCap(10010);
		i1.addUtenti(cl1);
		
		Cliente cl2 = new Cliente();
		Indirizzo i2 = new Indirizzo();
		cl2.setIdUtente("dario.corona@hotmail.it");
		cl2.setPassword("pass");
		cl2.setNomeUtente("dario");
		cl2.setCodiceFiscale("drncrn80c57l600u");
		cl2.setCognome("Corona");
		cl2.setNome("Dario");
		cl2.setAdmin(false);
		cl2.setAttivo(false);
		cl2.setNumeroTel("+393289999999");
		i2.setVia("Manzoni");
		i2.setProvincia("Roma");
		i2.setCivico("100");
		i2.setInterno("A");
		i2.setCitta("Roma");
		i2.setCap(10010);
		i2.addUtenti(cl2);
		
		LavoroPrenotato lp =new LavoroPrenotato();
		Prenotazione pr = new Prenotazione();
		lp.setTipologiaCopertura("copertura civile in tegole");
		lp.setStatoCopertura("molto rovinata");
		lp.setLivelloUrgenza("Alto");
		pr.setNote("sono cadute molte tegole ed entra l'acqua quando piove");
		cl1.addPrenotazioni(pr);
		lp.addPrenotazione(pr);
		

		LavoroPrenotato lp1 =new LavoroPrenotato();
		Prenotazione pr1 = new Prenotazione();
		lp1.setTipologiaCopertura("copertura civile viletta");
		lp1.setStatoCopertura("rovinata");
		lp1.setLivelloUrgenza("Basso");
		pr1.setNote("si richiede la riparazione dei canali e della grondaia");
		cl.addPrenotazioni(pr1);
		lp1.addPrenotazione(pr1);
		
		

		LavoroPrenotato lp2 =new LavoroPrenotato();
		Prenotazione pr2 = new Prenotazione();
		lp2.setTipologiaCopertura("copertura civile villa di recente costruzione");
		lp2.setStatoCopertura("molto buono");
		lp2.setLivelloUrgenza("basso");
		pr2.setNote("vorremmo applicare i pannelli fotovoltaici");
		cl2.addPrenotazioni(pr2);
		lp2.addPrenotazione(pr2);
		
		
		em.getTransaction().begin();
		em.persist(cl);
		em.persist(cl1);
		em.persist(cl2);
		em.persist(lp);
		em.persist(lp1); 
		em.persist(lp2);
		em.persist(i);
		em.persist(i1);
		em.persist(i2);
		em.persist(pr);
		em.persist(pr1);
		em.persist(pr2);
		em.getTransaction().commit();
		
	}

}
