package presentation;

import java.util.Date;
import java.util.Set;

import tupleTypes.DadesClient;
import tupleTypes.DadesReserva;
import tupleTypes.HotelAmbHabitacions;
import domainControllers.CtrlReservar;

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
			
			Set<String> poblacions = ctrlReservar.obtenirPoblacions();
			
			if (!poblacions.contains(poblacio)) {
				reservarHabitacioView
						.mostraMissatge("La poblaci� no es troba al sistema");
			} else {
				Set<HotelAmbHabitacions> resultat = null;
				try {
					resultat = ctrlReservar.buscarHabitacions(poblacio,
							dataInici, dataFi, numOcupants);
				} catch (Exception e) {// TODO exception
					reservarHabitacioView
							.mostraMissatge("No hi han hotels disponibles");
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
			ctrlReservar.introduirDNI(dni);
		} catch (Exception e) { // TODO exception
			reservarHabitacioView
					.mostraMissatge("No existeix al sistema un client amb aquest DNI");
		}
		reservarHabitacioView.mostraDadesClient("", "", "");/*dadesClient.nom,
				dadesClient.cognoms, dadesClient.email);*/
	}

	public void prOkPaga(String numTarg, Date dataCad) {
		try {
			//ctrlReservar.pagament(numTarg, dataCad);TODO pagament Domain
		} catch (Exception e) {// TODO exception
			reservarHabitacioView
					.mostraMissatge("Ha hagut un error en el sistema de pagament");
		}
		reservarHabitacioView.mostraMissatgeReservaOK(this);
	}

	public void prOkObtePreu(String nomHotel, String tipusHab) {
		DadesReserva dadesReserva = null;/*ctrlReservar.seleccionarHabitacio(nomHotel,
				tipusHab);TODO seleccionarHab domain*/
		reservarHabitacioView.mostraPreu(0);
	}
}
