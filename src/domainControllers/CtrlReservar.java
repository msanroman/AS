package domainControllers;

import java.util.Date;
import java.util.Set;
import tupleTypes.DadesReserva;
import tupleTypes.HotelAmbHabitacions;

public class CtrlReservar {
    private String pob;
    private String hotel;
    private Date dIni;
    private Date dFi;
    private String tipusHab;
    private String dni;
    private float preuTotal;
    private int numHab;
    
    public Set<String> obtenirPoblacions() {
        // TODO 
        Set<String> poblacions = null;
        return poblacions;
    }
    
    public Set<HotelAmbHabitacions> buscarHabitacions(String pob, Date dIni, Date dFi, int numOcup) {
        // TODO 
        Set<HotelAmbHabitacions> hotelsAmbHabitacions = null;
        return hotelsAmbHabitacions;
    }
    
    public void seleccionarHabitacio() {
        // TODO
    }
    
    public DadesReserva introduirDNI(String dni) {
        // TODO
        DadesReserva dadesReserva = null;
        return dadesReserva;
    }
    
    void pagament(int numTarj, Date dCad) {
        // TODO
    }
}