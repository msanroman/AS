package presentation;

import java.util.ArrayList;
import java.util.Date;

import tupleTypes.DadesClient;
import tupleTypes.DadesReserva;
import tupleTypes.HotelAmbHabitacions;

public class ReservarHabitacioController {

	// ==================================
	// Fields
	// ==================================

	private ReservarHabitacioView reservarHabitacioView;
	private CtrlReservar ctrlReservar;

	// ==================================
	// Constructors
	// ==================================

	public ReservarHabitacioController() {
		reservarHabitacioView = new ReservarHabitacioView(this);
		ctrlReservar = new CtrlReservar();
	}

	public ReservarHabitacioController(
			ReservarHabitacioView _reservarHabitacioView,
			CtrlReservar _ctrlReservar) {

		this.reservarHabitacioView = _reservarHabitacioView;
		this.ctrlReservar = _ctrlReservar;
	}

	// ==================================
	// Public methods
	// ==================================

	public void prOkBuscarHabitacio(String poblacio, int numOcupants,
			Date dataInici, Date dataFi) {

		if (!dataFi.after(dataInici)) {
			System.out.print("date");
			reservarHabitacioView.mostraMissatge("Data incorrecta");
		} else if (numOcupants <= 0) {
			System.out.print("ocup");
			reservarHabitacioView.mostraMissatge("Nombre d'ocupants invàlid");
		} else {

			ArrayList<String> poblacions = ctrlReservar.obtenirPoblacions();

			if (!poblacions.contains(poblacio)) {
				reservarHabitacioView
						.mostraMissatge("La poblacio no es troba al sistema");
			} else {
				ArrayList<HotelAmbHabitacions> resultat = new ArrayList<HotelAmbHabitacions>();
				try {
					resultat = ctrlReservar.buscarHabitacions(poblacio,
							dataInici, dataFi, numOcupants);
				} catch (Exception e) {// TODO exception
					if (e.getMessage().equals("hotelsNoDisp")) {
						reservarHabitacioView
							.mostraMissatge("No hi han hotels disponibles");
					} else {
						e.printStackTrace();
					}
				}
				reservarHabitacioView.mostraHotelsTipusHab(resultat);
			}
		}
	}

	public void prCancel() {
		reservarHabitacioView.tancar();
	}

	public void prOkMissatgeReservaOk() {
		reservarHabitacioView.tancar();
	}

	public void prOkObteDadesClient(String dni) {
		DadesClient dadesClient = null;
		try {
			dadesClient = ctrlReservar.introduirDNI(dni).dadesClient;
		} catch (Exception e) { // TODO exception
			if (e.getMessage().equals("clientNoExisteix")) {
			reservarHabitacioView
					.mostraMissatge("No existeix al sistema un client amb aquest DNI");
			} else {
				e.printStackTrace();
			}
		}
		reservarHabitacioView.mostraDadesClient(dadesClient.nom,
				dadesClient.cognoms, dadesClient.email);
	}

	public void prOkObtePreu(String nomHotel, String tipusHab) {
		DadesReserva dadesReserva = ctrlReservar.seleccionarHabitacio(nomHotel,
				tipusHab);
		reservarHabitacioView.mostraPreu(dadesReserva.preuTotal);
	}

	public void prOkPaga(String numTarg, Date dataCad) {
		try {
			ctrlReservar.pagament(numTarg, dataCad);
		} catch (Exception e) {// TODO exception
			if (e.getMessage().equals("serveiNoDisponible")) {
			reservarHabitacioView
					.mostraMissatge("Ha hagut un error en el sistema de pagament");
			} else {
				e.printStackTrace();
			}
		}
		reservarHabitacioView.mostraMissatgeReservaOK(this);
	}
}
