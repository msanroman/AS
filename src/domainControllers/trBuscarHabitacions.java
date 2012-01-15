package domainControllers;

import DataInterface.ICtrlPoblacio;
import Factories.CtrlDataFactoria;
import domainModel.Poblacio;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import tupleTypes.HotelAmbHabitacions;

public class trBuscarHabitacions extends Transaccio {

    private ArrayList<HotelAmbHabitacions> hotelsAmbHabitacions;
    private String pob;
    private Date dIni;
    private Date dFi;
    private int numOcup;
    
    public trBuscarHabitacions(String pob, Date dIni, Date dFi, int numOcup) {
		
        this.pob = pob;
        this.dIni = dIni;
        this.dFi = dFi;
        this.numOcup = numOcup;
    }
    
    @Override
    public void executa() {
        
        CtrlDataFactoria ctrlDataFactoria = CtrlDataFactoria.getInstance();
        ICtrlPoblacio cp = ctrlDataFactoria.getCtrlPoblacio();
        Poblacio p = cp.getPoblacio(pob);
        try {
            this.hotelsAmbHabitacions =  p.buscarHabitacio(dIni, dFi, numOcup);
        } catch (Exception ex) {
            Logger.getLogger(trBuscarHabitacions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<HotelAmbHabitacions> obtenirResultat() {
        
        return hotelsAmbHabitacions;
    }
}
