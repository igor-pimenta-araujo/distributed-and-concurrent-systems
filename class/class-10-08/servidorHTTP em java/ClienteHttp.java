/* -------------------------------------------------------------- */
/* Programa: ClienteHTTP                                          */
/* Autor: Sergio Teixeira de Carvalho                             */
/* Linguagem Utilizada: Java (JDK 1.1)                            */
/*                                                                */
/* Funcoes:                                                       */
/*      - permite estabelecimento de uma conexao TCP com          */
/*      a porta 80 (default) de um host fornecido;                */
/*      - pede como entrada uma URI e requisita do host           */
/*        o documento em questao atraves do metodo GET;           */
/*      - mostra pagina HTML sem nenhum processamento.            */
/*                                                                */
/* Formato da PDU: GET espaco URI espaco Versao-HTTP CRLF.        */
/*                       (A versao assumida e' a HTTP/1.0)        */
/*                                                                */                                                                                      
/*                                                                  */
/* Uso: $ java ClienteHTTP NomeDoHost URI [porta]                   */
/*                                                                  */
/* -------------------------------------------------------------- */

import java.io.*;       //Package de classes para manipulacao de E/S
import java.net.*;//Package de classes para manipulacao de Sockets, IP, etc

public class ClienteHttp {   public static void main (String[] args) throws IOException {

	/* ---declaracao dos objetos utilizados--- */

        final String versaoHTTP = "HTTP/1.0";//Definicao da versao HTTP
        final int portaDefault = 8080;    //Definicao da porta default

        String nomeHost = null;         //Nome do host para conexao
        String uri = null;              //URI para conexao
        int porta = portaDefault;       //Porta para conexao
      String pdu = null;                //PDU com requisicao HTTP

        Socket sock = null;     //Declaracao de objeto da classe Socket 

        PrintWriter saida = null;       //Fluxo de saida
        BufferedReader entrada = null;//Fluxo de entrada
	String linhaResposta = null;  //Linha de resposta do host

 
        /* ---tratamento dos argumentos--- */

        if ((args.length == 2) || (args.length == 3)){
                nomeHost = args[0];     //Host e' 1o. argumento
                uri = args[1];          //URI e' 2o. argumento
                if (args.length == 3) {porta = Integer.parseInt(args[2]);}
                //Porta fornecida como argumento sobrepoe porta default
        }
        else {  //Fornecimento erroneo dos argumentos
                System.out.println("\n\nUso Correto: ClienteHttp NomeDoHost URI [porta]\n\n");
                System.exit(1);
        }
                
        try {
	        sock = new Socket(nomeHost, porta);  
                        //Objeto sock criado atraves do construtor Socket
                        //adequado a uma conexao TCP confiavel (stream).
                        //Corresponde as instrucoes socket() e connect() 

                 saida = new PrintWriter(sock.getOutputStream(), true);
                        //Prepara saida para envio posterior da PDU

                 entrada = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                        //Prepara entrada para recepcao de mensagens do host
	}
	catch(UnknownHostException e) {
	        System.err.println("\n\nHost nao encontrado!\n");
                System.out.println("\nUso: ClienteHttp NomeDoHost URI [porta]\n\n");
                System.exit(1);
	}
	catch(java.io.IOException e) {
	        System.err.println("\n\nConexao com Host nao pode ser estabelecida.\n");
                System.out.println("\nUso: ClienteHttp NomeDoHost URI [porta]\n\n");
                System.exit(1); 
	}
                         
        /* ---montagem e envio da PDU ---*/

        pdu = "GET" + " " + uri + " " + versaoHTTP + "\r\n";
        saida.println(pdu);

        /* --- recepcao das mensagens do host ---*/

         System.out.println("\nResposta do Host:\n");
        linhaResposta = entrada.readLine();
         while (linhaResposta != null) {
         System.out.println(linhaResposta);
           linhaResposta = entrada.readLine();
        }
          
        /* ---fechamento do socket ---*/

	sock.close();
   }
}
