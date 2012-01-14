package domainModel;

public class PreuTipusHabitacio implements java.io.Serializable {

        private PreuTipusHabitacioId id;
        private Double preu;

        public PreuTipusHabitacio() {
        }


        public PreuTipusHabitacio(PreuTipusHabitacioId id) {
            this.id = id;
        }
        public PreuTipusHabitacio(PreuTipusHabitacioId id, Double preu) {
            this.id = id;
            this.preu = preu;
        }

        public PreuTipusHabitacioId getId() {
            return this.id;
        }

        public void setId(PreuTipusHabitacioId id) {
            this.id = id;
        }
        public Double getPreu() {
            return this.preu;
        }

        public void setPreu(Double preu) {
            this.preu = preu;
        }

}
