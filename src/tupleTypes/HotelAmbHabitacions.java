package tupleTypes;

import java.util.Set;

public class HotelAmbHabitacions {
	
	public InfoHotel infoHotel;
	public Set<HabitacionsTuple> habitacions;

	public HotelAmbHabitacions(InfoHotel infoHotel, Set<HabitacionsTuple> habitacions) {	
		this.infoHotel = infoHotel;
		this.habitacions = habitacions;
	}
}