
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
        
        Session sf = NewHibernateUtil.getSessionFactory().getCurrentSession();
        sf.beginTransaction();
        Hotel hotel = new Hotel("Jordi", "Pradel", "", "");
        sf.saveOrUpdate(hotel);
        Hotel newHotel = (Hotel) sf.get(Hotel.class, "Jordi");
        System.out.println(newHotel.getNom() == hotel.getNom());
        System.out.println(newHotel.getDescripcio() == hotel.getDescripcio());
    }
}
