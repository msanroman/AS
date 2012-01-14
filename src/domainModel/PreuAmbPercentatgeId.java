package domainModel;
// Generated 13-ene-2012 19:46:20 by Hibernate Tools 3.2.1.GA



/**
 * PreuAmbPercentatgeId generated by hbm2java
 */
public class PreuAmbPercentatgeId  implements java.io.Serializable {


     private String nomHotel;
     private String nomtipus;

    public PreuAmbPercentatgeId() {
    }

    public PreuAmbPercentatgeId(String nomHotel, String nomtipus) {
       this.nomHotel = nomHotel;
       this.nomtipus = nomtipus;
    }
   
    public String getNomHotel() {
        return this.nomHotel;
    }
    
    public void setNomHotel(String nomHotel) {
        this.nomHotel = nomHotel;
    }
    public String getNomtipus() {
        return this.nomtipus;
    }
    
    public void setNomtipus(String nomtipus) {
        this.nomtipus = nomtipus;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PreuAmbPercentatgeId) ) return false;
		 PreuAmbPercentatgeId castOther = ( PreuAmbPercentatgeId ) other; 
         
		 return ( (this.getNomHotel()==castOther.getNomHotel()) || ( this.getNomHotel()!=null && castOther.getNomHotel()!=null && this.getNomHotel().equals(castOther.getNomHotel()) ) )
 && ( (this.getNomtipus()==castOther.getNomtipus()) || ( this.getNomtipus()!=null && castOther.getNomtipus()!=null && this.getNomtipus().equals(castOther.getNomtipus()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getNomHotel() == null ? 0 : this.getNomHotel().hashCode() );
         result = 37 * result + ( getNomtipus() == null ? 0 : this.getNomtipus().hashCode() );
         return result;
   }   


}


