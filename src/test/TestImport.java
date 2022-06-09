package test;

import java.time.Year;
import model.Angestellter;
import model.Freelancer;
import model.PersonalException;
import model.Personalbuero;

// 2022-04-05

public class TestImport
{
	public static void main(String[] args)
	{
		String nLn = System.getProperty("line.separator");
		
		try
		{
			Personalbuero pb = new Personalbuero();
			pb.aufnehmen(new Angestellter("Hans", 'x', Year.of(1965), Year.of(1985)));
			System.out.println(pb);
			System.out.println();
			
			// zeilenTeile-Konstruktoren testen
			// TODO FUE Freelancer
			// TODO FUE Arzt
			
//			pb.aufnehmen(new Angestellter(new String[] {})); // Array-Fehler: Index 1 out of bounds for length 0
//			pb.aufnehmen(new Angestellter(new String[] {"", "", "", "",""})); // Fehler: falscher Parameterwert name		
//			pb.aufnehmen(new Angestellter(new String[] {"", "Hannes", "", "",""})); // Fehler: falscher Parameterwert gesch	
//			pb.aufnehmen(new Angestellter(new String[] {"", "Hannes", "m", "neunzehnhundertfuenfundsechzig",""})); // Fehler: falscher Paramterwert gebJahr	
//			pb.aufnehmen(new Angestellter(new String[] {"", "Hannes", "m", "1965","neunzehnhundertfuenfundachzig"})); // Fehler: falscher Paramterwert eintrJahr	
			pb.aufnehmen(new Angestellter(new String[] {"Angestellter", "Hannes", "m", "1965","1985"}));
			
			System.out.println(pb); // Hans, Hannes
			System.out.println();			

			pb.importMitarbeiterCsv();
			System.out.println(pb);	// Hans, Hannes, Alfred, Anna, Wolfgang
			System.out.println();
			
			try {
				Freelancer f2 = new Freelancer("Anna", 'w', Year.of(1976), Year.of(2002), 100f, 10);
				pb.aufnehmen(f2); // Fehler schon vorhanden // TODO kein Fehler	
			}
			catch (PersonalException e) { 
				System.out.println("!!! Fehler bei TestImport !!!" +nLn+ e.getMessage());
				System.out.println();
			}
			
			System.out.println(pb);	// Hans, Hannes, Alfred, Anna, Wolfgang
			System.out.println();
			
			Angestellter a1 = new Angestellter("Alfred", 'm', Year.of(1977), Year.now());
			pb.aufnehmen(a1); // Fehler schon vorhanden // TODO kein Fehler		

			System.out.println(pb);	// Hans, Hannes, Alfred, Anna, Wolfgang
			System.out.println();			
			
		}
		catch (PersonalException e)
		{
			System.out.println("!!! Fehler bei TestImport !!!" +nLn+ e.getMessage());
		}
	}
}
