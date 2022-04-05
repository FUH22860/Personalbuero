package test;

import java.time.Year;
import model.Angestellter;
import model.Arzt;
import model.Freelancer;
import model.PersonalException;
import model.Personalbuero;

// 2022-03-31 um Arzt erweitert

public class TestExport
{
	public static void main(String[] args)
	{
		String nLn = System.getProperty("line.separator");
		
		System.out.println("+++++++++++++++++++++++ testExportCsvMitarbeiter +++++++++++++++++++++++++\n");
		try {
			Personalbuero pb = new Personalbuero();

			Angestellter a1 = new Angestellter("Alfred", 'm', Year.of(1977), Year.now());
			pb.aufnehmen(a1);

			Freelancer f2 = new Freelancer("Anna", 'w', Year.of(1976), Year.of(2002), 100f, 10);
			pb.aufnehmen(f2);
			
			Arzt ar1 = new Arzt("Wolfgang", 'm', Year.of(1964), Year.now(), 40, 1200f);
			pb.aufnehmen(ar1);		

			System.out.println(pb); // Alfred, Anna, Wolfgang
			System.out.println();

			pb.exportMitarbeiterCsv();
			System.out.println("exportMitarbeiterCsv() wurde ausgefuehrt");
		}
		catch (PersonalException e)
		{
			System.out.println("!!! Fehler bei TestExport !!!" +nLn+ e.getMessage());
		}
		
	}
}
