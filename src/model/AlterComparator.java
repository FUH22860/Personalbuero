package model;

import java.util.Comparator;

// 2022-03-03

public class AlterComparator implements Comparator<Mitarbeiter> {

	@Override
	public int compare(Mitarbeiter m1, Mitarbeiter m2) {
		// TODO null-Pruefung -> wird durch ExceptionHandling "aendert sich"
		if (m1.berechneAlter() > m2.berechneAlter())
			return 1; // m1 ist aelter als m2
		else
			if (m1.berechneAlter() < m2.berechneAlter())
				return -1; // m1 ist juenger als m2
			else // gleiches Alter
				return 0;
	}

}
