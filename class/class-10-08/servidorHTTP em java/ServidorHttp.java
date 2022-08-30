import java.net.*;
import java.io.*;

class ConexaoHttp extends Thread {

  final String msgBadRqt = "400 Bad Request";
  final String msgObjNF = "404 Object Not Found";

  final String caminhoDefault = File.separatorChar + "home" +
                                File.separatorChar + "http";
  final String docDefault = "/index.html";
  
  Socket socketCliente;
  
  ConexaoHttp (Socket aSocketCliente) throws IOException {
     this.socketCliente = aSocketCliente;
  }
  
  public void run() {
  
      boolean erroRqt = false;
      String msgErro = null;    
  
      PrintWriter saida = null;
      BufferedReader entrada = null;
                                   
      InetAddress endCliente = this.socketCliente.getInetAddress();
      
      String pdu = null;
      String uri = null;
      String linhaArq = null;      
            
      try {
         saida = new PrintWriter(this.socketCliente.getOutputStream(), true);
         entrada = new BufferedReader (new InputStreamReader(this.socketCliente.getInputStream()));
         
         pdu = entrada.readLine();
         if (!pdu.startsWith("GET")) { 
            erroRqt = true;
            msgErro = msgBadRqt;
         }
         else {
            uri = pdu.substring(4,pdu.length()-9);
            if (uri.equals("/")) 
               uri = docDefault;
             
            File arq = new File(uri.substring(1));
            if (!arq.exists()) { 
               erroRqt = true;
               msgErro = msgObjNF;
            }
            else {
               RandomAccessFile arquivo = new RandomAccessFile(arq, "r");
         
               linhaArq = arquivo.readLine(); 
               while (linhaArq != null) {
                  saida.println(linhaArq);
                  linhaArq = arquivo.readLine();
               }
               arquivo.close();
               System.out.println("Cliente " + endCliente.getHostAddress() +
                                  " atendido com a " + "pagina " + uri); 
            }
         }   
         
         if (erroRqt) { 
            saida.println ("<HTML>");
            saida.println ("<HEAD>");
            saida.println ("<TITLE>" + msgErro);
            saida.println ("</TITLE>");
            saida.println ("</HEAD>");
            saida.println ("<B>");
            saida.println ("<FONT SIZE=5>");
            saida.println ("<P>" + msgErro);
            saida.println ("</P>");
            saida.println ("</HTML>");
         }  

         socketCliente.close();
         saida.close();
         entrada.close();

      }
      catch ( IOException e ) {        
         System.out.println( "Erro E/S " + e );
      } 
  }
}

public class ServidorHttp {
    public static void main(String[] args) throws IOException {

        final int portaDefault = 8080;
        
        int porta;
        int backlog = 5;
        
        Socket socketCliente = null;
        ServerSocket socketServidor = null;
       
        if ((args.length == 1))
           porta = Integer.parseInt(args[0]);   
        else
           porta = portaDefault;
       
        while (true) {
           try {
                socketServidor = new ServerSocket(porta, backlog);
                break;
           }
           catch (IOException e) {
              porta++;
           }
        }

        System.out.println ("\nServidor HTTP ativado. " + 
                            "Aguardando Cliente HTTP na porta " + porta + "...\n");
 
        while (true) {

            socketCliente = null;
           try {
                 socketCliente = socketServidor.accept();
           } 
           catch (IOException e) {
                 System.err.println("Erro de E/S " + e);
                 System.exit(1);
           }
            
           new ConexaoHttp(socketCliente).start();
        }         
    }
}
