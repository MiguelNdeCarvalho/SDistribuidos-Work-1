package vaccine.manager;

import java.util.LinkedList;
import java.util.Scanner;

public class VaccineClient {

    public static void replyHandler(Answer server_answer){

        System.out.println(server_answer);

        if (server_answer.getReply() == 0) {
            
            System.out.println("Pedido inválido");
            
        } else if (server_answer.getReply() == 1) {
            
            String result = "Centros de saúde: ";

            for (int i = 0; i<server_answer.getString_data().size();i++) {
                result = result + server_answer.getString_data().get(i) + "; ";
            }

            System.out.println(result);

        } else if (server_answer.getReply() == 2) {

            //devia-se tratar da situação em que o centro não existe 
            System.out.println("Nº de utentes á espera em "+server_answer.getString_data().get(0)+": "+ server_answer.getInt_data().get(0));

        } else if (server_answer.getReply() == 3) {

            System.out.println("Pedido recusado, o codigo já está a ser utilizado");

        } else if (server_answer.getReply() == 4) {
           
            System.out.println("Pedido aceite,com o codigo "+server_answer.getString_data().get(0));

        }else if (server_answer.getReply() == 5) {
           
            System.out.println("Efeitos Secundários Guardados (se o codigo for válido)");

        }else if (server_answer.getReply() == 6) {
           
            System.out.println("Vacinação Realizada ("+server_answer.getString_data().get(0)+")");

        }else if (server_answer.getReply() == 7) {
           
            System.out.println("ERRO: Codigo Inválido ou Já existente ("+server_answer.getString_data().get(0)+")");

        }
/////////////////////////////////////////////////////////////

    }

    public static void main(String args[]) {
	String regHost = "localhost";
	String regPort = "3333";  // porto do binder

	if (args.length != 2) { // requer 3 argumentos
	    System.out.println
		("Usage: java sd.rmi.VaccineClient registryHost registryPort ");
	    System.exit(1);
	}
	regHost= args[0];
	regPort= args[1];


	try {
        Scanner scan = new Scanner(System.in);
        String s = null;
        int lidos;
        byte[] b = new byte[256];
        int option = 0;

	    Vaccine rmi =
	      (Vaccine) java.rmi.Naming.lookup("rmi://" 
                      + regHost +":"+regPort +"/vaccine");
	    
        while (true) {

            System.out.println("-----MENU-----");
            System.out.println("1- Consulta de Centros de Vacinação (Nome + Comprimento)");
            System.out.println("2- Consultar a fila de espera de um Centro de Vacinação");
            System.out.println("3- Inscrição para a vacina (Enviar Nome, Genero e Idade)");
            System.out.println("4- Reportar Efeitos Secundários (antes da realização da vacina)");
            System.out.println("5- Realização de uma vacina ( com codigo X --> remover o cidadão da lista de espera do centro onde se encontrava)");
            System.out.println("6- Estatistica");
            System.out.println("7- EXIT");

            Request new_request = new Request();

            System.out.print("Insert option: ");
            s = scan.nextLine();
            option = Integer.parseInt(s);
            
            if (option == 1) {
                
                new_request = new Request();
                new_request.setOption(1);

            } else if (option == 2) {

                System.out.print("Insira o nome do centro: ");
                lidos = System.in.read(b, 0, 256);
                String centro = new String(b, 0, lidos - 1);

                new_request = new Request();
                new_request.setOption(2);
                new_request.getString_data().add(centro);

            } else if (option == 3) {

                System.out.print("Insira o código: ");
                lidos = System.in.read(b, 0, 256);
                String cod = new String(b, 0, lidos - 1);

                System.out.print("Insira o nome: ");
                lidos = System.in.read(b, 0, 256);
                String name = new String(b, 0, lidos - 1);

                System.out.print("Insira o genero: ");
                lidos = System.in.read(b, 0, 256);
                String gen = new String(b, 0, lidos - 1);


                System.out.print("Insira a idade: ");
                lidos = System.in.read(b, 0, 256);
                String age = new String(b, 0, lidos - 1);

                new_request = new Request();
                new_request.setOption(3);
                new_request.getString_data().add(cod);
                new_request.getString_data().add(name);
                new_request.getString_data().add(gen);
                new_request.getInt_data().add(Integer.parseInt(age));

            }else if (option == 4) {
                
                System.out.print("Insira o cod: ");
                lidos = System.in.read(b, 0, 256);
                String cod = new String(b, 0, lidos - 1);

                String efec = new String("");
                LinkedList<String> secEfects = new LinkedList<>(); 
                System.out.print("Insira o sintoma que sente: ");

                while (!efec.equals("nao")) {

                    lidos = System.in.read(b, 0, 256);
                    efec = new String(b, 0, lidos - 1);
                    if(!efec.equals("nao")){
                        secEfects.add(efec);
                    }
                    System.out.print("Mais algum?: ");
                }

                new_request = new Request();
                new_request.setOption(4);
                new_request.setString_data(secEfects);
                new_request.getString_data().add(cod);


            } else if (option == 5) {
                
                System.out.print("Insira o cod: ");
                lidos = System.in.read(b, 0, 256);
                String cod = new String(b, 0, lidos - 1);

                System.out.print("Insira o tipo da vacina: ");
                lidos = System.in.read(b, 0, 256);
                String vac = new String(b, 0, lidos - 1);

                new_request = new Request();
                new_request.setOption(5);
                new_request.getString_data().add(cod);
                new_request.getString_data().add(vac);


            } else if (option == 6) {
                
                new_request = new Request();
                new_request.setOption(6);
                                
            } else if (option == 7) {
                scan.close();
                System.exit(0);                            
            } else {
                
                System.out.println("Invalid Option");
            }

            VaccineClient.replyHandler(rmi.service(new_request));
        }
            

            // invocacao de métodos remotos

            /*
            String first = rmi.primeiraPalavra(frase) ;
            System.out.println("1a: "+first);

            List<String> v= rmi.divide(frase) ;
            System.out.println("divisao:");

            for (int i=0; i<v.size();i++) {
            System.out.println(i+" "+ v.get(i) );
            }
            */

        } 
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}