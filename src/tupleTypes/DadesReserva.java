package tupleTypes;

import java.util.Date;

public class DadesReserva {
	
	public String pob;
        public Date dIni;
        public Date dFi;
        public String hotel;
        public String tipusHab;
        public String dni;
        public DadesClient dadesClient;
        public float preuTotal;
        
	public DadesReserva(String pob,Date dIni,Date dFi,String hotel,String tipusHab, String dni, DadesClient dadesClient, float preuTotal) {	
		this.pob = pob;
		this.dIni = dIni;
                this.dFi = dFi;
		this.hotel = hotel;
                this.tipusHab = tipusHab;
                this.dni = dni;
		this.dadesClient = dadesClient;
                this.preuTotal = preuTotal;
	}
}