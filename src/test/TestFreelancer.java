package test;


// 2022-03-18 3BAIF
// umgestellt auf EH und main()
import java.time.Year;

import model.Freelancer;
import model.PersonalException;

public class TestFreelancer
{
	
	public static void main(String[] args)
	{
		testBerechnePraemie();	
		testFreelancer();
	}
	
    public static void testBerechnePraemie()
    {
        try {
			Freelancer f1 = new Freelancer("Eva",'w',Year.of(1980),Year.of(2001),100f,10);
			System.out.println(f1);
			Freelancer f2 = new Freelancer("Heinz", 'm',Year.of(2002),Year.of(2022),10f,100);
			System.out.println(f2);
			Freelancer f3 = new Freelancer("Anna",'w',Year.of(1990),Year.of(2007),100f,10);
			System.out.println(f3);
			Freelancer f4 = new Freelancer("Walter", 'm',Year.of(1980),Year.of(2002),10f,100);
			System.out.println(f4);
			System.out.println();
			
			System.out.println(f1.berechnePraemie()); // 0.0 // 21 Jahre
			System.out.println(f1.infoBerechnungPraemie()); 
			System.out.println();
			
			System.out.println(f2.berechnePraemie()); // 0.0 // 0 Jahre
			System.out.println(f3.berechnePraemie()); // 1000.0 // 15 Jahre
			System.out.println(f4.berechnePraemie()); // 2000.0  // 20 Jahre 
			System.out.println();
			
		} catch (PersonalException e) {
			System.out.println("Fehler bearbeitet bei testFreelancer(): " + e.getMessage());			
		}
    }   
    
    public static void testFreelancer()
    {
		try {
//			        Freelancer f01 = new Freelancer(0f,0); // Fehler 1x: Stundensatz
//			        System.out.println(); 
//			        Freelancer f02 = new Freelancer(1f,0); // Fehler 1x: Stunden
//			        System.out.println();        
			        
			        Freelancer f1 = new Freelancer(100f,10);
			        System.out.println(f1);
			        System.out.println(f1.berechneGehalt()); // 1000 
			        System.out.println(); 
			        
			        Freelancer f2 = new Freelancer(10f,100);
			        System.out.println(f2);
			        System.out.println(f2.berechneGehalt()); // 1000         
			        System.out.println();
			        
			} catch (PersonalException e) {
				System.out.println("Fehler bearbeitet bei testFreelancer(): " + e.getMessage());			
			}
    }
}
