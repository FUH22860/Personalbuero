package test;

//import java.time.Year;
//
//import model.Mitarbeiter;
//import model.PersonalException;

// 2022-03-18 EH und main() (wegen abstract Mitarbeiter)

public class TestMitarbeiter_EH {
		
//	public static void main(String[] args) {
//		
//		mitarbeiterTest();
//		
//	}
//
//	public static void mitarbeiterTest() {
//
//		// "ungesunde" Testobjekte
//
//		Mitarbeiter m01 = null;
//		Mitarbeiter m02 = null;
//		Mitarbeiter m03 = null;
//		Mitarbeiter m04 = null;
//		Mitarbeiter m05 = null;
//
//		try {
//			m01 = new Mitarbeiter(null, '?', null, null);
//		} catch (PersonalException e) {
//			System.out.println("mitarbeiterTest() hat Ausnahme-Objekt bearbeitet\n" + "Erhaltene Fehlermeldung: "
//					+ e.getMessage());
//			// e.printStackTrace();
//		}
//		System.out.println();
//
//		try {
//			m02 = new Mitarbeiter("a", 'w', Year.now().minusYears(101), null);
//		} catch (PersonalException e) {
//			System.out.println("mitarbeiterTest() hat Ausnahme-Objekt bearbeitet\n" + "Erhaltene Fehlermeldung: "
//					+ e.getMessage());
//		}
//		System.out.println();
//
//		try {
//			m03 = new Mitarbeiter("ab", 'w', null, Year.now().minusYears(16));
//		} catch (PersonalException e) {
//			System.out.println("mitarbeiterTest() hat Ausnahme-Objekt bearbeitet\n" + "Erhaltene Fehlermeldung: "
//					+ e.getMessage());
//		}
//		System.out.println();
//
//		try {
//			m04 = new Mitarbeiter("ab", 'w', Year.now().plusYears(1), Year.now().plusYears(1));
//		} catch (PersonalException e) {
//			System.out.println("mitarbeiterTest() hat Ausnahme-Objekt bearbeitet\n" + "Erhaltene Fehlermeldung: "
//					+ e.getMessage());
//		}
//		System.out.println();
//
//		try {
//			m05 = new Mitarbeiter("xyz", 'w', Year.now().minusYears(14), Year.now());
//		} catch (PersonalException e) {
//			System.out.println("mitarbeiterTest() hat Ausnahme-Objekt bearbeitet\n" + "Erhaltene Fehlermeldung: "
//					+ e.getMessage());
//		}
//		System.out.println();
//
//		// die "ungesunden" Objekte wurden nicht erzeugt
//		// alle Objektreferenz-Variablen sind weiterhin null
//
//		System.out.println(m01); // null
//		System.out.println(m02); // null
//		System.out.println(m03); // null
//		System.out.println(m04); // null
//		System.out.println(m05); // null
//		System.out.println();
//		
//		// "gesunde" Testobjekte
//
//		try {
//			Mitarbeiter ma1 = new Mitarbeiter("Alfred", 'm', Year.of(1976), Year.of(2001));
//			Mitarbeiter ma2 = new Mitarbeiter("Berti", 'x', Year.of(1986), Year.of(2011));
//			Mitarbeiter ma3 = new Mitarbeiter("Claudia", 'w', Year.of(1996), Year.of(2020));
//
//			System.out.println(ma1);
//			System.out.println(ma2);
//			System.out.println(ma3);
//			System.out.println();
//
//			System.out.println("Aktuelles Jahr: " + Year.now());
//			System.out.println();
//
//			System.out.println(ma1.berechneDienstalter()); // 20
//			System.out.println();
//
//			System.out.println(ma2.berechneDienstalter()); // 10
//			System.out.println();
//
//			System.out.println(ma3.berechneDienstalter()); // 1
//			System.out.println();
//			
//			// zum Testen von catch(Exception e)
//			throw new Exception("Erzeugtes Fehlerobjekt zum Testen von catch(Exception e)");
//
//		} catch (PersonalException e) {
//			System.out.println("mitarbeiterTest() hat Ausnahme-Objekt bearbeitet\n" + "Erhaltene Fehlermeldung: "
//					+ e.getMessage());
//			
//		} catch (Exception e) {
//			System.out.println("mitarbeiterTest(): ein unerwarteter Ausnahme-Fehler ist aufgetreten");
//			System.out.println("Erhaltene Fehlermeldung und StackTrace:");
//			e.printStackTrace();
//		}
//	}
}
