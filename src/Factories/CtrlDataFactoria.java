/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Factories;

import DataControllers.CtrlClient;
import DataControllers.CtrlHabitacio;
import DataControllers.CtrlPoblacio;
import DataInterface.ICtrlClient;
import DataInterface.ICtrlHabitacio;
import DataInterface.ICtrlPoblacio;

/**
 *
 * @author Endymiion
 */
public class CtrlDataFactoria {
    
    private static CtrlDataFactoria instance;
    private ICtrlClient ctrlClient;
    private ICtrlHabitacio ctrlHabitacio;
    private ICtrlPoblacio ctrlPoblacio;
    
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
}
