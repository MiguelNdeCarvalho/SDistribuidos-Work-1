package vaccine.manager;

public interface Vaccine extends java.rmi.Remote {


    public Answer service(Request user_request) throws java.rmi.RemoteException;

}