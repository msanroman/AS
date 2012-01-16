package Adapters;

import java.util.Date;

public interface IPagamentAdapter {
    
    public boolean autoritza(String numTarj, Date dCad, float preuTotal);
}
