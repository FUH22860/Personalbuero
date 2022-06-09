package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// 2022-04-05 4BAIF

// Umgestellt auf ArrayList
// mit public float berechneDurchnittsalter()
// mit berechneGehaltsumme()
// mit kuendigen(int)
// mit zaehleAlter(int)
// ohne getAnzahl() -> auskommentiert
// mit kuendigen(Mitarbeiter)
// mit gehaltsliste()

// mit folgenden ArrayList-Methoden:
// size(): Anzahl der Elemente in der ArrayList
// get(int): liefert die Referenz beim Index pos in der ArrayList
// add(Mitarbeiter): nimmt die Mitarbeiter-Referenz an der naechsten freien Stelle in die ArrayList auf
// remove(int): entfernt die Referenz beim Index pos aus der ArrayList

// sortiereMitarbeiter()
// sortiereNamen()

// sortiereAlter() mit Comparator-Klasse
// sortiereDienstalter() mit Comparator-Klasse

// kuendigen(name: String)
// kuendigen(gehalt: float)

// umgestellt auf Exception-Handling

// serialsiertes Speichern und Laden der Collection mitarbeiter:
// saveMitarbeiter() und loadMitarbeiter() Variante1 und Variante2 (empfohlen)

// Textfile Speichern:
// exportMitarbeiter

// 2022-03-29 exportMitarbeiterCsv

// 2022-04-01 importMitarbeiterCsc() fuer Angestellte
// 2022-04-05 importMitarbeiterCsc fuer Freelancer und Arzt

// 2022-04-07 aufnehmen erweitert um !contains() -> keine doppelstes Aufnehmen

//2022-06-07: 	getMitarbeiter() NEU
//				remove(List) NEU
//				loadMitarbeiter(String) NEU
//				loadMitarbeiter() angepasst
//				saveMitarbeiter(String) NEU
//				saveMitarbeiter() angepasst
//				exportMitarbeiter(String) NEU
//				exportMitarbeiter() angepasst

public class Personalbuero {
	private ArrayList<Mitarbeiter> mitarbeiter; // eine ArrayList ist "getypt"
	// private Mitarbeiter [] mitarbeiter;
	// private int anzahl;

	public Personalbuero() {
		// mitarbeiter = new Mitarbeiter [6];
		mitarbeiter = new ArrayList<Mitarbeiter>();
		// anzahl = 0;
	}

	// public int getAnzahl() // Ersatz durch zaehleMitarbeiter()
	// {
	// //return anzahl;
	// return mitarbeiter.size();
	// }
	
	public List<Mitarbeiter> getMitarbeiter() {  
		return mitarbeiter; 		// Achtung: Vollzugriff auf Collection
	}
	// -------------------------------- weitere ------------------------------------

	public boolean aufnehmen(Mitarbeiter ma) throws PersonalException {
		if (ma != null) {
			if (ma.berechneAlter() >= 15 && ma.berechneAlter() < 60) {
				// if (anzahl < mitarbeiter.length)
				// {
				// mitarbeiter[anzahl] = ma;
				if (!mitarbeiter.contains(ma))
					return mitarbeiter.add(ma); // liefert immer true
				else
					throw new PersonalException("Fehler bei aufnehmen(): Mitarbeiter/in schon vorhanden\n" + ma);				
				// anzahl ++;
				// return true;
				// }
				// else
				// System.out.println("Fehler bei aufnehmen(): kein Platz zum Aufnehmen");
			} else
				throw new PersonalException("Fehler bei aufnehmen(): Alter passt nicht");
		} else
			throw new PersonalException("Fehler bei aufnehmen(): null-Referenz erhalten");
		// return false;
	}

	public float berechneGehaltsumme() {
		float summe = 0f;
		Mitarbeiter mit;
		// for (int i = 0; i < anzahl; i++)
		for (int i = 0; i < mitarbeiter.size(); i++) {
			// mit = mitarbeiter[i];
			mit = mitarbeiter.get(i);
			summe += mit.berechneGehalt();
		}
		return summe;
	}

	public float berechneDurchschnittsalter() throws PersonalException {
		Mitarbeiter tempMitarbeiter;
		float summeJahre = 0.0f;
		// float avgJahre;
		// if (anzahl > 0)
		if (mitarbeiter.size() > 0) {
			// for (int i = 0; i < anzahl; i++)
			for (int i = 0; i < mitarbeiter.size(); i++) {
				// tempMitarbeiter = mitarbeiter[i];
				tempMitarbeiter = mitarbeiter.get(i);
				summeJahre += tempMitarbeiter.berechneAlter();
			}
			// avgJahre = summeJahre/anzahl; // Achtung: anzahl darf NICHT 0 sein
			// return avgJahre;
			// return summeJahre/anzahl;
			return summeJahre / mitarbeiter.size();
		} else
			throw new PersonalException("Fehler bei berechneDurchschnittsalter(): keine Mitarbeiter vorhanden");
		// return -99f; // keine Mitarbeiter, kein Durchschnittsalter
	}

	public boolean kuendigen(int pos) throws PersonalException {
		if (pos >= 0 && pos < mitarbeiter.size()) {
			// return mitarbeiter.remove(pos); // Fehler, weil Referenz "returned" wird
			mitarbeiter.remove(pos);
			return true;
		} else // pos (index) ist ungueltig
			throw new PersonalException("Fehler bei kuendigen(): Wert von pos ungueltig (" + pos + ")");
		// return false;
	}

	public boolean kuendigen(Mitarbeiter ma) throws PersonalException {
		if (ma != null) {
			return mitarbeiter.remove(ma);
		} else // ungueltige Mitarbeiter-Referenz null
			throw new PersonalException("Fehler bei kuendigen(): null-Referenz erhalten");
		// return false;
	}

	public int zaehleMitarbeiter() {
		return mitarbeiter.size();
	}

	public int zaehleAlter(int alter) throws PersonalException {
		int count = 0;
		Mitarbeiter mit;
		if (alter >= 15 && alter < 60) {
			for (int i = 0; i < mitarbeiter.size(); i++) {
				mit = mitarbeiter.get(i);
				if (mit.berechneAlter() > alter)
					count++;
			}
			return count;
		} else {
			throw new PersonalException("Fehler bei aufnehmen(): Wert von alter passt nicht (" + alter + ")");
			// return -99;
		}
	}

	public void gehaltsliste() throws PersonalException {
		// float summe = 0; // es gibt berechneGehaltsumme()
//        Mitarbeiter mit;
		System.out.println("Gehaltsliste:");
		if (mitarbeiter.size() > 0) {
			for (int i = 0; i < mitarbeiter.size(); i++) {
				// mit = mitarbeiter.get(i); // lokale Variable nicht erforderlich
				// System.out.print(mit.getName() + "\t");
				// System.out.println(mit.berechneGehalt());

				System.out.print(mitarbeiter.get(i).getName() + "\t");
				System.out.println(mitarbeiter.get(i).berechneGehalt());

				// summe += mit.berechneGehalt(); // es gibt berechneGehaltsumme()
			}
			// System.out.println("Summe: " + summe); // es gibt berechneGehaltsumme()
			System.out.println("Summe: " + berechneGehaltsumme());
		} else
			throw new PersonalException("Fehler bei gehaltsliste(): keine Mitarbeiter vorhanden");
	}

	public int zaehleAngestellte() throws PersonalException {
		int count = 0;
		// Mitarbeiter mit;
		if (mitarbeiter.size() > 0) {
			for (int i = 0; i < mitarbeiter.size(); i++) {
				// if (mit instanceof Angestellter)
				if (mitarbeiter.get(i) instanceof Angestellter)
					count++;
			}
			return count;
		} else
			throw new PersonalException("Fehler bei zaehleAngestellte(): keine Mitarbeiter im Personalbuero vorhanden");
		// return 0;
	}

	public float berechneAvgGehaltAngestellte() throws PersonalException // Optimierung moeglich
	{
		float summe = 0f;
		int count = 0; // FUE Refactoring mit Einsatz von zaehleAngestellte()
		Mitarbeiter mit;
		if (mitarbeiter.size() > 0) {
			for (int i = 0; i < mitarbeiter.size(); i++) {
				mit = mitarbeiter.get(i);
				if (mit instanceof Angestellter) {
					summe += mit.berechneGehalt();
					count++;
				}
			}
			return summe / count;
		} else
			throw new PersonalException(
					"Fehler bei berechneAvgGehaltAngestellte(): keine Mitarbeiter/Angestellte/Freelancer im Personalbuero vorhanden");
		// return -99f;
	}
	// ---------------------------------- sorts ---------------------------------

	public void sortiereMitarbeiter() // aufsteigend nach Gehalt
	{
		Collections.sort(mitarbeiter);
	}

	public void sortiereNamen() // aufsteigend nach Name
	{
		NameComparator nameComparator = new NameComparator();
		Collections.sort(mitarbeiter, nameComparator);
	}

	public void sortiereAlter() // mit anonymer innerer Klasse in Mitarbeiter
	{
		if (!mitarbeiter.isEmpty()) {
			Collections.sort(mitarbeiter, new Mitarbeiter.AlterComparator());
		} else {
			System.out.println("Es sind keine Mitarbeiterinnen/Mitarbeiter zum Sortieren vorhanden");
		}
	}

//    public void sortiereAlter()
//    {
//    	AlterComparator alterComparator = new AlterComparator();
//    	Collections.sort(mitarbeiter, alterComparator);
//    	
//    	// anonymens Objekt AlterComparator() direkt an die sort() uebergeben
//    	
//    	//Collections.sort(mitarbeiter, new AlterComparator());
//    	
	// "anonyme" innere Klasse
//    	Collections.sort(mitarbeiter, new Comparator<Mitarbeiter>() {
//
//			@Override
//			public int compare(Mitarbeiter m1, Mitarbeiter m2) {
//			if (m1.berechneAlter() > m2.berechneAlter())
//				return 1; // m1 ist aelter als m2
//			else
//				if (m1.berechneAlter() < m2.berechneAlter())
//					return -1; // m1 ist juenger als m2
//				else // gleiches Alter
//					return 0;
//			}
//		});
//
//    }

	public void sortiereDienstalter() {
		Collections.sort(mitarbeiter, new DienstalterComparator());
	}

	// -------------------------------- kuendigen mehrere (Erweiterung) ---

	public int kuendigen(String name) throws PersonalException {
		int anz = 0;
		Mitarbeiter mit;

		if (name != null) {
			if (mitarbeiter.size() > 0) {
				Iterator<Mitarbeiter> iter = mitarbeiter.iterator();
				while (iter.hasNext()) {
					mit = iter.next();
					if (mit.getName().equals(name)) {
						iter.remove();
						anz++;
					}
				}
				return anz;
			} else
				throw new PersonalException("Fehler bei kuendigen(name): keine Mitarbeiter vorhanden");
			// return -1;
		} else
			throw new PersonalException("Fehler bei kuendigen(name): null-Referenz fuer name erhalten");
		// return -1;
	}

	public float kuendigen(float gehalt) throws PersonalException {
		float summe = 0f;
		Mitarbeiter mit;
		if (gehalt >= 0f) {
			Iterator<Mitarbeiter> iter = mitarbeiter.iterator();
			while (iter.hasNext()) {
				mit = iter.next();
				if (mit.berechneGehalt() > gehalt) {
					summe += mit.berechneGehalt();
					iter.remove();
				}
			}
			return summe;
		} else {
			throw new PersonalException("Fehler bei kuendigen(gehalt): negatives gehalt erhalten (" + gehalt + ")");
			// return -1f;
		}
	}
	
	public void remove(List<Mitarbeiter> auswahl) throws PersonalException
	{
		if (auswahl != null)
			mitarbeiter.removeAll(auswahl);
		else
			throw new PersonalException("Fehler bei remove(auswahl): null-Referenz fuer auswahl erhalten");
	}

	// --------------------------------- files ----------------------------------
	public void saveMitarbeiter(String strPfadName) throws PersonalException {
		if(strPfadName != null)
		{
			try ( // try with ressources -> close() erfolgt "automatisch"
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(strPfadName));) {
				// hier erfolgt das "Speichern"
				oos.writeObject(mitarbeiter);

			} catch (FileNotFoundException e) {
				throw new PersonalException("Datei-Fehler bei saveMitarbeiter(): " + e.getMessage());
			} catch (IOException e) {
				throw new PersonalException("Eingabe/Ausgabe-Fehler bei saveMitarbeiter(): " + e.getMessage());
			}
		}
		else
			throw new PersonalException("Fehler bei saveMitarbeiter(): null-Referenz fuer strPfadName erhalten");			
	}
	public void saveMitarbeiter() throws PersonalException {

		String fSep = System.getProperty("file.separator");
		//String strPfadName = "c:\\scratch\\mitarbeiter.ser"; 
		String strPfadName = "c:"+ fSep + "scratch" + fSep + "mitarbeiter.ser";
		saveMitarbeiter(strPfadName);
//		try ( // try with ressources -> close() erfolgt "automatisch"
//				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(strPfadName));) {
//			// hier erfolgt das "Speichern"
//			oos.writeObject(mitarbeiter);
//
//		} catch (FileNotFoundException e) {
//			throw new PersonalException("Datei-Fehler bei saveMitarbeiter(): " + e.getMessage());
//		} catch (IOException e) {
//			throw new PersonalException("Eingabe/Ausgabe-Fehler bei saveMitarbeiter(): " + e.getMessage());
//		}
	}

//	loadMitarbeiter Variante 2 OHNE suppressWarning -> empfohlen
	public void loadMitarbeiter(String strPfadName) throws PersonalException {
		if (strPfadName != null)
		{
	
			try ( ObjectInputStream ois = 
					new ObjectInputStream(new FileInputStream(strPfadName)))
			{
							
				List <?> tempMitarbeiter = (List <?>) ois.readObject();
				
				mitarbeiter.clear(); // ersetzen und NICHT hinzufuegen
				
				for (Object o : tempMitarbeiter)
				{
					if (o instanceof Mitarbeiter)
					{
						aufnehmen((Mitarbeiter)o);
					}
				}
			
			} catch (FileNotFoundException e) {
				throw new PersonalException("Datei-Fehler bei loadMitarbeiter(): " + e.getMessage());
			} catch (IOException e) {
				throw new PersonalException("Eingabe/Ausgabe-Fehler bei loadMitarbeiter(): " + e.getMessage());
			} catch (ClassNotFoundException e) {
				throw new PersonalException("Klassen-Fehler bei loadMitarbeiter(): " + e.getMessage());
			}
		}
		else
			throw new PersonalException("Fehler bei loadMitarbeiter(): null-Referenz fuer strPfadName erhalten");			
	}	
	public void loadMitarbeiter() throws PersonalException
	{
		
		String fSep = System.getProperty("file.separator");
		//String strPfadName = "c:\\scratch\\mitarbeiter.ser"; 	
		String strPfadName = "c:"+ fSep + "scratch" + fSep + "mitarbeiter.ser";		
		loadMitarbeiter(strPfadName);
		
//		try ( ObjectInputStream ois = 
//				new ObjectInputStream(new FileInputStream(strPfadName)))
//		{
//						
//			List <?> tempMitarbeiter = (List <?>) ois.readObject();
//			
//			mitarbeiter.clear(); // ersetzen und NICHT hinzufuegen
//			
//			for (Object o : tempMitarbeiter)
//			{
//				if (o instanceof Mitarbeiter)
//				{
//					aufnehmen((Mitarbeiter)o);
//				}
//			}
//		
//		} catch (FileNotFoundException e) {
//			throw new PersonalException("Datei-Fehler bei loadMitarbeiter(): " + e.getMessage());
//		} catch (IOException e) {
//			throw new PersonalException("Eingabe/Ausgabe-Fehler bei loadMitarbeiter(): " + e.getMessage());
//		} catch (ClassNotFoundException e) {
//			throw new PersonalException("Klassen-Fehler bei loadMitarbeiter(): " + e.getMessage());
//		}
	}
	
	// Variante1: es geht "typsicherer" -> Variante2
//	@SuppressWarnings("unchecked") // funktionsfaehige allerdings nicht empfohlene Variante1
//	public void loadMitarbeiter() throws PersonalException
//	{
//		String strPfadName = "c:\\scratch\\mitarbeiter.ser"; 
//		
//		try ( ObjectInputStream ois = 
//				new ObjectInputStream(new FileInputStream(strPfadName)))
//		{
//			// nicht empfohlene Variante1
//			mitarbeiter = (ArrayList<Mitarbeiter>) ois.readObject();
//			
//		} catch (FileNotFoundException e) {
//			throw new PersonalException("Datei-Fehler bei loadMitarbeiter(): " + e.getMessage());
//		} catch (IOException e) {
//			throw new PersonalException("Eingabe/Ausgabe-Fehler bei loadMitarbeiter(): " + e.getMessage());
//		} catch (ClassNotFoundException e) {
//			throw new PersonalException("Klassen-Fehler bei loadMitarbeiter(): " + e.getMessage());
//		}
//	}

	public void exportMitarbeiter(String strPfadName) throws PersonalException {
		String nLn = System.getProperty("line.separator");
		if (strPfadName != null)
		{
			try ( BufferedWriter bw = new BufferedWriter(new FileWriter(strPfadName)))
			{
				for (Mitarbeiter mit : mitarbeiter)
				{
					//bw.write(mit.toString() + "\n"); 
					bw.write(mit.toString() + nLn); // mit Line-Separator
				}
				
			} catch (IOException e) {
				throw new PersonalException("Eingabe/Ausgabe-Fehler bei exportMitarbeiter()" 
											+ e.getMessage());
			}
		}
		else
			throw new PersonalException("Fehler bei exportMitarbeiter(): null-Referenz fuer strPfadName erhalten");			
	}	
	
	public void exportMitarbeiter() throws PersonalException
	{
		
		String fSep = System.getProperty("file.separator");
		String strPfadName = "c:"+ fSep + "scratch" + fSep + "mitarbeiter.txt";	
		exportMitarbeiter(strPfadName);
//		String nLn = System.getProperty("line.separator");
//		try ( BufferedWriter bw = new BufferedWriter(new FileWriter(strPfadName)))
//		{
//			for (Mitarbeiter mit : mitarbeiter)
//			{
//				//bw.write(mit.toString() + "\n"); 
//				bw.write(mit.toString() + nLn); // mit Line-Separator
//			}
//			
//		} catch (IOException e) {
//			throw new PersonalException("Eingabe/Ausgabe-Fehler bei exportMitarbeiter()" 
//										+ e.getMessage());
//		}
	}
	
	public void exportMitarbeiterCsv() throws PersonalException
	{
		String fSep = System.getProperty("file.separator");
		String strPfadName = "c:"+ fSep + "scratch" + fSep + "mitarbeiter.csv";	
		String nLn = System.getProperty("line.separator");
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(strPfadName)))
		{
			StringBuilder sb = new StringBuilder(100000);
			for (Mitarbeiter mit : mitarbeiter)
				sb.append(mit.toStringCsv()).append(nLn); // .append("\n");
			bw.write(sb.toString());
		} catch (IOException e) {
			throw new PersonalException("Eingabe/Ausgabe-Fehler bei exportMitarbeiterCsv()" 
										+ e.getMessage());
		}
	}
	
	// NEU 2022-04-06 mit Freelancer und Arzt
	public void importMitarbeiterCsv() throws PersonalException
	{
		String fSep = System.getProperty("file.separator"); 
		String strPfadName = "c:"+fSep+"scratch"+fSep+"mitarbeiter.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(strPfadName)))
		{
			String zeile;
			String[] zeilenTeile;
			String sep = ";"; // erwartetes Trennzeichen in der csv-Datei
			
			// Muster: "Vorauslesen"
			zeile = br.readLine(); // wenn keine Zeile gefunden, dann return null
			
			while(zeile != null)
			{
				zeilenTeile = zeile.trim().split(sep);
				
				// Welcher Konstruktor wird aufgerufen?
				// Wie ermitteln wir den Mitarbeiter-Typ?
				
				if (zeile.contains("Angestellter"))
				{
					aufnehmen(new Angestellter(zeilenTeile));
				}
				else
					if (zeile.contains("Freelancer"))
					{
						aufnehmen(new Freelancer(zeilenTeile));
					}							
					else
						if (zeile.contains("Arzt"))
						{
							aufnehmen(new Arzt(zeilenTeile));
						}								
						else 
							; // hier Mitarbeiter-Typ(en)
							  // zukuenftiger Erweiterungen ergaenzen
				zeile = br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			throw new PersonalException("Datei-Fehler bei importMitarbeiterCsv(): " 
					+ e.getMessage());
		} catch (IOException e) {
			throw new PersonalException("Eingabe/Ausgabe-Fehler bei importMitarbeiterCsv(): " 
					+ e.getMessage());
		}
	}

	// -------------------------- print / toString ---------------------------------
	public String toString() {
		Mitarbeiter mit;
		// String str = "";
		// if (anzahl > 0)
		// {
		// for (int i = 0; i < anzahl; i++)
		// {
		// mit = mitarbeiter[i];
		// str += mit.toString() + "\n";
		// }
		// }
		// else
		// str += "keine Mitarbeiter im Personalbuero";
		// return str;
		StringBuffer sb = new StringBuffer(10000);
		// if (anzahl > 0)
		if (mitarbeiter.size() > 0) {
			// for (int i = 0; i < anzahl; i++)
			for (int i = 0; i < mitarbeiter.size(); i++) {
				// mit = mitarbeiter[i];
				mit = mitarbeiter.get(i);
				sb.append(mit).append('\n');
			}
		} else
			sb.append("keine Mitarbeiter im Personalbuero");
		return sb.toString();
	}
	
	public void print() {
		System.out.println(this);
	}
}
