package model;

import java.time.Year;
/**
 * Klasse Arzt 
 *
 * @author (WES)
 * @version (2022-04-07)
 * 
 * umgestellt auf Exception-Handling
 * mit freiwilliger Uebung toStringCsv()
 * mit freiwilliger Uebung public Arzt (String[] zeilenTeile)
 * mit public Arzt(String[] zeilenTeile)
 * mit setAllFields(String[] zeilenTeile)
 * mit equals() und hashCode() 
 */

public class Arzt extends Mitarbeiter implements GehaltBerechenbar
{
	private static final long serialVersionUID = 2022_04_05__12_40L;
    private int wochenStunden;
    private float fixum;

    // FUE 2002-04-01
    // public Arzt (String[] zeilenTeile)
    
    public Arzt (String[] zeilenTeile) throws PersonalException
    {
    	super(zeilenTeile);
    	setAllFields(zeilenTeile);
    }
    
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
    
    private void setAllFields(String[] zeilenTeile) throws PersonalException
    {
    	try {
	    	// 10;   1000.0
	    	// [5]    [6]        im Array zeilenTeile
	    	setWochenStunden(Integer.parseInt(zeilenTeile[5].trim()));  // "10"
	    	// throws NumberFormatException bei Integer.parseInt
	    	setFixum(Float.parseFloat(zeilenTeile[6].trim()));	// "1000.0"
    	} 
    	catch(ArrayIndexOutOfBoundsException e)
    	{
    		throw new PersonalException("Array-Fehler bei setAllFields(): " 
    									+ e.getMessage());
    	} 
    	catch(NumberFormatException e)
    	{
    		throw new PersonalException("Zahlenumwandlungs-Fehler (wochenStunden oder fixum) bei setAllFields(): " 
					+ e.getMessage());    		
    	}    	
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
	// ------------------------- equals / hashCode ---------------

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arzt other = (Arzt) obj;
		if (Float.floatToIntBits(fixum) != Float.floatToIntBits(other.fixum))
			return false;
		if (wochenStunden != other.wochenStunden)
			return false;
		return true;
	}    
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Float.floatToIntBits(fixum);
		result = prime * result + wochenStunden;
		return result;
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
