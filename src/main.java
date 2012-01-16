
import Hibernate.NewHibernateUtil;
import domainModel.Hotel;
import org.hibernate.Session;
import presentation.ReservarHabitacioController;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Endymiion
 */
public class main {
 
    public static void main(String [] args) {
        javax.swing.SwingUtilities.invokeLater (
            new Runnable() {
                public void run() {
                    ReservarHabitacioController r = new ReservarHabitacioController();
                }
        });
    }
}
