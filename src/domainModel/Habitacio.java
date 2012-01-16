package domainModel;

import DataInterface.ICtrlTipusHabitacio;
import Factories.CtrlDataFactoria;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Habitacio implements java.io.Serializable{

       
        private TipusHabitacio tipusHabitacio;

//        private String nomtipus;

        public String getNomtipus() {
            return this.nomtipus;
        }
        
        public void setNomtipus(String nomtipus) {
            this.nomtipus = (nomtipus);
        }

        private String nomtipus;
	private boolean disponible;
	private int numero;

	private Set<Reserva> reserves = new HashSet();

        public Set<Reserva> getReserves() {
            return reserves;
        }

        public void setReserves(Set<Reserva> reserves) {
            this.reserves = reserves;
        }
        
	private HabitacioId id;
             
        public Habitacio() {
        }

        public Habitacio(HabitacioId id) {
            this.id = id;
        }

        public Habitacio(HabitacioId id, String nomtipus) {
            
            this.id = id;
            this.nomtipus = nomtipus;
        }
        
        public TipusHabitacio getTipusHabitacio() {
            return tipusHabitacio;
        }

        public void setTipusHabitacio(TipusHabitacio tipusHabitacio) {
            this.tipusHabitacio = tipusHabitacio;
        }
        
//        public String getNomtipus() {
//            return this.tipusHabitacio.getNom();
//        }
        
        public int getCapacitat() {
            
            ICtrlTipusHabitacio cth = CtrlDataFactoria.getInstance().getCtrlTipusHabitacio();
            return cth.getTipusHabitacio(nomtipus).getCapacitat();
        }
        
        public HabitacioId getId() {
            return this.id;
        }
        
        public void setId(HabitacioId id) {
            this.id = id;
        }


	public boolean estaDisponible() {

		return this.disponible;
	}


	public boolean estaDisponible(Date dIni, Date dFi) {

                if (this.reserves != null) {
                    for(Reserva r: this.reserves) {
                        if(r.getDataFi().getTime() >= dIni.getTime()) {
                            if(r.getDataInici().getTime() <= dFi.getTime()) return false;
                        }
                                    
                    }
                }
		return true;
	}

	public int getNumero() {

		return this.numero;
	}
	
	public void afegeixReserva(Reserva reserva) {
		
		this.reserves.add(reserva);
	}

}
