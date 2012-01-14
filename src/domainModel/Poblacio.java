package domainModel;

import java.util.ArrayList;
import java.util.Date;

import tupleTypes.HabitacionsTuple;
import tupleTypes.InfoHotel;

public class Poblacio implements java.io.Serializable {
	
	private static class hotelsTuple {

		private final String nom;
		private final String descripcio;
		private final String categoria;
		private final float avaluacio;
		private final ArrayList<HabitacionsTuple> habitacions;

		public hotelsTuple(String nom, String descripcio, String categoria,
				float avaluacio, ArrayList<HabitacionsTuple> habitacions) {
			
					this.nom = nom;
					this.descripcio = descripcio;
					this.categoria = categoria;
					this.avaluacio = avaluacio;
					this.habitacions = habitacions;
		}
		
	}
	
	private ArrayList<Hotel> hotels;
	
        private String nom;

        public Poblacio() {
        }

        public Poblacio(String nom) {
        this.nom = nom;
        }

        public String getNom() {
            return this.nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }
        
        public ArrayList<hotelsTuple> buscarHabitacio(Date dIni, Date dFi, int numOcup) throws Exception{
		
		ArrayList<hotelsTuple> hotels = new ArrayList<hotelsTuple>();
		for(Hotel h: this.hotels) {
			ArrayList<HabitacionsTuple> habitacions = h.getHabitacions(dIni, dFi, numOcup);
			if(habitacions.size() > 0) {
				InfoHotel hInfo = h.getInfoHotel();
				hotelsTuple hotel = new hotelsTuple(hInfo.nom, hInfo.descripcio, hInfo.categoria, hInfo.avaluacio, habitacions);
				hotels.add(hotel);
			}
		}
		
		if (hotels.size() == 0) throw new Exception("hotelsNoDisp");
		return hotels;
	}

}
