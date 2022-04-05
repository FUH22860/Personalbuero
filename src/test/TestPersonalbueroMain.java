package test;

// 2022-03-25 4BAIF
// 2022-03-21 umgestellt auf EH
// 2022-03-22 mit testSaveMitarbeiter und testLoadMitarbeiter
// 2022-03-25 mit testExportMitarbeiter(); 

import java.time.Year;

import model.Angestellter;
import model.Freelancer;
import model.PersonalException;
import model.Personalbuero;

public class TestPersonalbueroMain {

	public static void main(String[] args) {

		try {
//			System.out.println("------------- Testmethoden fuer TestAngestellter ---------------\n");
//			test.TestAngestellter.testAngestellter();
//			System.out.println();
//			System.out.println("-------------- Testmethoden fuer TestArzt ---------------\\n\"");
//			test.TestArzt.testArzt();
//			System.out.println();

//			testSortiereMitarbeiter();
//			testSortiereName();
//			testSortiereAlter();
//			testSortiereDienstalter();

//			testKuendigeName();
//			testKuendigeGehalt();

			testSaveMitarbeiter();
			testLoadMitarbeiter();
			
			testExportMitarbeiter();

		} catch (Exception e) {
			System.out.println("TestPersonalbueroMain: ein unerwarteter Ausnahme-Fehler ist aufgetreten");
			System.out.println("Erhaltene Fehlermeldung und StackTrace:");
			e.printStackTrace();
		}
	}

	private static void testExportMitarbeiter() {

		System.out.println("+++++++++++++++++++++++ testExportMitarbeiter +++++++++++++++++++++++++\n");
		
		try {
			Personalbuero pb = new Personalbuero();

			Angestellter a1 = new Angestellter("Alfred", 'm', Year.of(1977), Year.now());
			pb.aufnehmen(a1);
			Freelancer f2 = new Freelancer("Anna", 'w', Year.of(1976), Year.of(2002), 100f, 10); // 1000
			pb.aufnehmen(f2);
			
			System.out.println(pb);  // Alfred / Anna
			System.out.println();
			
			pb.exportMitarbeiter();
			System.out.println("Die Mitarbeiter wurden exportiert");
			
		} catch (PersonalException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static void testSaveMitarbeiter() {
		System.out.println("+++++++++++++++++++++++ testSaveMitarbeiter +++++++++++++++++++++++++\n");

		Personalbuero pb = new Personalbuero();
		System.out.println(pb);
		System.out.println();

		try {
			pb.saveMitarbeiter();
			System.out.println("saveMitarbeiter() wurde ausgefuehrt");
		} catch (PersonalException e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
		System.out.println();

		// ein Mitarbeiter
		Angestellter a1;
		try {
			a1 = new Angestellter("Alfred", 'm', Year.of(1977), Year.now());
			pb.aufnehmen(a1);
			System.out.println(pb); // 1 MA: Angestellter Alfred
			System.out.println();

			pb.saveMitarbeiter();
			System.out.println("saveMitarbeiter() wurde ausgefuehrt");
			System.out.println();

			System.out.println(pb); // 1 MA: Angestellter Alfred
			System.out.println();

		} catch (PersonalException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void testLoadMitarbeiter() {
		System.out.println("+++++++++++++++++++++++ testLoadMitarbeiter +++++++++++++++++++++++++\n");

		try {
			Personalbuero pb = new Personalbuero();

			Freelancer f2 = new Freelancer("Anna", 'w', Year.of(1976), Year.of(2002), 100f, 10); // 1000
			pb.aufnehmen(f2);
			System.out.println(pb); // // Anna
			System.out.println();

			pb.loadMitarbeiter();
			System.out.println("loadMitarbeiter() wurde ausgefuehrt");
			System.out.println();

			System.out.println(pb); // 1 MA: Angestellter Alfred
			System.out.println();

		} catch (PersonalException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testKuendigeGehalt() {
		try {
			System.out.println("+++++++++++++++++++++++ testKuendigeGehalt +++++++++++++++++++++++++\n");

			Personalbuero pb = new Personalbuero();
			System.out.println(pb);
			System.out.println();

			try {
				System.out.println(pb.kuendigen(-1f));
				System.out.println();

			} catch (PersonalException e) {
				System.out.println(e.getMessage()); // Fehlermeldung
			}

			// ein Mitarbeiter
			Angestellter a1 = new Angestellter("Alfred", 'm', Year.of(1977), Year.now()); // 1500
			pb.aufnehmen(a1);
			System.out.println(pb); // 1 MA: Angestellter Alfred
			System.out.println();

			System.out.println(pb.kuendigen(1500f)); // 0.0
			System.out.println();

			// zwei Mitarbeiter
			Freelancer f2 = new Freelancer("Anna", 'w', Year.of(1976), Year.of(2002), 100f, 10); // 1000
			pb.aufnehmen(f2);
			System.out.println(pb); // 2 MA: Angestellter Alfred, Freelancer Anna
			System.out.println();

			System.out.println(pb.kuendigen(1500f)); // 0.0
			System.out.println();

			System.out.println(pb); // 2 MA: Angestellter Alfred, Freelancer Anna
			System.out.println();

			// drei Mitarbeiter
			Freelancer f3 = new Freelancer("Adi", 'w', Year.of(1996), Year.of(2022), 100f, 20); // 2000
			pb.aufnehmen(f3);
			System.out.println(pb); // 3 MA: Angestellter Alfred, Freelancer Anna, Freelancer Adi
			System.out.println();

			System.out.println(pb.kuendigen(1999.9f)); // 2000.0
			System.out.println();

			System.out.println(pb); // 2 MA: Angestellter Alfred, Freelancer Anna
			System.out.println();

			System.out.println(pb.kuendigen(999.9f)); // 2500.0
			System.out.println();

			System.out.println(pb); // keine MA
			System.out.println();

			System.out.println(pb.kuendigen(-1f)); // Fehler negatives Gehalt

		} catch (PersonalException e) {
			System.out.println("Fehler in testKuendigenGehalt(): " + e.getMessage());
		}
	}

	public static void testKuendigeName() {
		try {
			System.out.println("+++++++++++++++++++++++ testkuendigeName +++++++++++++++++++++++++\n");

			Personalbuero pb = new Personalbuero();
			System.out.println(pb); // keine MA
			System.out.println();

			try {
				System.out.println(pb.kuendigen("")); // Fehler keine MA -1
				System.out.println();

			} catch (PersonalException e) {
				System.out.println(e.getMessage());
			}

			Angestellter a1 = new Angestellter("Elisa", 'w', Year.of(2000), Year.of(2020)); // Elisa 1600
			Freelancer f1 = new Freelancer("Alfred", 'm', Year.of(1980), Year.now(), 100f, 10); // Alfred 1000

			System.out.println(pb.aufnehmen(a1)); // true Elisa
			System.out.println(pb.aufnehmen(f1)); // true Alfred
			System.out.println(pb); // zwei "Mitarbeiter": Elisa, Alfred
			System.out.println();

			System.out.println(pb.kuendigen("Anna")); // 0
			System.out.println();

			System.out.println(pb); // zwei "Mitarbeiter": Elisa, Alfred
			System.out.println();

			Freelancer f2 = new Freelancer(100f, 10); // Berta 1000
			f2.setName("Berta");

			System.out.println(pb.aufnehmen(f2)); // true Berta
			System.out.println(pb); // drei "Mitarbeiter": Elisa, Alfred, Berta
			System.out.println();

			System.out.println(pb.kuendigen("Alfred")); // 1
			System.out.println();

			System.out.println(pb); // zwei "Mitarbeiter": Elisa, Berta
			System.out.println();

			Angestellter a2 = new Angestellter("Berta", 'w', Year.of(1971), Year.now());
			System.out.println(pb.aufnehmen(a2)); // true Berta

			System.out.println(pb); // drei "Mitarbeiter": Elisa, Berta, Berta
			System.out.println();

			System.out.println(pb.kuendigen("Berta")); // 2
			System.out.println();

			System.out.println(pb); // ein "Mitarbeiter": Elisa
			System.out.println();

			System.out.println(pb.kuendigen("Elisa")); // 1
			System.out.println();

			System.out.println(pb); // keine MA
			System.out.println();

		} catch (PersonalException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testSortiereMitarbeiter() {
		try {
			System.out.println("+++++++++++++++++++++++ testSortiereMitarbeiter +++++++++++++++++++++++++\n");
			Personalbuero pb = new Personalbuero();
			System.out.println(pb); // keine MA
			System.out.println();

			pb.sortiereMitarbeiter(); // nichts sollte passieren

			System.out.println(pb); // keine MA
			System.out.println();

			Angestellter a2 = new Angestellter("Alfred", 'm', Year.of(1963), Year.of(2007));
			System.out.println(a2);
			Freelancer f1 = new Freelancer("Eva", 'w', Year.of(1980), Year.of(2001), 100f, 15);
			System.out.println(f1);
			Freelancer f2 = new Freelancer("Heinz", 'm', Year.of(2002), Year.of(2022), 10f, 125);
			System.out.println(f2);
			Freelancer f3 = new Freelancer("Anna", 'w', Year.of(1990), Year.of(2007), 100f, 30);
			System.out.println(f3);
			Freelancer f4 = new Freelancer("Walter", 'm', Year.of(1980), Year.of(2002), 25f, 100);
			System.out.println(f4);
			System.out.println();

			pb.aufnehmen(a2);
			pb.aufnehmen(f1);
			pb.aufnehmen(f2);
			pb.aufnehmen(f3);
			pb.aufnehmen(f4);
			System.out.println(pb); // a2 2250, f1 1500, f2 1250 , f3 3000, f4 2500
			System.out.println();

			pb.sortiereMitarbeiter();

			System.out.println(pb); // f2 1250, f1 1500, a2 2250, f4 2500, f3 3000
			System.out.println();

		} catch (PersonalException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testSortiereName() {
		try {
			System.out.println("+++++++++++++++++++++++ testSortiereName +++++++++++++++++++++++++\n");
			Personalbuero pb = new Personalbuero();
			System.out.println(pb); // keine MA
			System.out.println();

			pb.sortiereNamen(); // nichts sollte passieren

			System.out.println(pb); // keine MA
			System.out.println();

			Angestellter a2 = new Angestellter("Alfred", 'm', Year.of(1963), Year.of(2007));
			System.out.println(a2);
			Freelancer f1 = new Freelancer("Eva", 'w', Year.of(1980), Year.of(2001), 100f, 15);
			System.out.println(f1);
			Freelancer f2 = new Freelancer("Heinz", 'm', Year.of(2002), Year.of(2022), 10f, 125);
			System.out.println(f2);
			Freelancer f3 = new Freelancer("Anna", 'w', Year.of(1990), Year.of(2007), 100f, 30);
			System.out.println(f3);
			Freelancer f4 = new Freelancer("Walter", 'm', Year.of(1980), Year.of(2002), 25f, 100);
			System.out.println(f4);
			System.out.println();

			pb.aufnehmen(a2);
			pb.aufnehmen(f1);
			pb.aufnehmen(f2);
			pb.aufnehmen(f3);
			pb.aufnehmen(f4);
			System.out.println(pb); // a2 Alfred, f1 Eva, f2 Heinz , f3 Anna, f4 Walter
			System.out.println();

			pb.sortiereNamen();

			System.out.println(pb); // a2 Alfred, f3 Anna, f1 Eva, f2 Heinz, f4 Walter
			System.out.println();

		} catch (PersonalException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testSortiereAlter() //
	{
		try {
			System.out.println("+++++++++++++++++++++++ testSortiereAlter +++++++++++++++++++++++++\n");
			Personalbuero pb = new Personalbuero();
			System.out.println(pb); // keine MA
			System.out.println();

			pb.sortiereAlter(); // nichts sollte passieren

			System.out.println(pb); // keine MA
			System.out.println();

			Angestellter a2 = new Angestellter("Alfred", 'm', Year.of(1963), Year.of(2007)); // 59
			System.out.println(a2);
			Freelancer f1 = new Freelancer("Eva", 'w', Year.of(1980), Year.of(2001), 100f, 15); // 42
			System.out.println(f1);
			Freelancer f2 = new Freelancer("Heinz", 'm', Year.of(2002), Year.of(2022), 10f, 125); // 20
			System.out.println(f2);
			Freelancer f3 = new Freelancer("Anna", 'w', Year.of(1990), Year.of(2007), 100f, 30); // 32
			System.out.println(f3);
			Freelancer f4 = new Freelancer("Walter", 'm', Year.of(1980), Year.of(2002), 25f, 100); // 42
			System.out.println(f4);
			System.out.println();

			pb.aufnehmen(a2);
			pb.aufnehmen(f1);
			pb.aufnehmen(f2);
			pb.aufnehmen(f3);
			pb.aufnehmen(f4);
			System.out.println(pb); // a2 Alfred 59, f1 Eva 42, f2 Heinz 20 , f3 Anna 32 , f4 Walter 42
			System.out.println();

			pb.sortiereAlter();

			System.out.println(pb); // f2 Heinz 20, f3 Anna 32, f1 Eva 42, f4 Walter 42, a2 Alfred 59
			System.out.println();

		} catch (PersonalException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testSortiereDienstalter() //
	{
		try {
			System.out.println("+++++++++++++++++++++++ testSortiereDienstalter +++++++++++++++++++++++++\n");
			Personalbuero pb = new Personalbuero();
			System.out.println(pb); // keine MA
			System.out.println();

			pb.sortiereDienstalter(); // nichts sollte passieren

			System.out.println(pb); // keine MA
			System.out.println();

			Angestellter a2 = new Angestellter("Alfred", 'm', Year.of(1963), Year.of(2007)); // 15
			System.out.println(a2);
			Freelancer f1 = new Freelancer("Eva", 'w', Year.of(1980), Year.of(2001), 100f, 15); // 21
			System.out.println(f1);
			Freelancer f2 = new Freelancer("Heinz", 'm', Year.of(2002), Year.of(2022), 10f, 125); // 0
			System.out.println(f2);
			Freelancer f3 = new Freelancer("Anna", 'w', Year.of(1990), Year.of(2007), 100f, 30); // 15
			System.out.println(f3);
			Freelancer f4 = new Freelancer("Walter", 'm', Year.of(1980), Year.of(2002), 25f, 100); // 20
			System.out.println(f4);
			System.out.println();

			pb.aufnehmen(a2);
			pb.aufnehmen(f1);
			pb.aufnehmen(f2);
			pb.aufnehmen(f3);
			pb.aufnehmen(f4);
			System.out.println(pb); // a2 Alfred 15, f1 Eva 21, f2 Heinz 0 , f3 Anna 15 , f4 Walter 20
			System.out.println();

			pb.sortiereDienstalter();

			System.out.println(pb); // f2 Heinz 0, a2 Alfred 15, f3 Anna 15, f4 Walter 20, f1 Eva 21
			System.out.println();

		} catch (PersonalException e) {
			System.out.println(e.getMessage());
		}
	}
}
