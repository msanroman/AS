package DataInterface;

import domainModel.Poblacio;
import java.util.ArrayList;

public interface ICtrlPoblacio {
    
    public Poblacio getPoblacio(String pob) throws Exception;
    
    public ArrayList<Poblacio> tots();
}
