package DataControllers;

import DataInterface.ICtrlTipusHabitacio;
import Hibernate.NewHibernateUtil;
import domainModel.TipusHabitacio;
import org.hibernate.Session;

public class CtrlTipusHabitacio implements ICtrlTipusHabitacio {

    @Override
    public TipusHabitacio getTipusHabitacio(String nom) {

        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        TipusHabitacio t = (TipusHabitacio) session.get(TipusHabitacio.class, nom);
        return t;
    }
}