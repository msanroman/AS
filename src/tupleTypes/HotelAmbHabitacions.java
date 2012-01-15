package tupleTypes;

import java.util.ArrayList;

public class HotelAmbHabitacions {
	
    public InfoHotel infoHotel;
    public ArrayList<HabitacionsTuple> habitacions;

    public HotelAmbHabitacions(InfoHotel infoHotel, ArrayList<HabitacionsTuple> habitacions) {	
        this.infoHotel = infoHotel;
        this.habitacions = habitacions;
    }

    public HotelAmbHabitacions(String nom, String descripcio, String categoria, float avaluacio, ArrayList<HabitacionsTuple> habitacions) {
        this.infoHotel = new InfoHotel(nom, descripcio, categoria, avaluacio);
        this.habitacions = habitacions;
    }
}