package vaccine.manager;

import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.List;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * Server
 */
public class Server {

    private int serverPort;	

    public Server(int p){
        serverPort = p;
    }

    public void servico() {

        try {
    
            // inicializa o socket para receber ligacoes
            ServerSocket s = new ServerSocket(serverPort);
          
            while (true) {
                
                // espera uma ligacao
                // ... accept()
                Socket clientSocket = s.accept();
                InputStream in = s.getInputStream();
                ObjectInputStream input = new ObjectInputStream(in);
                
                
                try{
                    Object objReceived = input.readObject();

                    if (objReceived instanceof Request) {
				
                        Request user_request = (Request) objReceived;
        
                        if (user_request.getOption() == 1) {
                            
                            //DB acess

                            OutputStream out = s.getOutputStream();
                            ObjectOutputStream output = new ObjectOutputStream(out);
                            
                            Answear server_answear = new Answear();
                            

                            output.writeObject(server_answear);
                        
                        } else if (user_request.getOption() == 2){
                            
                            //DB acess

                            OutputStream out = s.getOutputStream();
                            ObjectOutputStream output = new ObjectOutputStream(out);
                            
                            Answear server_answear = new Answear();
                            

                            output.writeObject(server_answear);
                        
                        } else if (user_request.getOption() == 3){
                            
                            //DB acess

                            OutputStream out = s.getOutputStream();
                            ObjectOutputStream output = new ObjectOutputStream(out);
                            
                            Answear server_answear = new Answear();
                            

                            output.writeObject(server_answear);
                        
                        } else if (user_request.getOption() == 4){
                            
                            //DB acess

                            OutputStream out = s.getOutputStream();
                            ObjectOutputStream output = new ObjectOutputStream(out);
                            
                            Answear server_answear = new Answear();
                            

                            output.writeObject(server_answear);
                        
                        }

                    }
                    else
                        System.out.println("PROBLEMA");

                }
                catch (Exception exNoAtendimento) {
			        exNoAtendimento.printStackTrace();
                }

		    }
        }
        catch (Exception problemaBindAccept) {
            problemaBindAccept.printStackTrace();
        }
    
    }


    public static void main(String[] args){
        
        System.err.println("SERVER...");
        if (args.length<1) {
            System.err.println("Missing parameter: port number");	
            System.exit(1);
        }
        try {
            int p = Integer.parseInt( args[0] );
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(2);
        }
        Server serv = new Server(p);
        serv.servico();  
    }
}