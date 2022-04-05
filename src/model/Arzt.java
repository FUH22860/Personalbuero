package model;

import java.time.Year;
/**
 * Klasse Arzt 
 *
 * @author (WES)
 * @version (2022-03-31)
 * 
 * umgestellt auf Exception-Handling
 * mit freiwilliger Uebung toStringCsv()
 * mit freiwilliger Uebung public Arzt (String[] zeilenTeile)
 */
public class Arzt extends Mitarbeiter implements GehaltBerechenbar
{
	private static final long serialVersionUID = 2022_03_22__13_15L;
    private int wochenStunden;
    private float fixum;

    // FUE
    // public Arzt (String[] zeilenTeile) // TODO
    
    public Arzt(String name, char gesch, Year gebJahr, Year eintrJahr, int wochenStunden, float fixum) throws PersonalException
    {
        super(name, gesch, gebJahr, eintrJahr);
        setWochenStunden(wochenStunden);
        setFixum(fixum);
    }

    public void setWochenStunden(int wochenStunden) throws PersonalException
    {
        if (wochenStunden > 0)
            this.wochenStunden = wochenStunden;
        else
            throw new PersonalException("Fehler bei setWochenStunden(): Wert von wochenStunden muss groesser 0 sein (" + wochenStunden + ")");
    }

    public void setFixum(float fixum) throws PersonalException
    {
        if (fixum > 0f)
            this.fixum = fixum;
        else
        	throw new PersonalException("Fehler bei setFixum(): Wert von fixum muss groesser 0.0 sein (" + fixum + ")");
    }

    public float berechneStundensatz() throws PersonalException
    {
        if (wochenStunden > 0)
        {
            return fixum/wochenStunden;
        }
        else
        {
        	throw new PersonalException("Fehlen bei berechneStundensatz(): wert von wochenStunden ist ungueltig (" + wochenStunden + ")");
            // return -99f;   // nach throw der Block verlassen, wie bei einem return
        }
    }

    public float berechneGehalt()
    {
        return fixum;
    }
    
    // -------------------------- print / toString / toStringCsv ------------
    
    // public void printInfo() // zum Testen
    // {
        // System.out.println(this);
    // }
    
    public String toString()
    {
        return "Arzt: " +
                super.toString() +
               ", Wochenstunden: " + wochenStunden +
               ", Fixum: " + fixum;
    }
    
    public String toStringCsv()
    {
    	String sep = ";";
    	//     Arzt;Wolfgang;m;1964;2022 ;          40     ;  1200.0      
    	return super.toStringCsv()     +sep+wochenStunden+sep+fixum;
    	
    }
    
}
