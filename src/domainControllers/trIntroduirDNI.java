package domainControllers;

import DataInterface.ICtrlClient;
import Factories.CtrlDataFactoria;
import domainModel.Client;
import tupleTypes.DadesClient;

public class trIntroduirDNI extends Transaccio {

    private DadesClient info;
    private String dni;
    
    public trIntroduirDNI(String dni) {
        this.dni = dni;
    }
    
    @Override
    public void executa() throws Exception {
            
        CtrlDataFactoria ctrlDataFactoria = CtrlDataFactoria.getInstance();
        ICtrlClient cc = ctrlDataFactoria.getCtrlClient();
        Client c = cc.getClient(dni);
        info = new DadesClient(c.getNom(), c.getCognoms(), c.getEmail());
    }
    
    public DadesClient obtenirResultat() {
        return info;
    }
}
