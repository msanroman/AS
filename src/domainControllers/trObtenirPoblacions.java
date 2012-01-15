package domainControllers;

import DataInterface.ICtrlPoblacio;
import Factories.CtrlDataFactoria;
import domainModel.Poblacio;
import java.util.ArrayList;

public class trObtenirPoblacions extends Transaccio {

    private ArrayList<String> result;
    
    @Override
    public void executa() throws Exception {

        ICtrlPoblacio cp = CtrlDataFactoria.getInstance().getCtrlPoblacio();
        ArrayList<Poblacio> poblacions = cp.tots();
        this.result = new ArrayList<String>();
        if (poblacions.isEmpty())
            throw new Exception("noHiHaPoblacions");
        for (Poblacio p: poblacions) {
            this.result.add(p.getNom());
        }
        
    }
    
    public ArrayList<String> obtenirResultat() {

        return result;
    }
}
