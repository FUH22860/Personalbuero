package test;

import java.time.Year;
import model.Angestellter;
import model.PersonalException;

/**
 * Klasse TestAngestellter.
 * 
 * @author (WES) 
 * @version (2022-03-18)
 * 
 * umgestellt auf Exception-Handling und main()
 */
public class TestAngestellter
{
	public static void main(String[] args)
	{
		testAngestellter();
	}
	
    public static void testAngestellter()
    {
        try {
			Angestellter a1 = new Angestellter();
			Angestellter a2 = new Angestellter("Alfred", 'm', Year.of(1963), Year.of(2007));
			a1.print(); // Anna
			a2.print(); // Alfred
			System.out.println();
			
			// Fehler
			a2.setGesch('i');
			System.out.println("Diese Zeile wird nicht mehr ausgegeben");
			
		} catch (PersonalException e) {
			System.out.println("Fehler bearbeitet bei testAngestellter(): " + e.getMessage());
		}
		System.out.println("Diese Zeile wird schon ausgegeben");    
    }
}
