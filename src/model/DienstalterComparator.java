package model;

import java.util.Comparator;

// 2022-03-03

public class DienstalterComparator implements Comparator<Mitarbeiter> {

	@Override
	public int compare(Mitarbeiter m1, Mitarbeiter m2) {
		
		return m1.berechneDienstalter() - m2.berechneDienstalter();
		
		//     (m1 Dienstalter) 1     -     (m2 Dienstalter) 2 = -1
		//     return -1;
		// 		6					  -         2              =  4
		// return 1 -> ok return 4 
		//      1					  -         1              =  0
		// return 0

		// Weitere Varianten:
		// return Integer.compare(m1.berechneDienstalter(), m2.berechneDienstalter());		
		
		// return m2.getEintrJahr().compareTo(m1.getEintrJahr()); // Year.compareTo

	}

}
