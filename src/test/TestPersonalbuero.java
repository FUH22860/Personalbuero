package test;

//import java.time.Year;
//
//import model.Angestellter;
//import model.Arzt;
//import model.Freelancer;
//import model.Mitarbeiter;
//import model.Personalbuero;

// 2022-01-11 3BAIF
// mit testBerechneDurchschnittsalter()
// 2022-01-18 alle Testmethoden mit new Mitarbeiter(...) auskommentiert (wegen abstract Mitarbeiter)
// 2022-01-19 Uebung: Testmethoden anpassen auf Freelancer und Angestellter 

// 2022-01-20 mit folgenden Testmethoden:
// testBerechneDurchschnittsalter()
// testZaehleAlter()
// testZaehleMitarbeiter()
// testKuendigenMitarbeiter()
// testKuendigenMitarbeiterPos()

// 2022-01-25 mit folgenden Testmethoden:
// testZaehleAngestellte()
// testBerechneAvgGehaltAngestellte()

// 2022-01-26 mit Erweiterung von personalbueroTest()
// zum Aufnehmen von Arzt-Objekten in das Personalbuero

// 2022-03-18 Freiwillige Uebung: Umstellen auf Exception-Handling

public class TestPersonalbuero
{
//    public static void testBerechneAvgGehaltAngestellte()
//    {
//        Personalbuero pb = new Personalbuero();
//        System.out.println(pb);   // keine MA     
//        System.out.println();   
//        
//        System.out.println(pb.berechneAvgGehaltAngestellte()); // -99.0
//        System.out.println();  
//        
//        // ein Angestellter
//        Mitarbeiter ma1 = new Angestellter("Alfred", 'm',Year.of(1976),Year.of(2001)); // 2550.0        
//        pb.aufnehmen(ma1);
//        System.out.println(pb);   // 1 MA     
//        System.out.println();         
//        
//        System.out.println(pb.berechneAvgGehaltAngestellte()); // 2550.0
//        System.out.println(); 
//        
//        // zwei Angestellte
//        Mitarbeiter ma2 = new Angestellter("Anna", 'w',Year.of(1975),Year.of(2001)); // 2550.0       
//        pb.aufnehmen(ma2);
//        System.out.println(pb);   // 2 MA     
//        System.out.println();         
//        
//        System.out.println(pb.berechneAvgGehaltAngestellte()); // 2550.0
//        System.out.println(); 
//        
//        // drei Angestellte        
//        Mitarbeiter ma3 = new Angestellter("Claudia",'w',Year.of(1996),Year.of(2020)); // 1600.0
//        pb.aufnehmen(ma3);
//        System.out.println(pb);   // 3 MA     
//        System.out.println();
//        
//        System.out.println(pb.berechneAvgGehaltAngestellte()); // 2233.3333
//        System.out.println(); 
//        
//        // drei Angestellte, ein Freelancer
//        Freelancer f1 = new Freelancer("Frederike", 'w',Year.of(1975),Year.of(2001), 100f, 10);          
//        pb.aufnehmen(f1);
//        System.out.println(pb);   // 3 Angestellte, 1 Freelancer     
//        System.out.println();         
//        
//        System.out.println(pb.berechneAvgGehaltAngestellte()); // 2233.3333
//        System.out.println();         
//    }   
//    
//    public static void testZaehleAngestellte()
//    {
//        Personalbuero pb = new Personalbuero();
//        System.out.println(pb);   // keine MA     
//        System.out.println(); 
//        
//        System.out.println(pb.zaehleAngestellte()); // 0 Hinweismeldung keine MA
//        System.out.println(); 
//        
//        // ein Mitarbeiter
//        Angestellter a1 = new Angestellter("Alfred", 'm',Year.of(1977),Year.of(2002)); // 45        
//        pb.aufnehmen(a1);
//        System.out.println(pb);   // 1 MA: Angestellter Alfred     
//        System.out.println();
//        
//        System.out.println(pb.zaehleAngestellte()); // 1   
//        System.out.println(); 
//        
//        // zwei Mitarbeiter
//        Freelancer f2 = new Freelancer("Anna", 'w',Year.of(1976),Year.of(2002), 100f, 10); // 46        
//        pb.aufnehmen(f2);
//        System.out.println(pb);   // 2 MA: Angestellter Alfred, Freelancer Anna      
//        System.out.println();  
//        
//        System.out.println(pb.zaehleAngestellte()); // 1   
//        System.out.println();        
//    }
//    
//    public static void testBerechneDurchschnittsalter()
//    {
//        Personalbuero pb = new Personalbuero();
//        System.out.println(pb);   // keine MA     
//        System.out.println();   
//        
//        System.out.println(pb.berechneDurchschnittsalter()); // -99.0
//        System.out.println();  
//        
//        // ein Mitarbeiter
//        Angestellter a1 = new Angestellter("Alfred", 'm',Year.of(1977),Year.of(2002)); // 45        
//        pb.aufnehmen(a1);
//        System.out.println(pb);   // 1 MA: Angestellter Alfred     
//        System.out.println();         
//        
//        System.out.println(pb.berechneDurchschnittsalter()); // 45.0
//        System.out.println(); 
//        
//        // zwei Mitarbeiter
//        Freelancer f2 = new Freelancer("Anna", 'w',Year.of(1976),Year.of(2002), 100f, 10); // 46        
//        pb.aufnehmen(f2);
//        System.out.println(pb);   // 2 MA: Angestellter Alfred, Freelancer Anna      
//        System.out.println();         
//        
//        System.out.println(pb.berechneDurchschnittsalter()); // 45.5
//        System.out.println();         
//    }
//
//  public static void testZaehleAlter()
//    {
//        Personalbuero pb = new Personalbuero();
//        System.out.println(pb);        
//        System.out.println();   
//        
//        System.out.println(pb.zaehleAlter(0)); // Fehler und -99
//        System.out.println(); 
//        
//        System.out.println(pb.zaehleAlter(1)); // Hinweis und 0
//        System.out.println();         
//        
//        // ein Mitarbeiter
//        Angestellter a1 = new Angestellter("Alfred", 'm',Year.of(1977),Year.of(2002)); // 45        
//        pb.aufnehmen(a1);
//        System.out.println(pb); // 1 MA: Angestellter Alfred        
//        System.out.println();  
//        
//        System.out.println(pb.zaehleAlter(45)); // 0
//        System.out.println(); 
//        
//        System.out.println(pb.zaehleAlter(44)); // 1
//        System.out.println();         
//        
//        // zwei Mitarbeiter
//        Freelancer f2 = new Freelancer("Anna", 'w',Year.of(1976),Year.of(2002), 100f, 10); // 46        
//        pb.aufnehmen(f2);
//        System.out.println(pb);  // 2 MA: Angestellter Alfred, Freelancer Anna     
//        System.out.println();        
//        
//        System.out.println(pb.zaehleAlter(46)); // 0
//        System.out.println();        
//        
//        System.out.println(pb.zaehleAlter(45)); // 1
//        System.out.println(); 
//        
//        System.out.println(pb.zaehleAlter(44)); // 2
//        System.out.println();    
//    }   
//    
//    public static void testZaehleMitarbeiter()
//    {
//        Personalbuero pb = new Personalbuero();
//        System.out.println(pb);        
//        System.out.println();   
//        
//        System.out.println(pb.zaehleMitarbeiter()); // 0
//        System.out.println(); 
//        
//        // ein Mitarbeiter
//        Angestellter a1 = new Angestellter("Alfred", 'm',Year.of(1977),Year.of(2002));        
//        pb.aufnehmen(a1);
//        System.out.println(pb); // 1 MA: Angestellter Alfred        
//        System.out.println();  
//        
//        System.out.println(pb.zaehleMitarbeiter()); // 1        
//        System.out.println(); 
//        
//        // zwei Mitarbeiter
//        Freelancer f2 = new Freelancer("Anna", 'w',Year.of(1976),Year.of(2002), 100f, 10);      
//        pb.aufnehmen(f2);
//        System.out.println(pb);  // 2 MA: Angestellter Alfred, Freelancer Anna     
//        System.out.println();        
//        
//        System.out.println(pb.zaehleMitarbeiter()); // 2
//        System.out.println();        
//    }         
//
//    public static void testKuendigenMitarbeiterPos()
//    {
//        Personalbuero pb = new Personalbuero();
//        System.out.println(pb);  // keine MA       
//        System.out.println();
//        
//        Angestellter a1 = new Angestellter("Alfred", 'm',Year.of(1976),Year.of(2002)); // 2500.0
//        Angestellter a2 = new Angestellter("Berti",  'x',Year.of(1986),Year.of(2012)); // 2000.0
//        Angestellter a3 = new Angestellter("Claudia",'w',Year.of(1996),Year.of(2021)); // 1550.0
//        Angestellter a4 = new Angestellter("Alfred", 'm',Year.of(1976),Year.of(2021)); // 1550.0
////        Angestellter a5 = new Angestellter("Dominik",'x',Year.of(1986),Year.of(2022)); // 1500.0
////        Angestellter a6 = new Angestellter("Erhard", 'w',Year.of(1996),Year.of(2022)); // 1500.0
//
//        System.out.println(pb.kuendigen(-1)); // Fehler false
//        System.out.println();
//        
//        System.out.println(pb.kuendigen(0)); // Fehler false
//        System.out.println();        
//        
//        pb.aufnehmen(a1); // Alfred 
//        System.out.println(pb);   // 1 MA      
//        System.out.println();
//        
//        System.out.println(pb.kuendigen(1)); // Fehler false
//        System.out.println();
//        
//        System.out.println(pb.kuendigen(0)); // true
//        System.out.println();
//        
//        System.out.println(pb);   // keine MA   
//        System.out.println();        
//        
//        pb.aufnehmen(a2); // Berti
//        pb.aufnehmen(a3); // Claudia
//        pb.aufnehmen(a4); // Alfred 
//        System.out.println(pb);   // 3 MA Berti, Claudia, Alfred       
//        System.out.println();
//        
//        System.out.println(pb.kuendigen(2)); // true Alfred
//        System.out.println();
//        System.out.println(pb);   // 2 MA Berti, Claudia     
//        System.out.println();        
//        
//        System.out.println(pb.kuendigen(0)); // true Berti
//        System.out.println();
//        
//        System.out.println(pb);   // 1 MA Claudia   
//        System.out.println(); 
//        
//        System.out.println(pb.kuendigen(0)); // true Claudia
//        System.out.println();
//        
//        System.out.println(pb); // keine MA
//        System.out.println();         
//    }  
//    
//    public static void testKuendigenMitarbeiter()
//    {
//        Personalbuero pb = new Personalbuero();
//        System.out.println(pb);  // keine MA       
//        System.out.println();
//        
//        Angestellter a1 = new Angestellter("Alfred", 'm',Year.of(1976),Year.of(2002)); // 2500.0
//        Angestellter a2 = new Angestellter("Berti",  'x',Year.of(1986),Year.of(2012)); // 2000.0
//        Angestellter a3 = new Angestellter("Claudia",'w',Year.of(1996),Year.of(2021)); // 1550.0
//        Angestellter a4 = new Angestellter("Alfred", 'm',Year.of(1976),Year.of(2021)); // 1550.0
////        Angestellter a5 = new Angestellter("Dominik",'x',Year.of(1986),Year.of(2022)); // 1500.0
////        Angestellter a6 = new Angestellter("Erhard", 'w',Year.of(1996),Year.of(2022)); // 1500.0
//
//        System.out.println(pb.kuendigen((Mitarbeiter) null)); // Fehler false
//        System.out.println();
//        
//        pb.aufnehmen(a1); // Alfred 
//        System.out.println(pb);   // 1 MA      
//        System.out.println();
//        
//        System.out.println(pb.kuendigen(a2)); // Fehler false
//        System.out.println();
//        
//        System.out.println(pb.kuendigen(a1)); // true
//        System.out.println();
//        
//        System.out.println(pb);   // keine MA   
//        System.out.println();        
//        
//        pb.aufnehmen(a2); // Berti
//        pb.aufnehmen(a3); // Claudia
//        pb.aufnehmen(a4); // Alfred 
//        System.out.println(pb);   // 3 MA Berti, Claudia, Alfred       
//        System.out.println();
//        
//        System.out.println(pb.kuendigen(a4)); // true Alfred
//        System.out.println();
//        System.out.println(pb);   // 2 MA Berti, Claudia     
//        System.out.println();        
//        
//        System.out.println(pb.kuendigen(a2)); // true Berti
//        System.out.println();
//        
//        System.out.println(pb);   // 1 MA Claudia   
//        System.out.println(); 
//        
//        System.out.println(pb.kuendigen(a3)); // true Claudia
//        System.out.println();
//        
//        System.out.println(pb); // keine MA
//        System.out.println();         
//    }     
//    
//    public static void personalbueroTest()
//    {
//        Personalbuero pb = new Personalbuero();
//        System.out.println(pb);        
//        System.out.println();
//        
//        // Mitarbeiter ma1 = new Mitarbeiter("Alfred", 'm',Year.of(1976),Year.of(2001)); // 2500.0
//        // Mitarbeiter ma2 = new Mitarbeiter("Berti",  'x',Year.of(1986),Year.of(2011)); // 2000.0
//        // Mitarbeiter ma3 = new Mitarbeiter("Claudia",'w',Year.of(1996),Year.of(2020)); // 1550.0
//        // Mitarbeiter ma4 = new Mitarbeiter("Alfred", 'm',Year.of(1976),Year.of(2020)); // 1550.0
//        // Mitarbeiter ma5 = new Mitarbeiter("Dominik",'x',Year.of(1986),Year.of(2021)); // 1500.0
//        // Mitarbeiter ma6 = new Mitarbeiter("Erhard", 'w',Year.of(1996),Year.of(2021)); // 1500.0
//
//        Freelancer f1 = new Freelancer("Alfred", 'm',Year.of(1976),Year.of(2002), 100f, 10);
//        Angestellter a1 = new Angestellter(); // Anna
//        
//        System.out.println(pb.berechneGehaltsumme()); // 0.0
//        System.out.println();
//        
//        System.out.println(pb.aufnehmen(f1)); // true
//        System.out.println(pb.aufnehmen(a1)); // true
//        // System.out.println(pb.aufnehmen(ma3)); // true
//        // System.out.println(pb.aufnehmen(ma4)); // true
//        // System.out.println(pb.aufnehmen(ma5)); // true
//        // System.out.println(pb.aufnehmen(ma6)); // true
//        System.out.println(pb);   // 2 MA: 1 Freelander, 1 Angestellter      
//        System.out.println();
//        
//        System.out.println(pb.berechneGehaltsumme()); // 2500.0
//        System.out.println();   
//        
//        Arzt ar1 = new Arzt("Wolfgang", 'm', Year.of(1964), Year.now(), 40, 1200f); // 1200.0
//        System.out.println(ar1);
//        System.out.println();
//        
//        System.out.println(pb.aufnehmen(ar1)); // true
//        System.out.println();  
//        
//        System.out.println(pb);   // Freelancer Alfred, Angestellte Anna, Arzt Wolfgang     
//        System.out.println();
//        
//        System.out.println(pb.berechneGehaltsumme()); // 3700.0
//        System.out.println();          
//        
//        
//        
//        
//        
//        
//    }
}
