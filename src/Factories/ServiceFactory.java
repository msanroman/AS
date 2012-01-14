/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Factories;

import Adapters.IPagamentAdapter;

/**
 *
 * @author Endymiion
 */
public class ServiceFactory {
    
    private ServiceFactory instance;
    private IPagamentAdapter pagamentAdapter;
    
    public ServiceFactory getInstance() {
        
        throw new UnsupportedOperationException("Operation not supported");
    }
    
    public IPagamentAdapter getPagamentAdapter() {
        
        return this.pagamentAdapter;
    }
}
