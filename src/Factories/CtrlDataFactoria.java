package Factories;

import DataControllers.*;
import DataInterface.*;

public class CtrlDataFactoria {
    
    private static CtrlDataFactoria instance;
    private ICtrlClient ctrlClient;
    private ICtrlHabitacio ctrlHabitacio;
    private ICtrlPoblacio ctrlPoblacio;
    private ICtrlHotel ctrlHotel;
    private ICtrlTipusHabitacio ctrlTipusHabitacio;
    
    private CtrlDataFactoria() {
    }
    
    public static CtrlDataFactoria getInstance(){
        
        if(instance == null) instance = new CtrlDataFactoria();
        return instance;
    }
    
    public ICtrlClient getCtrlClient() {
        
        if(this.ctrlClient == null) this.ctrlClient = new CtrlClient();
        return this.ctrlClient;
    }
    
    public ICtrlHabitacio getCtrlHabitacio() {
        
        if(this.ctrlHabitacio == null) this.ctrlHabitacio = new CtrlHabitacio();
        return this.ctrlHabitacio;
    }
    
    public ICtrlPoblacio getCtrlPoblacio() {
        
        if(this.ctrlPoblacio == null) this.ctrlPoblacio = new CtrlPoblacio();
        return this.ctrlPoblacio;
    }

    public ICtrlHotel getCtrlHotel() {
        
        if(this.ctrlHotel == null) this.ctrlHotel = new CtrlHotel();
        return this.ctrlHotel;
    }
    
    public ICtrlTipusHabitacio getCtrlTipusHabitacio() {
        
        if(this.ctrlTipusHabitacio == null) this.ctrlTipusHabitacio = new CtrlTipusHabitacio();
        return this.ctrlTipusHabitacio;
    }
}
