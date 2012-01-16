package presentation;

import java.util.ArrayList;
import java.util.Date;

import tupleTypes.DadesClient;
import tupleTypes.DadesSeleccionarHabitacio;
import tupleTypes.HotelAmbHabitacions;
import domainControllers.CtrlReservar;

public class ReservarHabitacioController {

	private ReservarHabitacioView reservarHabitacioView;
	private CtrlReservar ctrlReservar;

	public ReservarHabitacioController() {
		reservarHabitacioView = new ReservarHabitacioView(this);
		ctrlReservar = new CtrlReservar();
	}

	public void prOkBuscarHabitacio(String poblacio, int numOcupants,
			Date dataInici, Date dataFi) {

		if (!dataFi.after(dataInici)) {
			reservarHabitacioView.mostraMissatge("Data incorrecta");
		} else if (numOcupants <= 0) {
			reservarHabitacioView.mostraMissatge("Nombre d'ocupants invàlid");
		} else {
			ArrayList<String> poblacions = new ArrayList<String>();
                        try {
                            poblacions = ctrlReservar.obtenirPoblacions();
                        } catch (Exception ex) {
                            if (ex.getMessage().equals("noHiHaPoblacions"))
                                reservarHabitacioView
						.mostraMissatge("La poblacio no es troba al sistema");
                            else ex.printStackTrace();
                        }
			if (!poblacions.contains(poblacio)) {
				reservarHabitacioView
						.mostraMissatge("La poblacio no es troba al sistema");
			} else {
				ArrayList<HotelAmbHabitacions> resultat = new ArrayList<HotelAmbHabitacions>();
				try {
					resultat = ctrlReservar.buscarHabitacions(poblacio,
							dataInici, dataFi, numOcupants);
				} catch (Exception e) {
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
		boolean b = true;
		DadesClient dadesClient = null;
		try {
			dadesClient = ctrlReservar.introduirDNI(dni).dadesClient;
		} catch (Exception e) { 
			if (e.getMessage().equals("clientNoExisteix")) {
				reservarHabitacioView
						.mostraMissatge("No existeix al sistema un client amb aquest DNI");
			} else {
				e.printStackTrace();
			}
			b = false;
		}
		if (b)
		reservarHabitacioView.mostraDadesClient(dadesClient.nom,
				dadesClient.cognoms, dadesClient.email);
	}

	public void prOkObtePreu(String nomHotel, String tipusHab) {
		DadesSeleccionarHabitacio dadesSeleccionarHabitacio = ctrlReservar
				.seleccionarHabitacio(nomHotel, tipusHab);
		reservarHabitacioView.mostraPreu(dadesSeleccionarHabitacio.preuTotal);
	}

	public void prOkPaga(String numTarg, Date dataCad) {
		boolean b = true;
		try {
			ctrlReservar.pagament(numTarg, dataCad);
		} catch (Exception e) {
			if (e.getMessage().equals("serveiNoDisponible")) {
				reservarHabitacioView
						.mostraMissatge("Ha hagut un error en el sistema de pagament");
				
			} else {
				e.printStackTrace();
			}
			b = false;
		}
		if (b)
			reservarHabitacioView.mostraMissatgeReservaOK(this);
	}
}
