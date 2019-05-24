package mvc2;

import java.util.ArrayList;
import java.util.List;

public class StudenteDataUtil {

	public static List<Studente> getStudenti(){

		//CREARE UNA LISTA VUOTA
		List<Studente>studenti= new ArrayList<Studente>();
		
		//AGGIUNGERE I DATI/OGGETTI
		studenti.add(new Studente("Ciccio", "Cicci", "cicci96@hotmail.it"));
		studenti.add(new Studente("Paolo", "Pappo", "pappopappa@gmail.it"));
		studenti.add(new Studente("Billi", "Ballo", "ballobilli@iclod.com"));
		
		//RESTITUIRE LA LISTA
		return studenti;
		
	}
}
