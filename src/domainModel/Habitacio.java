package domainModel;

import java.util.ArrayList;
import java.util.Date;

public class Habitacio {

	private int capacitat;
	private boolean disponible;
	private String tipus;
	private int numero;
	private ArrayList<Reserva> reserves;
	
	public Habitacio(int capacitat, int numero, String tipus) {
		
		this.capacitat = capacitat;
		this.numero = numero;
		this.tipus = tipus;
	}
	
	public int getCapacitat() {

		return this.capacitat;
	}

	public boolean estaDisponible() {

		return this.disponible;
	}

	public String getTipus() {

		return this.tipus;
	}

	public boolean estaDisponible(Date dIni, Date dFi) {

		for(Reserva r: this.reserves)
			if(r.getDataFi().getTime() >= dIni.getTime())
				if(r.getDataIni().getTime() >= dFi.getTime())
					return false;
		return true;
	}

	public int getNumero() {

		return this.numero;
	}
	
	public void afegeixReserva(Reserva reserva) {
		
		this.reserves.add(reserva);
	}

}
