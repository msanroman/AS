package Strategies;

import domainModel.PreuTipusHabitacio;
import domainModel.PreuTipusHabitacioId;

public interface IPreuStrategy {
    
    public PreuTipusHabitacioId getId();
    
    public void setId(PreuTipusHabitacioId id);
    
    public float getPreu(PreuTipusHabitacio preuTipus);
}
