package Factories;

import Adapters.IPagamentAdapter;
import Adapters.PagamentAdapter;

public class ServiceFactory {
    
    private static ServiceFactory instance;
    private IPagamentAdapter pagamentAdapter;
    
    private ServiceFactory(){}
    
    public static ServiceFactory getInstance() {
        
        if(instance == null) instance = new ServiceFactory();
        return instance;
    }
    
    public IPagamentAdapter getPagamentAdapter() {
        
        if(this.pagamentAdapter == null) this.pagamentAdapter = new PagamentAdapter();
        return this.pagamentAdapter;
    }
}
