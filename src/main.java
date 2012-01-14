
import Hibernate.NewHibernateUtil;
import domainModel.Hotel;
import org.hibernate.Session;

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
        Session session;
        session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Hotel hotel = new Hotel("Jordi", "Pradel", "", "");
        session.saveOrUpdate(hotel);
        Hotel newHotel = (Hotel) session.get(Hotel.class, "Jordi");
        System.out.println(newHotel.getNom() == hotel.getNom());
    }
}
