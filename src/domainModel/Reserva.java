package domainModel;

import java.util.Date;

public class Reserva  implements java.io.Serializable {

        private String nomHotel;
        private int numero;
        private Date dataInici;
        private Date dataReserva;
        private Date dataFi;
        private Integer idReserva;
        private Double preuTotal;
	
        public Reserva() {
        }

        public Reserva(String nomHotel, int numero, Date dataInici) {
            this.nomHotel = nomHotel;
            this.numero = numero;
            this.dataInici = dataInici;
        }
        
        public Reserva(String nomHotel, int numero, Date dataInici, Date dataReserva, Date dataFi, Double preuTotal) {
            this.nomHotel = nomHotel;
            this.numero = numero;
            this.dataInici = dataInici;
            this.dataReserva = dataReserva;
            this.dataFi = dataFi;
            this.preuTotal = preuTotal;
        }
        
        public Date getDataReserva() {
            return this.dataReserva;
        }

        public void setDataReserva(Date dataReserva) {
            this.dataReserva = dataReserva;
        }
        public Date getDataFi() {
            return this.dataFi;
        }

        public void setDataFi(Date dataFi) {
            this.dataFi = dataFi;
        }
        public Integer getIdReserva() {
            return this.idReserva;
        }

        public void setIdReserva(Integer idReserva) {
            this.idReserva = idReserva;
        }
        public Double getPreuTotal() {
            return this.preuTotal;
        }

        public void setPreuTotal(Double preuTotal) {
            this.preuTotal = preuTotal;
        }
        
        public Date getDataInici() {
            return dataInici;
        }

        public void setDataInici(Date dataInici) {
            this.dataInici = dataInici;
        }

        public String getNomHotel() {
            return nomHotel;
        }

        public void setNomHotel(String nomHotel) {
            this.nomHotel = nomHotel;
        }

        public int getNumero() {
            return numero;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }
}
