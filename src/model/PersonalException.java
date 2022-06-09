package model;

public class PersonalException extends Exception {

	/*
	 * serialVersionUID ist eine Art "Versionsnummer" dieser Klasse
	 * static: dieses Attribut "gehoert" der Klasse, nicht der Instanz
	 * final: nach der ersten Wertzuweisung nicht veraenderbar ("Konstante")
	 */
	private static final long serialVersionUID = 2022_03_18__08_28L;

	public PersonalException(String message) {
		super(message);
	}

}
