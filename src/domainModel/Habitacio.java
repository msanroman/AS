package domainModel;

import java.util.ArrayList;
import java.util.Date;

public class Habitacio implements java.io.Serializable{

	private int capacitat;
	private boolean disponible;
        private String nomtipus;
	private int numero;
	private ArrayList<Reserva> reserves;
	private HabitacioId id;

             
	public Habitacio(int capacitat, int numero, String tipus) {
		
		this.capacitat = capacitat;
		this.numero = numero;
		this.nomtipus = tipus;
	}
        
        public Habitacio() {
        }

	
        public Habitacio(HabitacioId id) {
            this.id = id;
        }

        public Habitacio(HabitacioId id, String nomtipus) {
            
            this.id = id;
            this.nomtipus = nomtipus;
        }
        
        public HabitacioId getId() {
            return this.id;
        }
        
        public void setId(HabitacioId id) {
            this.id = id;
        }
        public String getNomtipus() {
            return this.nomtipus;
        }

        public void setNomtipus(String nomtipus) {
            this.nomtipus = nomtipus;
        }	
	public int getCapacitat() {

		return this.capacitat;
	}

	public boolean estaDisponible() {

		return this.disponible;
	}


	public boolean estaDisponible(Date dIni, Date dFi) {

		for(Reserva r: this.reserves)
			if(r.getDataFi().getTime() >= dIni.getTime())
				if(r.getId().getDataInici().getTime() >= dFi.getTime())
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
