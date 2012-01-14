/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataControllers;

import DataInterface.ICtrlHabitacio;
import Hibernate.NewHibernateUtil;
import domainModel.Habitacio;
import domainModel.HabitacioId;
import org.hibernate.Session;

/**
 *
 * @author Endymiion
 */
public class CtrlHabitacio implements ICtrlHabitacio{

    @Override
    public Habitacio getHabitacio(int numHab, String nomHotel) {
        
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Habitacio h = (Habitacio) session.get(Habitacio.class, new HabitacioId(nomHotel, numHab));
        return h;
    }
    
}
