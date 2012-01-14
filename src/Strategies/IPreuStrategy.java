/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategies;

import domainModel.PreuTipusHabitacio;

/**
 *
 * @author Miguel
 */
public interface IPreuStrategy {
    
    public float getPreu(PreuTipusHabitacio preuTipus);
}
