package presentation;

import java.util.ArrayList;

import tupleTypes.HotelAmbHabitacions;

public class ReservarHabitacioView {

	private VistaInicial vistaInicial;
	private VistaMissatgeFiOk vistaMissatgeFiOk;

	public ReservarHabitacioView(
			ReservarHabitacioController reservarHabitacioController) {

		vistaInicial = new VistaInicial(reservarHabitacioController);
	}

	public void mostraMissatge(String missatge) {
		vistaInicial.mostraMissatge(missatge);
	}

	public void mostraHotelsTipusHab(
			ArrayList<HotelAmbHabitacions> informacioHotels) {

		vistaInicial.mostraHotelsTipusHab(informacioHotels);
	}

	public void mostraPreu(float preu) {
		vistaInicial.mostraPreu(preu);
	}

	public void mostraDadesClient(String nom, String cognoms, String mail) {
		vistaInicial.mostraDadesClient(nom, cognoms, mail);
	}

	public void tancar() {
		if (vistaInicial != null) {
			vistaInicial.tancar(true);
		} else
			vistaMissatgeFiOk.tancar();
	}

	public void mostraMissatgeReservaOK(
			ReservarHabitacioController reservarHabitacioController) {

		vistaInicial.tancar(false);
		vistaMissatgeFiOk = new VistaMissatgeFiOk(reservarHabitacioController);
	}
}
