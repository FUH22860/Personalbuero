package model;

import java.util.Comparator;

public class NameComparator implements Comparator<Mitarbeiter> { // Vergleich nach Name (alphabetischer Vergleich)

	@Override
	public int compare(Mitarbeiter o1, Mitarbeiter o2) {
		
		if (o1 != null && o2 != null) // notwendig, weil wir ExceptionHandling nicht verwenden koennen 
		{
			return o1.getName().compareTo(o2.getName()); // positiv, negativ oder 0
			
// so geht es vermutlich nicht so schnell...
//			if (o1.getName().charAt(0) > o2.getName().charAt(0))
//				return 1;
//			else
//				if (o1.getName().charAt(0) < o2.getName().charAt(0))
//					return -1;
//				else
//					if (o1.getName().charAt(1) > o2.getName().charAt(1))
//	
// ... und so weiter bis zum Ende der beiden String, viel zu kompliziert
			
			// ein weiterer Versuch zum Testen, kompliziert ... und auch falsch
//			if (o1.getName().compareTo(o2.getName()) > 0)
//				return 1;
//			else
//				if (o1.getName().compareTo(o2.getName()) < 0)				
//					return -1;
//				else
//					return 0;

		}
		else // null-PointerException muss vermieden werden
			if (o1 == null && o2 != null)
				return -1;
			else
				if (o1 != null && o2 == null)
					return 1;
				else // beide null
					return 0;
	}

}
