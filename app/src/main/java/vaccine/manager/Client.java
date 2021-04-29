package vaccine.manager;

import java.util.LinkedList;
import java.util.Scanner;  // Import the Scanner class
import java.net.Socket;
import java.io.*;

public class Client {

    private String Address;
    private int Port;
    private Socket s;

    public Client(){
        
        try{
            Address = "localhost";
            Port = 0;
            s = new Socket(Address, Port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Client(String address, int port){
        Address = address;
        Port = port;
    }

    public void setServer(String add, int p) {
        Address = add;
        Port = p;
    }

    public static void getCenterInfo(Socket s,String center_region){
        
        //request
        try{
            
            OutputStream out = s.getOutputStream();
            ObjectOutputStream output = new ObjectOutputStream(out);
            
            Request new_request = new Request();
            new_request.setOption(1);
            new_request.getString_data().add(center_region);

            output.writeObject(new_request);

            //answear
            InputStream in = s.getInputStream();
            ObjectInputStream input = new ObjectInputStream(in);
            Object resposta = input.readObject();

            System.out.println("RESPOSTA: " + resposta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void subscription(Socket s,String user_name,String gender,String age){
        
        //request
        try{
            
            OutputStream out = s.getOutputStream();
            ObjectOutputStream output = new ObjectOutputStream(out);
            
            Request new_request = new Request();
            new_request.setOption(2);
            new_request.getString_data().add(user_name);
            new_request.getInt_data().add(Integer.parseInt(gender));
            new_request.getInt_data().add(Integer.parseInt(age));

            output.writeObject(new_request);
            

            //answear
            InputStream in = s.getInputStream();
            ObjectInputStream input = new ObjectInputStream(in);
            Object resposta = input.readObject();

            System.out.println("RESPOSTA: " + resposta);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void report(Socket s, String cod, LinkedList<String> secEfects){
        
        //request
        try{
            
            OutputStream out = s.getOutputStream();
            ObjectOutputStream output = new ObjectOutputStream(out);
            
            Request new_request = new Request();
            new_request.setOption(3);
            new_request.getInt_data().add(Integer.parseInt(cod));
            new_request.setString_data(secEfects);

            output.writeObject(new_request);

            //answear
            InputStream in = s.getInputStream();
            ObjectInputStream input = new ObjectInputStream(in);
            Object resposta = input.readObject();

            System.out.println("RESPOSTA: " + resposta);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void vaccination(Socket s, String cod){
        
        //request
        try {
            
            OutputStream out = s.getOutputStream();
            ObjectOutputStream output = new ObjectOutputStream(out);
            
            Request new_request = new Request();
            new_request.setOption(4);
            new_request.getInt_data().add(Integer.parseInt(cod));

            output.writeObject(new_request);

            //answear
            InputStream in = s.getInputStream();
            ObjectInputStream input = new ObjectInputStream(in);
            Object resposta = input.readObject();

            

            System.out.println("RESPOSTA: " + resposta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void statistic(Socket s){
        
        //request
        try{
            
            OutputStream out = s.getOutputStream();
            ObjectOutputStream output = new ObjectOutputStream(out);
            
            Request new_request = new Request();
            new_request.setOption(5);
        
            output.writeObject(new_request);

            //answear
            InputStream in = s.getInputStream();
            ObjectInputStream input = new ObjectInputStream(in);
            Object resposta = input.readObject();

            System.out.println("RESPOSTA: " + resposta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String s = null;
        int lidos;
        byte[] b = new byte[256];

        Client user = new Client();
        int option;

        //agrumentos com host e ip
        //user.setServer(add,ip);

        System.out.println("Welcome to the system");

        try {
            while (true) {
                
                System.out.println("-----MENU-----");
                System.out.println("1- Consulta de Centros de Vacinação (Nome + Comprimento)");
                System.out.println("2- Inscrição para a vacina (Enviar Nome, Genero e Idade)");
                System.out.println("3- Reportar Efeitos Secundários (antes da realização da vacina)");
                System.out.println("4- Realização de uma vacina ( com codigo X --> remover o cidadão da lista de espera do centro onde se encontrava)");
                System.out.println("5- Estatistica");

                System.out.print("Insert option: ");
                s = scan.nextLine();
                option = Integer.parseInt(s);
                
                if (option == 1) {
                    
                    System.out.print("Insira a região do centro: ");
                    lidos = System.in.read(b, 0, 256);
                    String region = new String(b, 0, lidos - 1);
                    Client.getCenterInfo(user.s, region);


                } else if (option == 2) {

                    System.out.print("Insira o nome: ");
                    lidos = System.in.read(b, 0, 256);
                    String name = new String(b, 0, lidos - 1);

                    System.out.print("Insira o genero (1 -> M; 2 -> F):");
                    lidos = System.in.read(b, 0, 256);
                    String gen = new String(b, 0, lidos - 1);


                    System.out.print("Insira a idade: ");
                    lidos = System.in.read(b, 0, 256);
                    String age = new String(b, 0, lidos - 1);

                    Client.subscription(user.s, name, gen, age);
                    
                } else if (option == 3) {
                    
                    System.out.print("Insira o cod: ");
                    lidos = System.in.read(b, 0, 256);
                    String cod = new String(b, 0, lidos - 1);

                    String efec = new String("");
                    LinkedList<String> secEfects = new LinkedList<>(); 
                    System.out.print("Insira o sintoma que sente: ");

                    while (efec.equals("nao")) {

                        lidos = System.in.read(b, 0, 256);
                        efec = new String(b, 0, lidos - 1);
                        secEfects.add(efec);
                        System.out.print("Mais algum?: ");
                    }

                    Client.report(user.s, cod, secEfects);

                } else if (option == 4) {
                    
                    System.out.print("Insira o cod: ");
                    lidos = System.in.read(b, 0, 256);
                    String cod = new String(b, 0, lidos - 1);

                    Client.vaccination(user.s, cod);

                } else if (option == 5) {
                    
                    Client.statistic(user.s);
                                    
                } else {
                    System.out.println("Invalid Option");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}