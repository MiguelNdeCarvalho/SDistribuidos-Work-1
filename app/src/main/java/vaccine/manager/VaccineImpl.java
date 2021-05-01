import java.rmi.server.UnicastRemoteObject;

public class VaccineImpl extends UnicastRemoteObject implements Vaccine, java.io.Serializable {

    // deve existir um construtor
    public VaccineImpl() throws java.rmi.RemoteException {
        super();
    }


    public Answear service(Request user_request) throws java.rmi.RemoteException{

        if (user_request.getOption() == 1) {
            return getCenterInfo(user_request);
        } 
        else if (user_request.getOption() == 2) {
            return subscription(user_request);

        } 
        else if (user_request.getOption() == 3) {
            return report(user_request);

        } 
        else if (user_request.getOption() == 4) {
            return vaccination(user_request);

        }
        else if (user_request.getOption() == 5) {
            return statistic();

        } else {
            Answear new_answear = new Answear();
            return new_answear;        
        }

        Answear new_answear = new Answear();
        return new_answear;   
        
    }

    public static Answear getCenterInfo(Request user_request) throws java.rmi.RemoteException{
        
        //DB acess

        //process

        //Answear
        Answear new_answear = new Answear();

        return new_answear;
    }

    public Answear subscription(Request user_request) throws java.rmi.RemoteException{
        
        //DB acess

        //process

        //Answear
        Answear new_answear = new Answear();

        return new_answear;
    }

    public Answear report(Request user_request) throws java.rmi.RemoteException{
    
        //DB acess
        
        //process

        //Answear
        Answear new_answear = new Answear();

        return new_answear;
    }

    public Answear vaccination(Request user_request) throws java.rmi.RemoteException{

        //DB acess

        //process

        //Answear
        Answear new_answear = new Answear();

        return new_answear;
    }

    public Answear statistic() throws java.rmi.RemoteException{

        //DB acess

        //process

        //Answear
        Answear new_answear = new Answear();

        return new_answear;
    }

}