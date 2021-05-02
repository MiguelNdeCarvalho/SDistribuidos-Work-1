package vaccine.manager;

import java.sql.Statement;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;


public class VaccineServer {

	private static String dbHost;
	private static String dbName;
	private static String dbUsername;
	private static String dbPassword;
    public static void main(String args[]) {
	
	try (InputStream input = new FileInputStream("resources/credentials.properties")) {
	
		Properties prop = new Properties();
		prop.load(input);

		dbHost = prop.getProperty("db.host");
		dbName = prop.getProperty("db.name");
		dbUsername = prop.getProperty("db.username");
		dbPassword = prop.getProperty("db.password");
	} catch (IOException e) {
		System.out.println("The credentials.properties file couldn't be find in the resources folder");
		System.exit(1);
	}

	if (args.length !=1) { // obrigar à presenca de um argumento
	    System.out.println("Usage: java sd.rmi.VaccineServer registryPort");
	    System.exit(1);
	}
	

	try {
	    // ATENÇÃO: este porto é relativo ao binder e não ao servidor RMI
	    int regPort=Integer.parseInt(args[0]);
		PostgresConnector pc = new PostgresConnector(dbHost, dbName,dbUsername, dbPassword);
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