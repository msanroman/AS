package Adapters;

import ServiceLocator.ServeiPagament;
import ServiceLocator.ServiceLocator;
import java.util.Date;

public class PagamentAdapter implements IPagamentAdapter {

    @Override
    public boolean autoritza(String numTarj, Date dCad, float preuTotal) {
        
        ServeiPagament sp = ServiceLocator.getInstance().find("Servei Pagament");
        return sp.autoritza(numTarj, dCad, preuTotal);
    }
}
