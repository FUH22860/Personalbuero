package model;

// 2022-03-22 4BAIF
// umgestellt auf Exception-Handling
// mit serialVersionUID fuer Serialisierung

import java.time.Year;
public class Freelancer extends Mitarbeiter implements PraemieBerechenbar, GehaltBerechenbar
{
	private static final long serialVersionUID = 2022_03_22__13_15L;
    private int stunden;
    private float stundenSatz;
    //private Year eintrJahr; // SO NICHT!!!

    public Freelancer(float stundenSatz, int stunden) throws PersonalException
    {
        super(); // ruft den parameterlosen/Default-Konstruktor der Superklasse Mitarbeiter auf
        setStundenSatz(stundenSatz);
        setStunden(stunden);
    }
    
    public Freelancer(String name, char gesch, Year gebJahr, Year eintrJahr, float stundenSatz, int stunden) throws PersonalException
    {
        // setName(name);   // so nicht!
        // setGesch(gesch);  // so nicht!
        // ....
        super(name, gesch, gebJahr, eintrJahr); // Aufruf des. K. der Superklasse
        setStundenSatz(stundenSatz);
        setStunden(stunden);        
    }

    public int getStunden()
    {
        return stunden;
    }

    public float getStundenSatz()
    {
        return stundenSatz;
    }

    public void setStunden(int stunden) throws PersonalException
    {
        if (stunden > 0)
            this.stunden = stunden;
        else
            throw new PersonalException("Fehler bei setStunden(): stunden sind 0 oder kleiner (" + stunden + ")");
    }

    public void setStundenSatz(float stundenSatz) throws PersonalException
    {
        if (stundenSatz > 0f)
                this.stundenSatz = stundenSatz;
        else
        	throw new PersonalException("Fehler bei setStundenSatz(): stundenSatz ist 0.0 oder kleiner (" + stundenSatz + ")");
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
                        // System.out.println("Falscher Parameterwert fuer setEintrJahr("+eintrJahr+") !!!");
                // else
                    // System.out.println("Fehler bei setEintrJahr("+eintrJahr+") -> Person ist zu jung ("+berechneAlter()+")!!!");
            // }
            // else
                // System.out.println("null-Referenz bei gebJahr -> eintrJahr kann nicht geprueft werden !!!");
        // else
            // System.out.println("null-Referenz fuer setEintrJahr(Year eintrJahr) !!!");
    // }  
    
    public float berechneGehalt()
    {
        return stundenSatz*stunden;
    }

    public float berechnePraemie() // FUE Refactoring mit Verwendung von switch-case
    {
        float praemie = 0f;
        
        if (berechneDienstalter() == 15)
            praemie = berechneGehalt(); // 1x Gehalt als Praemie
        else
            if (berechneDienstalter()  == 20)
                praemie = berechneGehalt()*2; // 2x Gehalt als Praemie
        
        return praemie;
    }

    public String infoBerechnungPraemie()
    {
       return "Fuer 15 Jahre Mitarbeit bei einem Personalbuero erhaelt der Freelancer ein \"Gehalt\", fuer 20 Jahre zwei \"Gehaelter\"\" als Praemie.";
    }
    
    public String toString()
    {
        return new StringBuffer().append("Freelancer ").
        append(super.toString()). // ohne super. -> StackOverflowError -> rekursiver Methodenaufruf
        append(" Stunden: ").
        append(stunden).append(" Stundensatz: ").
        append(stundenSatz).
        append(" Praemie: ").append(berechnePraemie()).toString();
    }

    public void print()
    {
        System.out.println(this);
    }
}
