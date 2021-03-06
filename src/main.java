import Hibernate.NewHibernateUtil;
import domainModel.Hotel;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import presentation.ReservarHabitacioController;

public class main {
 
    public static void main(String [] args) {
        if(databaseIsEmpty()) {
            new DataLoader().fillDatabase();
        }
        javax.swing.SwingUtilities.invokeLater (
            new Runnable() {
                public void run() {
                    ReservarHabitacioController r = new ReservarHabitacioController();
                }
        });
    }

    private static boolean databaseIsEmpty() {

        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("Select count(nom) as recompte from Client");
        List list = q.list();
        return (list.get(0).toString().equals(String.valueOf(0)));
    }
}
