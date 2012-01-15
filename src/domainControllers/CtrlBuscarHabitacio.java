package domainControllers;

import java.util.ArrayList;
import java.util.Date;
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
    
    public ArrayList<HotelAmbHabitacions> buscarHabitacions(String pob, Date dIni, Date dFi, int numOcup) throws Exception{
        
        trBuscarHabitacions trBuscarHabitacions = new trBuscarHabitacions(pob, dIni, dFi, numOcup);
        trBuscarHabitacions.executa();
        this.pob = pob;
        this.dIni = dIni;
        this.dFi = dFi;
        ArrayList<HotelAmbHabitacions> habitacions = trBuscarHabitacions.obtenirResultat();
        return habitacions;
    }
}
