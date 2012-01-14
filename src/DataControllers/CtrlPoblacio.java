/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataControllers;

import DataInterface.ICtrlPoblacio;
import Hibernate.NewHibernateUtil;
import domainModel.Poblacio;
import java.util.ArrayList;
import org.hibernate.Session;

/**
 *
 * @author Endymiion
 */
public class CtrlPoblacio implements ICtrlPoblacio {

    @Override
    public Poblacio getPoblacio(String pob) {
        
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Poblacio p = (Poblacio) session.get(Poblacio.class, pob);
        return p;
    }

    @Override
    public ArrayList<Poblacio> tots() {
        
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        ArrayList<Poblacio> tots = (ArrayList<Poblacio>) session.createQuery("from Poblacio").list();
        return tots;
    }
    
}
