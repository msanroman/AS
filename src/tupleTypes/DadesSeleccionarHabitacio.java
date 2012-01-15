/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tupleTypes;

import java.util.Date;

/**
 *
 * @author Endymiion
 */
public class DadesSeleccionarHabitacio {
    
    public String pob;
    public Date dIni;
    public Date dFi;
    public String hotel;
    public String tipusHab;
    public float preuTotal;

    public DadesSeleccionarHabitacio(String pob, Date dIni, Date dFi, String hotel, String tipusHab, float preuTotal) {
        
        this.pob = pob;
        this.dIni = dIni;
        this.dFi = dFi;
        this.hotel = hotel;
        this.tipusHab = tipusHab;
        this.preuTotal = preuTotal;
    }
    
}
