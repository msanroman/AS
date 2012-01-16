package domainControllers;

import Adapters.IPagamentAdapter;
import DataInterface.ICtrlClient;
import DataInterface.ICtrlHabitacio;
import Factories.CtrlDataFactoria;
import Factories.ServiceFactory;
import domainModel.Client;
import domainModel.Habitacio;
import domainModel.Reserva;
import domainModel.ReservaId;
import java.util.Date;

public class trPagament extends Transaccio {
    
    private float preuTotal;
    private String numTarj;
    private Date dCad;
    private String dni;
    private int numHab;
    private String nomHotel;
    private Date dIni;
    private Date dFi;

    trPagament(String numTarj, Date dCad, float preuTotal, String dni, int numHab, String nomHotel, Date dIni, Date dFi) {
        
        this.numHab = numHab;
        this.dni = dni;
        this.numTarj = numTarj;
        this.dCad = dCad;
        this.preuTotal = preuTotal;
        this.nomHotel = nomHotel;
        this.dIni = dIni;
        this.dFi = dFi;
    }

    @Override
    public void executa() throws Exception {
        
        IPagamentAdapter ad = ServiceFactory.getInstance().getPagamentAdapter();
        if(ad.autoritza(this.numTarj, this.dCad, this.preuTotal)) {
            
            ICtrlClient cc = CtrlDataFactoria.getInstance().getCtrlClient();
            ICtrlHabitacio ch = CtrlDataFactoria.getInstance().getCtrlHabitacio();
            Client c = cc.getClient(this.dni);
            Habitacio h = ch.getHabitacio(numHab, nomHotel);
            Reserva r = new Reserva(new ReservaId(nomHotel, numHab, this.dIni),
                    new Date(), this.dFi, (double) this.preuTotal);
            h.afegeixReserva(r);
            c.afegeixReserva(r);
        }
        
    }
}
