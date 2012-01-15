/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLocator;

/**
 *
 * @author Endymiion
 */
public class ServiceLocator {
    
    private static ServiceLocator instance;
    private ServeiPagament servei;
    
    private ServiceLocator() {}
    
    public static ServiceLocator getInstance() {
        
        if(instance == null) instance = new ServiceLocator();
        return instance;
    }
    
    public ServeiPagament find(String name) {
        
        if (servei == null) servei = new ServeiPagament();
        return servei;
    }
    
}
