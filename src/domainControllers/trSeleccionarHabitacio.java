package domainControllers;

import DataInterface.ICtrlHotel;
import Factories.CtrlDataFactoria;
import domainModel.Hotel;
import java.util.Date;
import tupleTypes.HabitacioNumPreu;

public class trSeleccionarHabitacio extends Transaccio {

    private HabitacioNumPreu dades;
    private String tipusHab;
    private Date dIni;
    private Date dFi;
    private String hotel;

    public trSeleccionarHabitacio(String hotel, String tipusHab, Date dIni, Date dFi) {
        
        this.hotel = hotel;
        this.tipusHab = tipusHab;
        this.dIni = dIni;
        this.dFi = dFi;
    }
    
    @Override
    public void executa() {
        
        ICtrlHotel ch = CtrlDataFactoria.getInstance().getCtrlHotel();
        Hotel h = ch.getHotel(this.hotel);
        this.dades = h.seleccionarHabitacio(this.tipusHab, this.dIni, this.dFi);
    }
    
    public HabitacioNumPreu obtenirResultat() {

        return this.dades;
    }
}
