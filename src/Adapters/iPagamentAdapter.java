/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

import java.util.Date;

/**
 *
 * @author Endymiion
 */
public interface IPagamentAdapter {
    
    public boolean autoritza(String numTarj, Date dCad, float preuTotal);
}
