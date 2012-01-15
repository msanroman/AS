package domainControllers;

import java.util.ArrayList;
import java.util.Date;
import tupleTypes.*;

public class CtrlReservar {
    private String pob;
    private String hotel;
    private Date dIni;
    private Date dFi;
    private String tipusHab;
    private String dni;
    private float preuTotal;
    private int numHab;
    
    public ArrayList<String> obtenirPoblacions() throws Exception{
        
        trObtenirPoblacions obtenirPoblacions = new trObtenirPoblacions();
        obtenirPoblacions.executa();
        ArrayList<String> poblacions = obtenirPoblacions.obtenirResultat();
        return poblacions;
    }
    
    public ArrayList<HotelAmbHabitacions> buscarHabitacions(String pob, Date dIni, Date dFi, int numOcup) {

        trBuscarHabitacions trBuscarHabitacions = new trBuscarHabitacions(pob, dIni, dFi, numOcup); 
        trBuscarHabitacions.executa();
        this.pob = pob;
        this.dIni = dIni;
        this.dFi = dFi;
        ArrayList<HotelAmbHabitacions> habitacions = trBuscarHabitacions.obtenirResultat();
        return habitacions;
    }
    

    public DadesSeleccionarHabitacio seleccionarHabitacio(String hotel, String tipusHab) {
        
        trSeleccionarHabitacio seleccionarHabitacio = new trSeleccionarHabitacio(hotel, tipusHab, this.dIni, this.dFi);
        seleccionarHabitacio.executa();
        this.hotel = hotel;
        this.tipusHab = tipusHab;
        HabitacioNumPreu dades = seleccionarHabitacio.obtenirResultat();
        this.numHab = dades.numHab;
        this.preuTotal = dades.preu;
        DadesSeleccionarHabitacio result = new DadesSeleccionarHabitacio(this.pob, this.dIni, this.dFi, this.hotel, this.tipusHab, this.preuTotal);
        return result;
    }
    
    public DadesReserva introduirDNI(String dni) {
        
        trIntroduirDNI trIntroduirDNI = new trIntroduirDNI(dni);
        trIntroduirDNI.executa();
        DadesClient d = trIntroduirDNI.obtenirResultat();
        
        DadesReserva dadesReserva = new DadesReserva(pob, dIni, dFi, hotel, tipusHab, dni, d, preuTotal);
        return dadesReserva;
    }
    
    void pagament(String numTarj, Date dCad) {
        
        trPagament trPagament = new trPagament(numTarj, dCad, this.preuTotal, this.dni, this.numHab, this.hotel, this.dIni, this.dFi);
        trPagament.executa();
    }
}
