/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataInterface;

import domainModel.Client;

/**
 *
 * @author Endymiion
 */
public interface ICtrlClient {
    
    public Client getClient(String dni) throws Exception;
}
