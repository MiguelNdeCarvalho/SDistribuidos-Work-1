package vaccine.manager;

import java.rmi.server.UnicastRemoteObject;

public class VaccineImpl extends UnicastRemoteObject implements Vaccine, java.io.Serializable {

    // deve existir um construtor
    public VaccineImpl() throws java.rmi.RemoteException {
        super();
    }


    public Answer service(Request user_request) throws java.rmi.RemoteException{

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
            Answer new_answer = new Answer();
            return new_answer;        
        }  
        
    }

    public static Answer getCenterInfo(Request user_request) throws java.rmi.RemoteException{
        
        //DB acess

        //process

        //Answer
        Answer new_answer = new Answer();

        return new_answer;
    }

    public Answer subscription(Request user_request) throws java.rmi.RemoteException{
        
        //DB acess

        //process

        //Answer
        Answer new_answer = new Answer();

        return new_answer;
    }

    public Answer report(Request user_request) throws java.rmi.RemoteException{
    
        //DB acess
        
        //process

        //Answer
        Answer new_answer = new Answer();

        return new_answer;
    }

    public Answer vaccination(Request user_request) throws java.rmi.RemoteException{

        //DB acess

        //process

        //Answer
        Answer new_answer = new Answer();

        return new_answer;
    }

    public Answer statistic() throws java.rmi.RemoteException{

        //DB acess

        //process

        //Answer
        Answer new_answer = new Answer();

        return new_answer;
    }

}