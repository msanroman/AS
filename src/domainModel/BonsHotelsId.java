package domainModel;
// Generated 14-ene-2012 13:11:09 by Hibernate Tools 3.2.1.GA



/**
 * BonsHotelsId generated by hbm2java
 */
public class BonsHotelsId  implements java.io.Serializable {


     private double quotaFixa;
     private double quotaVariable;

    public BonsHotelsId() {
    }

    public BonsHotelsId(double quotaFixa, double quotaVariable) {
       this.quotaFixa = quotaFixa;
       this.quotaVariable = quotaVariable;
    }
   
    public double getQuotaFixa() {
        return this.quotaFixa;
    }
    
    public void setQuotaFixa(double quotaFixa) {
        this.quotaFixa = quotaFixa;
    }
    public double getQuotaVariable() {
        return this.quotaVariable;
    }
    
    public void setQuotaVariable(double quotaVariable) {
        this.quotaVariable = quotaVariable;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof BonsHotelsId) ) return false;
		 BonsHotelsId castOther = ( BonsHotelsId ) other; 
         
		 return (this.getQuotaFixa()==castOther.getQuotaFixa())
 && (this.getQuotaVariable()==castOther.getQuotaVariable());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getQuotaFixa();
         result = 37 * result + (int) this.getQuotaVariable();
         return result;
   }   


}


