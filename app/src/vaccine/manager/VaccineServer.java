package vaccine.manager;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VaccineServer {

    public static void main(String args[]) {

	int regPort= 1099; // default RMIRegistry port
	
	
	Properties prop = new Properties();

	if (args.length !=1) { // obrigar à presenca de um argumento
	    System.out.println("Usage: java sd.rmi.VaccineServer registryPort");
	    System.exit(1);
	}
	

	try {
	    // ATENÇÃO: este porto é relativo ao binder e não ao servidor RMI
	    regPort=Integer.parseInt(args[0]);
		PostgresConnector pc = new PostgresConnector("wg.miguelndecarvalho.pt", "db1", "user1", "2RJkmULqFgLAXK2NEbHi");
		pc.connect();

		Statement stmt = pc.getStatement();
	    // criar um Objeto Remoto
	    Vaccine obj= new VaccineImpl(stmt);

	    // Serviço de Nomes
            /**
             * Se quiser substituir o processo rmiregisty...
             * pode ativar o servidor de nomes neste mesmo processo (antes do bind)
             */
            //java.rmi.registry.LocateRegistry.createRegistry(regPort);            
            
            
	    // usar o Registry local (mesma máquina) e porto regPort
	    java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.getRegistry(regPort);

            
	    // Bind. Args: nome do serviço e objeto remoto
	    registry.rebind("vaccine", obj);


	    System.out.println("RMI object bound to service in registry");

		System.out.println("servidor pronto");
	} 
	catch (Exception ex) {
	    ex.printStackTrace();
	}
    }
    
}