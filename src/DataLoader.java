
import Hibernate.NewHibernateUtil;
import org.hibernate.Session;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Miguel
 */
public class DataLoader {

    private Session session;
    
    public void LoadDatabase() {
        
        session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
    }
}
