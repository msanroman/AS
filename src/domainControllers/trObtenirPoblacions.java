package domainControllers;

import DataInterface.ICtrlPoblacio;
import Factories.CtrlDataFactoria;
import domainModel.Poblacio;
import java.util.ArrayList;

public class trObtenirPoblacions extends Transaccio {

    private ArrayList<String> result;
    
    @Override
    public void executa() {

        ICtrlPoblacio cp = CtrlDataFactoria.getInstance().getCtrlPoblacio();
        ArrayList<Poblacio> poblacions = cp.tots();
        this.result = new ArrayList<String>();
        for (Poblacio p: poblacions) {
            this.result.add(p.getNom());
        }
        
    }
    
    public ArrayList<String> obtenirResultat() {

        return result;
    }
}
