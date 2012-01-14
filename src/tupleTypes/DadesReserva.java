package tupleTypes;

import domainModel.Client;
import java.util.Date;

public class DadesReserva {
	
	public String pob;
        public Date dIni;
        public Date dFi;
        public String hotel;
        public String tipusHab;
        public Client client;
        public float preuTotal;
        
	public DadesReserva(String pob,Date dIni,Date dFi,String hotel,String tipusHab, Client client, float preuTotal) {	
		this.pob = pob;
		this.dIni = dIni;
                this.dFi = dFi;
		this.hotel = hotel;
                this.tipusHab = tipusHab;
		this.client = client;
                this.preuTotal = preuTotal;
	}
}