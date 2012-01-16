package domainModel;

import Strategies.IPreuStrategy;

public class PreuTipusHabitacio implements java.io.Serializable {

        private PreuTipusHabitacioId id;
        private Float preu;
        private IPreuStrategy estrategia;


        public PreuTipusHabitacio() {
        }

        public PreuTipusHabitacio(PreuTipusHabitacioId id) {
            this.id = id;
        }
        
        public PreuTipusHabitacio(PreuTipusHabitacioId id, Float preu, IPreuStrategy estrategia) {
            this.id = id;
            this.preu = preu;
            this.estrategia = estrategia;
        }

        public PreuTipusHabitacioId getId() {
            return this.id;
        }

        public void setId(PreuTipusHabitacioId id) {
            this.id = id;
        }
        public Float getPreu() {
            return this.preu;
        }
        
        public void setPreu(Float preu) {
            this.preu = preu;
        }

        public IPreuStrategy getEstrategia() {
            return estrategia;
        }

        public void setEstrategia(IPreuStrategy estrategia) {
            this.estrategia = estrategia;
        }
        
        public float getPreuAmbEstrategia() {
            
            return estrategia.getPreu(this);
        }
}
