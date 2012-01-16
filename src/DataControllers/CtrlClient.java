package DataControllers;

import DataInterface.ICtrlClient;
import Hibernate.NewHibernateUtil;
import domainModel.Client;
import org.hibernate.Session;

public class CtrlClient implements ICtrlClient{

    @Override
    public Client getClient(String dni) throws Exception {

        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Client c = (Client) session.get(Client.class, dni);
        if (c == null) throw new Exception("clientNoExisteix");
        return c;
    }
    
}
