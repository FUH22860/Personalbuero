package model;

import java.io.Serializable;

// 2022-03-21 4BAIF
// Klasse abstract
// Methode berechneGehalt() abstract
// 2022-01-26: Debugging toString() - mit ?-Operator gefixt
// Interface Comparable

// Umstellung auf EH

import java.time.Year;
import java.util.Comparator;

public abstract class Mitarbeiter implements Comparable<Mitarbeiter>, Serializable
//public class Mitarbeiter implements Comparable <Mitarbeiter> // zum Testen
{

	private static final long serialVersionUID = 2022_03_22__13_15L;
	private String name;
	private Year gebJahr, eintrJahr;
	private char gesch;

	public Mitarbeiter() throws PersonalException // zum Testen
	{
		setName("Anna");
		setGesch('w');
		setGebJahr(Year.of(2001));
		setEintrJahr(Year.now());
	}

	public Mitarbeiter(String name, char gesch, Year gebJahr, Year eintrJahr) throws PersonalException {
		setName(name);
		setGesch(gesch);
		setGebJahr(gebJahr);
		setEintrJahr(eintrJahr);
	}

	// ------------------------------------ getter ------------------------
	public String getName() {
		return name;
	}

	public char getGesch() {
		return gesch;
	}

	public Year getGebJahr() {
		return gebJahr;
	}

	public Year getEintrJahr() {
		return eintrJahr;
	}

	// ------------------------------------ setter ------------------------
	public void setName(String name) throws PersonalException {
		if (name != null)
			if (name.length() >= 2)
				this.name = name;
			else
				throw new PersonalException("Falscher Parameterwert fuer setName(" + name + ") !!!");
		else
			throw new PersonalException("null-Referenz fuer setName(String name) !!!");
	}

	public void setGesch(char gesch) throws PersonalException {
		if (gesch == 'm' || gesch == 'M' || gesch == 'w' || gesch == 'W' || gesch == 'x' || gesch == 'X')
			this.gesch = Character.toLowerCase(gesch); // Character ist "Wrapper"-Klasse von char
		else
			throw new PersonalException("Falscher Parameterwert fuer setGesch(" + gesch + ") !!!");
	}

	public void setGebJahr(Year gebJahr) throws PersonalException {
		// int aktJahr = Year.now().getValue();
		Year aktYear = Year.now();
		if (gebJahr != null)
			// if (gebJahr.getValue() >= aktJahr-100 && gebJahr.getValue() <= aktJahr )
			if (!gebJahr.isBefore(aktYear.minusYears(100)) && !gebJahr.isAfter(aktYear))
				this.gebJahr = gebJahr;
			else
				throw new PersonalException("Falscher Parameterwert fuer setGebJahr(" + gebJahr + ") !!!");
		else
			throw new PersonalException("null-Referenz fuer setGebJahr(Year gebJahr) !!!");
	}

	public void setEintrJahr(Year eintrJahr) throws PersonalException {
		if (eintrJahr != null)
			if (gebJahr != null) {
				int aktJahr = Year.now().getValue();
				if (eintrJahr.getValue() >= gebJahr.getValue() + 15)
					if (eintrJahr.getValue() <= aktJahr)
						this.eintrJahr = eintrJahr;
					else
						throw new PersonalException("Falscher Parameterwert fuer setEintrJahr(" + eintrJahr + ") !!!");
				else
					throw new PersonalException("Fehler bei setEintrJahr(" + eintrJahr + ") -> Person ist zu jung ("
							+ berechneAlter() + ")!!!");
			} else
				throw new PersonalException("null-Referenz bei gebJahr -> eintrJahr kann nicht geprueft werden !!!");
		else
			throw new PersonalException("null-Referenz fuer setEintrJahr(Year eintrJahr) !!!");
	}

	// -------------------------------------- weitere -----------------------
	public int berechneAlter() {
		// return 2021 - gebJahr; // ganz schlecht...

		// Bessere Loesung in Einzelschritten:
		// Year datum = Year.now();
		// int aktJahr = datum.getValue();
		// int alter = aktJahr - gebJahr;
		// return alter;

		// Bessere Loesung in einem Schritt:
		return (gebJahr != null ? Year.now().getValue() - gebJahr.getValue() : -99); // Fehlercode
	}

	public int berechneDienstalter() {
		return (eintrJahr != null ? Year.now().getValue() - eintrJahr.getValue() : -99); // Fehlercode
	}

	// public float berechneGehalt()
	// {
	// return 1500f + 50f*berechneDienstalter();
	// }

//    public float berechneGehalt() // zum UMSTELLEN und TESTEN
//    {
//    	return 0f;
//    }

	public abstract float berechneGehalt(); // alle Subklassen
	// MUESSEN diese Methode implementieren
	// Ausnahme: diese Subklasse ist auch abstrakt

	// public abstract int berechneUrlaubsanspruch() // Beispiel fuer einen
	// Anwendungsfall einer abstrakten Methode
	// ;

	// --------------------------------- compareTo -----------------------------

	@Override
	public int compareTo(Mitarbeiter o) { // "natuerliche" Reihenfolge von Gehalt
		if (o != null) {
			if (berechneGehalt() > o.berechneGehalt())
				return 1;
			else if (berechneGehalt() < o.berechneGehalt())
				return -1;
			else
				return 0;
		} else // Annahme bis zum ExceptionHandling, dann NullPointerException
			return 1;
	}

	// ----------------------------------- innere Klasse
	// --------------------------------

	public static class AlterComparator implements Comparator<Mitarbeiter> {

		@Override
		public int compare(Mitarbeiter o1, Mitarbeiter o2) {

			if (o1 != null && o2 != null)
				if (o1.berechneAlter() > o2.berechneAlter())
					return 1;
				else if (o1.berechneAlter() < o2.berechneAlter())
					return -1;
				else // o1.berechneAlter() == o2.berechneAlter()
					return 0;
			else // o1 == null || o2 == null
				return 1;
		}
	}

	public void print() {
		System.out.println(this); // System.out.println(toString())
	}
	
	public String toStringCsv() {
		char sep = ';'; // Delimiter
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(getClass().getSimpleName()).append(sep);
		sb.append(name).append(sep);
		sb.append(gesch).append(sep);
		sb.append(gebJahr).append(sep);
		sb.append(eintrJahr).append(sep);
		
		return sb.toString();
	}
}
