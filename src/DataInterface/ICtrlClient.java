package DataInterface;

import domainModel.Client;

public interface ICtrlClient {
    
    public Client getClient(String dni) throws Exception;
}
