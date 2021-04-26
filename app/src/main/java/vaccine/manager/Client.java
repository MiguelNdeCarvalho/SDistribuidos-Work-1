import jdk.jfr.internal.tool.Print;

import java.util.Scanner;  // Import the Scanner class

public class Client {

    private String Address = "localhost";
    private int Port = 0;
    
    //Patient
    String Name = "None";
    int Cod = 0;


    public Client(String name, String address, int port){
        Name = name;
        Address = address;
        Port = port;
    }

    public setServer(String add, int p) {
        Address = add;
        Port = p;
    }

    public void getCenterInfo(){

    }

    public void subscription(){
        
    }

    public void report(){
        
    }

    public void vaccination(){
        
    }

    public void statistic(){
        
    }

    public void enviaPedido(Pedido p) {
        try {
            Socket s = new Socket(address, sPort);
            
            // que Streams usar????
            OutputStream out = s.getOutputStream();
            ObjectOutputStream output = new ObjectOutputStream(out);
            
            // escrever a mensagem?
            output.writeObject(p);
            
            // ler a resposta e mostrar o resultado
            InputStream in = s.getInputStream();
            ObjectInputStream input = new ObjectInputStream(in);
            Object resposta = input.readObject();

            // fechar o socket
            s.close();
            
            // ver a resposta - modo simples
            System.out.println("RESPOSTA: " + resposta);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        
        Client user = new Client();
        int option;

        System.out.println("Welcome to the system");
        System.out.print("User: " + user);

        while (1) {
            
            System.out.print("-----MENU-----");
            System.out.print("1- Consulta de Centros de Vacinação (Nome + Comprimento)");
            System.out.print("2- Inscrição para a vacina (Enviar Nome, Genero e Idade)");
            System.out.print("3- Reportar Efeitos Secundários (antes da realização da vacina)");
            System.out.print("4- Realização de uma vacina ( com codigo X --> remover o cidadão da lista de espera do centro onde se encontrava)");
            System.out.print("5- Estatistica");

            System.out.print("Insert option:");
            Scanner scan = new Scanner(System.in);
            option = scan.nextInt();
            
            if (option == 1) {
                
            } else if (option == 2) {
                
            } else if (option == 3) {
                
            } else if (option == 4) {
                
            } else if (option == 5) {
                
            } else if (option == 6) {
                
            } else if (option == 7) {
                
            } else {
                System.out.println("Invalid Option");
            }
        }
    }

}