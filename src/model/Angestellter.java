package model;

import java.time.Year;
/**
 * Klasse Angestellter
 * 
 * @author (WES) 
 * @version (2022-04-01)
 * 
 * umgestellt auf Exception-Handling
 * mit Angestellter(String[]);
 */

// mit auskommentierter toStringCsv() 
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
    
    public Angestellter(String[] zeilenTeile) throws PersonalException
    {
    	super(zeilenTeile);
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
    
    // -------------------------- toString ------------------------
    
//    public String toStringCsv()
//    {
//    	return super.toStringCsv();
//    	// es gibt keine weiteren Attribute
//    }

}
