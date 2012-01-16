package DataControllers;

import DataInterface.ICtrlHotel;
import Hibernate.NewHibernateUtil;
import domainModel.Hotel;
import org.hibernate.Session;

public class CtrlHotel implements ICtrlHotel {

    @Override
    public Hotel getHotel(String hotel) {
        
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Hotel h = (Hotel) session.get(Hotel.class, hotel);
        return h;
    }
    
}
