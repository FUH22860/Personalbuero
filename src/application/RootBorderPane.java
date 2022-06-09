package application;

import javafx.application.Platform;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Personalbuero;

public class RootBorderPane extends BorderPane {
	private MenuItem miLaden, miSpeichern, miExportieren, miBeenden, miLoeschen, miSortAlter, miSortName, miSortGehalt,
			miUeber;
	private Menu mDatei, mMitarbeiter, mSortierenNach, mHilfe;
	private MenuBar menuBar;

	private Personalbuero personalbuero;

	private VBox buttonBoxRechts;
	private HBox buttonBoxUnten;
	private RadioButton rbAlter, rbGehalt, rbNamen;
	private Button btSortieren, btExportieren;

	public RootBorderPane() {
		initComponents();
		addComponents();
		addHandlers();
	}

	private void initComponents() {
		miLaden = new MenuItem("Laden");
		miSpeichern = new MenuItem("Speichern");
//			miSpeichern.setDisable(true);
		miExportieren = new MenuItem("Exportieren");
		miBeenden = new MenuItem("Beenden");

		miSortAlter = new MenuItem("Alter");
		miSortName = new MenuItem("Namen");
		miSortGehalt = new MenuItem("Gehalt");
		miLoeschen = new MenuItem("L\u00f6schen");

		miUeber = new MenuItem("\u00dcber");

		mDatei = new Menu("Datei");
		mMitarbeiter = new Menu("Mitarbeiter");
		mSortierenNach = new Menu("Sortieren nach");
		mHilfe = new Menu("Hilfe");

		menuBar = new MenuBar();

		personalbuero = new Personalbuero();

		rbAlter = new RadioButton("nach Alter");
//			rbAlter.setSelected(true);
		rbNamen = new RadioButton("nach Namen");
		rbGehalt = new RadioButton("nach Gehalt");
		btSortieren = new Button("Sortieren");
		btExportieren = new Button("Alle Mitarbeiter-Informationen exportieren...");

		// TODO Container-Klassen zum Sortieren (rechts) und fuer die Buttons (unten)

	}

	private void addComponents() {
		// TODO
	}

	private void addHandlers() {
		// TODO
	}

	// -------------------------------------
	// Handler-Methoden-------------------------
	private void ueber() {
		Main.showAlert(AlertType.INFORMATION, "Applikation Personalb\u00fcro");
	}

	private void beenden() {
		// System.exit(0); never ever!!!!!
		Platform.exit();
	}
}
