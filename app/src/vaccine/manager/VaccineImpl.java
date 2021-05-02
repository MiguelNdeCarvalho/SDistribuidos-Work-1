package vaccine.manager;

import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.Statement;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;


public class VaccineImpl extends UnicastRemoteObject implements Vaccine, java.io.Serializable {

    static Statement stmt ;

    // deve existir um construtor
    public VaccineImpl(Statement stmt) throws java.rmi.RemoteException {
        this.stmt = stmt;
    }


    public Answer service(Request user_request) throws java.rmi.RemoteException{

	    System.out.println(user_request);

        if (user_request.getOption() == 1) {
            return getCentersInfo();
        } 
        else if (user_request.getOption() == 2) {
            return getQueueSize(user_request);

        }
        else if (user_request.getOption() == 3) {
            return subscription(user_request);

        }  
        else if (user_request.getOption() == 4) {
            return report(user_request);

        } 
        else if (user_request.getOption() == 5) {
            return vaccination(user_request);

        }
        else if (user_request.getOption() == 6) {
            return statistic();

        } else {
            Answer new_answer = new Answer();
            return new_answer;        
        }  
        
    }

    public static Answer getCentersInfo() throws java.rmi.RemoteException{
        
        //Answer
        Answer new_answer = new Answer();

        //DB acess
        try {

            ResultSet rs = stmt.executeQuery("SELECT nome FROM centro");
            while (rs.next()){
                new_answer.getString_data().add(rs.getString("nome"));
            }


        } catch (Exception e) {
            
            e.printStackTrace();
        }
        //process
        new_answer.setReply(1);
        return new_answer;
    }

    public static Answer getQueueSize(Request user_request) throws java.rmi.RemoteException{
        
        //Answer
        Answer new_answer = new Answer();

        //DB acess
        try {
            ResultSet rs = stmt.executeQuery("WITH x as (SELECT id FROM CENTRO WHERE nome='" + user_request.getString_data().get(0) +"') SELECT COUNT(DISTINCT codigo) AS c from inscricao where centroid=(SELECT id FROM x);");
            rs.next();   
            new_answer.getInt_data().add(rs.getInt("c"));
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        //process
        new_answer.getString_data().add(user_request.getString_data().get(0));
        new_answer.setReply(2);
        return new_answer;
    }

    public Answer subscription(Request user_request) throws java.rmi.RemoteException{
        
        //Answer
        Answer new_answer = new Answer();

        //DB acess

        try {
            stmt.executeUpdate("INSERT INTO inscricao values('"+ user_request.getString_data().get(0) +"', 1, '"+user_request.getString_data().get(1)+"', '"+user_request.getString_data().get(2)+"','"+user_request.getInt_data().get(0)+"','');");
        } catch (Exception e) {
            e.printStackTrace();
            new_answer.setReply(3);
        }
        //process
        if (!(new_answer.getReply()==3)) {
            new_answer.getString_data().add(user_request.getString_data().get(0));
            new_answer.setReply(4);
        }
        return new_answer;
    }

    public Answer report(Request user_request) throws java.rmi.RemoteException{
    
        Answer new_answer = new Answer();
        String result = "";
        
        try {

            int size = user_request.getString_data().size();

            for (int i = 0; i<size-1;i++) {
                result = result + user_request.getString_data().get(i) + " ";
            }
            stmt.executeUpdate("UPDATE inscricao SET efeitossecundarios = '"+ result +"' WHERE codigo = '" + user_request.getString_data().get(size-1) +"';");
        } catch (Exception e) {
            e.printStackTrace();
        }

        new_answer.setReply(5);
        return new_answer;
    }

    public Answer vaccination(Request user_request) throws java.rmi.RemoteException{

        Answer new_answer = new Answer();

        //SELECT codigo,centroID,nome,genero,idade FROM inscricao WHERE codigo='C1';
        //INSERT INTO vacinado VALUES ('c2',1 ,'nome', 'masculino', 10, NOW(), 'top');
        //DELETE FROM vacinado WHERE codigo='c2';
        
        try {
            System.out.println("SELECT codigo,centroID,nome,genero,idade FROM inscricao WHERE codigo='"+user_request.getString_data().get(0)+"';");
            ResultSet rs = stmt.executeQuery("SELECT codigo,centroID,nome,genero,idade FROM inscricao WHERE codigo='"+user_request.getString_data().get(0)+"';");
            rs.next();   
            String cod = rs.getString("codigo");
            int centro = rs.getInt("centroID");
            String name = rs.getString("nome");
            String gen = rs.getString("genero");
            int age = rs.getInt("idade");

            stmt.executeUpdate("INSERT INTO vacinado  VALUES ('"+ cod +"','"+centro+"','"+name+"','"+gen+"','"+age+"',NOW(),'"+user_request.getString_data().get(1)+"');");
            stmt.executeUpdate("DELETE FROM inscricao WHERE codigo = '" + user_request.getString_data().get(0) +"';");


        } catch (Exception e) {
            e.printStackTrace();
            new_answer.getString_data().add(user_request.getString_data().get(0));
            new_answer.setReply(7);
        }

        if (!(new_answer.getReply()==7)) {
            new_answer.getString_data().add(user_request.getString_data().get(0));
            new_answer.setReply(6);
        }
        return new_answer;
    }

    public Answer statistic() throws java.rmi.RemoteException{

        //DB acess
        //SELECT tipo,COUNT(DISTINCT(codigo)) from vacinado group by tipo;

        Answer new_answer = new Answer();
        
        try {
            ResultSet rs = stmt.executeQuery("SELECT tipo,(COUNT(DISTINCT(codigo))) as c from vacinado group by tipo;");
            while (rs.next()) {
                String vac = rs.getString("tipo");
                int total = rs.getInt("c");
                new_answer.getString_data().add(vac);
                new_answer.getInt_data().add(total);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        new_answer.setReply(8);
        return new_answer;
    }

}