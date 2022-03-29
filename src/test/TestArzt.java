package test;

import java.time.Year;

import model.Arzt;
import model.PersonalException;
/**
 * Klasse TestArzt
 * 
 * @author (WES) 
 * @version (2022-03-18)
 * 
 * umgestellt auf EH und main()
 */
public class TestArzt
{
	public static void main(String[] args)
	{
		testArzt();		
	}
	
    public static void testArzt()
    {
        try {
			Arzt ar1 = new Arzt("Wolfgang", 'm', Year.of(1964), Year.now(), 40, 1200f);
			System.out.println(ar1);
			System.out.println();
			
			System.out.println(ar1.berechneStundensatz()); // 30.0
			System.out.println();   
			
			// "ungesundes" Testobjekt - wird nicht mehr erzeugt
			Arzt ar0 = new Arzt(null, '\t', Year.of(-2000), null, -15, -99f); // Fehler null
			System.out.println(ar0); // "ungesunde" Attributwerte werden nicht mehr angezeigt
			System.out.println();    // auch dieser Code wird nicht mehr ausgefuehrt
			
		} catch (PersonalException e) {
			System.out.println("Fehler bearbeitet bei testArzt(): " + e.getMessage());			
		}
        
        
        
        
        
        
        
        
        
        
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
