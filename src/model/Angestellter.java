package model;

import java.time.Year;
/**
 * Klasse Angestellter
 * 
 * @author (WES) 
 * @version (2022-03-18)
 * 
 * umgestellt auf Exception-Handling
 */
public class Angestellter extends Mitarbeiter implements GehaltBerechenbar
{

	private static final long serialVersionUID = 2022_03_22__13_15L;
	
    public Angestellter() throws PersonalException
    {
        super();
    }
    
    public Angestellter(String name, char gesch, Year gebJahr, Year eintrJahr) throws PersonalException
    {
        super(name, gesch, gebJahr, eintrJahr);
    }
    
    @Override // auf Deutsch "ueberschreiben" der Methode toString() aus der Superklasse Mitarbeiter
    public String toString()
    {
        return new StringBuffer().append("Angestellter ").
        append(super.toString()).toString();  // toString() von Mitarbeiter wird aufgerufen 
      
    }

    public float berechneGehalt()
    {
        return 1500f + 50f*berechneDienstalter();
    }

}
