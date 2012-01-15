/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataInterface;

import domainModel.Poblacio;
import java.util.ArrayList;

/**
 *
 * @author Endymiion
 */
public interface ICtrlPoblacio {
    
    public Poblacio getPoblacio(String pob) throws Exception;
    
    public ArrayList<Poblacio> tots();
}
