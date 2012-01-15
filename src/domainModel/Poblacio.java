package domainModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import tupleTypes.HabitacionsTuple;
import tupleTypes.HotelAmbHabitacions;
import tupleTypes.InfoHotel;

public class Poblacio implements java.io.Serializable {
	
        private String nom;
	private Set<Hotel> hotels;
	
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
        
        public Set<Hotel> getHotels() {
            return hotels;
        }

        public void setHotels(Set<Hotel> hotels) {
            this.hotels = hotels;
        }
        
        public ArrayList<HotelAmbHabitacions> buscarHabitacio(Date dIni, Date dFi, int numOcup) throws Exception{
		
		ArrayList<HotelAmbHabitacions> result = new ArrayList<HotelAmbHabitacions>();
		if (this.hotels != null) {
                    for(Hotel h: this.hotels) {
			ArrayList<HabitacionsTuple> habitacions = h.getHabitacions(dIni, dFi, numOcup);
			if(habitacions.size() > 0) {
				InfoHotel hInfo = h.getInfoHotel();
				HotelAmbHabitacions hotel = new HotelAmbHabitacions(hInfo.nom, hInfo.descripcio, hInfo.categoria, hInfo.avaluacio, habitacions);
				result.add(hotel);
			}
                    }
                }
//		if (this.hotels.size() <= 0) throw new Exception("noTeHotels");
		if (result==null || result.isEmpty()) throw new Exception("hotelsNoDisp");
		return result;
	}

}
