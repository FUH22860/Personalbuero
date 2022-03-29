package test;

// 2022-01-18 auskommentiert (wegen abstract Mitarbeiter)
//import java.time.Year;

public class TestMitarbeiter
{
    public static void mitarbeiterTest()
    {
        // "ungesunde" Testobjekte
        //Mitarbeiter m01 = new Mitarbeiter(null, '?', null, null );                                              //  4 Meldung(en)
       // System.out.println();
       // Mitarbeiter m02 = new Mitarbeiter("a", 'w', Year.now().minusYears(101), null);                          //  3 Meldung(en)
       // System.out.println();
       // Mitarbeiter m03 = new Mitarbeiter("ab", 'w', null, Year.now().minusYears(16));                          //  2 Meldung(en)
       // System.out.println();
       // Mitarbeiter m04 = new Mitarbeiter("ab", 'w', Year.now().plusYears(1), Year.now().plusYears(1));         //  2 Meldung(en)
       // System.out.println();
       // Mitarbeiter m05 = new Mitarbeiter("xyz", 'w', Year.now().minusYears(14), Year.now());                   //  1 Meldung(en)
       // System.out.println();
       // Mitarbeiter m05 = new Mitarbeiter("xyz", 'w', Year.now().plusYears(9), Year.now()); //  1 Meldung(en)
       // System.out.println();
       // System.out.println(m01); // java.lang.NullPointerException
       // System.out.println(m02); // java.lang.NullPointerException
       // System.out.println(m03); // java.lang.NullPointerException
       // System.out.println(m04); // java.lang.NullPointerException
       // System.out.println(m05); // java.lang.NullPointerException

        // "gesunde" Testobjekte        
        // Mitarbeiter ma1 = new Mitarbeiter("Alfred",'m',Year.of(1976),Year.of(2001));
        // Mitarbeiter ma2 = new Mitarbeiter("Berti",'x',Year.of(1986),Year.of(2011));
        // Mitarbeiter ma3 = new Mitarbeiter("Claudia",'w',Year.of(1996),Year.of(2020));
        
        // System.out.println(ma1);
        // System.out.println(ma2);
        // System.out.println(ma3);
        // System.out.println();        
        
       // System.out.println("Aktuelles Jahr: " + Year.now());
       // System.out.println();       

       // System.out.println(ma1.berechneDienstalter()); // 20
       // System.out.println();       
    
       // System.out.println(ma2.berechneDienstalter()); // 10
       // System.out.println();         
      
       // System.out.println(ma3.berechneDienstalter()); // 1 
       // System.out.println();         
    }
}
