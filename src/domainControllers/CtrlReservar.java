package domainControllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
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
    
    public ArrayList<String> obtenirPoblacions() {
        
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
