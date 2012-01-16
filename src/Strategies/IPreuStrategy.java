/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategies;

import domainModel.PreuTipusHabitacio;
import domainModel.PreuTipusHabitacioId;

/**
 *
 * @author Miguel
 */
public interface IPreuStrategy {
    
    public PreuTipusHabitacioId getId();
    
    public void setId(PreuTipusHabitacioId id);
    
    public float getPreu(PreuTipusHabitacio preuTipus);
}
