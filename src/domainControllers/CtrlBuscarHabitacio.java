package domainControllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import tupleTypes.HotelAmbHabitacions;

public class CtrlBuscarHabitacio {
    private String pob;
    private Date dIni;
    private Date dFi;
    
    public ArrayList<String> obtenirPoblacions() throws Exception{

        trObtenirPoblacions obtenirPoblacions = new trObtenirPoblacions();
        obtenirPoblacions.executa();
        ArrayList<String> poblacions = obtenirPoblacions.obtenirResultat();
        return poblacions;
    }
    
    public Set<HotelAmbHabitacions> buscarHabitacions(String pob, Date dIni, Date dFi, int numOcup) {
        // TODO 
        Set<HotelAmbHabitacions> hotelsAmbHabitacions = null;
        return hotelsAmbHabitacions;
    }
}
