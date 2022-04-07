package model;

import java.time.Year;

// 2022-04-05 4BAIF
// umgestellt auf Exception-Handling
// mit serialVersionUID fuer Serialisierung
// mit toStringCsv()
// mit Freelancer (String[] zeilenTeile)

public class Freelancer extends Mitarbeiter implements PraemieBerechenbar, GehaltBerechenbar {
	private static final long serialVersionUID = 2022_03_22__13_15L;
	private int stunden;
	private float stundenSatz;
	// private Year eintrJahr; // SO NICHT!!!

	public Freelancer(float stundenSatz, int stunden) throws PersonalException {
		super(); // ruft den parameterlosen/Default-Konstruktor der Superklasse Mitarbeiter auf
		setStundenSatz(stundenSatz);
		setStunden(stunden);
	}

	public Freelancer(String name, char gesch, Year gebJahr, Year eintrJahr, float stundenSatz, int stunden)
			throws PersonalException {
		// setName(name); // so nicht!
		// setGesch(gesch); // so nicht!
		// ....
		super(name, gesch, gebJahr, eintrJahr); // Aufruf des. K. der Superklasse
		setStundenSatz(stundenSatz);
		setStunden(stunden);
	}

	public Freelancer(String[] zeilenTeile) throws PersonalException {
		super(zeilenTeile);
		// Freelancer;Anna;w;1976;2002;"10";"100.0"
		// [5] [6] im String-Array zeilenTeile
		// Achtung: ArrayIndexOutOfBoundsException
		// beim Parsen: NumberFormatException
		try {
			setStunden(Integer.parseInt(zeilenTeile[5].trim())); // int
			setStundenSatz(Float.parseFloat(zeilenTeile[6].trim())); // float
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new PersonalException("Array-Fehler bei Freelancer(zeilenTeile): " + e.getMessage());
		} catch (NumberFormatException e) {
			throw new PersonalException(
					"Zahlenumwandlungs-Fehler (gebJahr oder eintrJahr) bei Freelancer(zeilenTeile): " + e.getMessage());
		}
	}

	public int getStunden() {
		return stunden;
	}

	public float getStundenSatz() {
		return stundenSatz;
	}

	public void setStunden(int stunden) throws PersonalException {
		if (stunden > 0)
			this.stunden = stunden;
		else
			throw new PersonalException("Fehler bei setStunden(): stunden sind 0 oder kleiner (" + stunden + ")");
	}

	public void setStundenSatz(float stundenSatz) throws PersonalException {
		if (stundenSatz > 0f)
			this.stundenSatz = stundenSatz;
		else
			throw new PersonalException(
					"Fehler bei setStundenSatz(): stundenSatz ist 0.0 oder kleiner (" + stundenSatz + ")");
	}

	// so NICHT!!!
	// public void setEintrJahr(Year eintrJahr)
	// {
	// if (eintrJahr != null)
	// if (gebJahr != null)
	// {
	// int aktJahr = Year.now().getValue();
	// if (eintrJahr.getValue() >= gebJahr.getValue()+15)
	// if (eintrJahr.getValue() <= aktJahr )
	// this.eintrJahr = eintrJahr;
	// else
	// System.out.println("Falscher Parameterwert fuer setEintrJahr("+eintrJahr+")
	// !!!");
	// else
	// System.out.println("Fehler bei setEintrJahr("+eintrJahr+") -> Person ist zu
	// jung ("+berechneAlter()+")!!!");
	// }
	// else
	// System.out.println("null-Referenz bei gebJahr -> eintrJahr kann nicht
	// geprueft werden !!!");
	// else
	// System.out.println("null-Referenz fuer setEintrJahr(Year eintrJahr) !!!");
	// }

	public float berechneGehalt() {
		return stundenSatz * stunden;
	}

	public float berechnePraemie() // FUE Refactoring mit Verwendung von switch-case
	{
		float praemie = 0f;

		if (berechneDienstalter() == 15)
			praemie = berechneGehalt(); // 1x Gehalt als Praemie
		else if (berechneDienstalter() == 20)
			praemie = berechneGehalt() * 2; // 2x Gehalt als Praemie

		return praemie;
	}

	public String infoBerechnungPraemie() {
		return "Fuer 15 Jahre Mitarbeit bei einem Personalbuero erhaelt der Freelancer ein \"Gehalt\", fuer 20 Jahre zwei \"Gehaelter\"\" als Praemie.";
	}

	// ----------------------------- equals / hashCode

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Freelancer other = (Freelancer) obj;
		if (stunden != other.stunden)
			return false;
		if (Float.floatToIntBits(stundenSatz) != Float.floatToIntBits(other.stundenSatz))
			return false;
		return true;
	}

	// ---------------------------- toString / print ----------------------------

	public String toStringCsv() {
		char sep = ';';

		return super.toStringCsv() + sep + stunden + sep + stundenSatz;
	}

	public String toString() {
		return new StringBuffer().append("Freelancer ").append(super.toString()). // ohne super. -> StackOverflowError
																					// -> rekursiver Methodenaufruf
				append(" Stunden: ").append(stunden).append(" Stundensatz: ").append(stundenSatz).append(" Praemie: ")
				.append(berechnePraemie()).toString();
	}

	public void print() {
		System.out.println(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + stunden;
		result = prime * result + Float.floatToIntBits(stundenSatz);
		return result;
	}

}
