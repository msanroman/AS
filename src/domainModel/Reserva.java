package domainModel;

import java.util.Date;

public class Reserva  implements java.io.Serializable {

        private ReservaId id;
        private Date dataReserva;
        private Date dataFi;
        private Integer idReserva;
        private Double preuTotal;
	
        public Reserva() {
        }


        public Reserva(ReservaId id) {
            this.id = id;
        }
        public Reserva(ReservaId id, Date dataReserva, Date dataFi, Double preuTotal) {
            this.id = id;
            this.dataReserva = dataReserva;
            this.dataFi = dataFi;
            this.preuTotal = preuTotal;
        }
        
        public ReservaId getId() {
            return this.id;
        }

        public void setId(ReservaId id) {
            this.id = id;
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

}
