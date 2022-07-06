public class ThreadSimples {  //Cria a classe ThreadSimples
    static void mensagem(String messagem) { //Cria o método mensagem
        String nomeThread = Thread.currentThread().getName(); //Pega o nome da thread atual
        System.out.println(nomeThread + " " + messagem); //Imprime a mensagem
    }//Fim do método mensagem

    private static class Loop implements Runnable {//Cria a classe Loop
        public void run() {//Cria o método run
            String info[] = { //Cria um array de strings
                    "Java", 
                    "é uma boa linguagem.",
                    "Com threads,",
                    "é melhor ainda."
            };
            try { //Tenta executar o código abaixo
                for (int i = 0; i < info.length; i++) { //Percorre o array
                    Thread.sleep(4000); // Espera 4 segundos
                    mensagem(info[i]); // Imprime a mensagem
                }
            } catch (InterruptedException e) { //Se ocorrer um erro
                mensagem("Nada feito!"); // Imprime a mensagem
            }
        }
    }

    public static void main(String args[]) throws InterruptedException { //Cria o método main
        long paciencia = 1000 * 60 * 60; //Cria um long com a quantidade de milissegundos que será esperado
        if (args.length > 0) { //Se o array de argumentos tiver algum valor
            try { //Tenta executar o código abaixo
                paciencia = Long.parseLong(args[0]) * 1000; //Pega o valor do argumento e multiplica por 1000
            } catch (NumberFormatException e) { //Se ocorrer um erro
                System.err.println("Argumento deve ser um inteiro."); //Imprime a mensagem
                System.exit(1); //Sai do programa
            }
        }
        mensagem("Iniciando a thread Loop"); //Imprime a mensagem
        long inicio = System.currentTimeMillis(); //Pega o tempo atual
        Thread t = new Thread(new Loop()); //Cria uma nova thread com o método Loop
        t.start(); //Inicia a thread
        mensagem("Esperando que a thread Loop termine"); //Imprime a mensagem
        while (t.isAlive()) { //Enquanto a thread estiver ativa
            mensagem("Ainda esperando..."); //Imprime a mensagem
            t.join(1000); //Espera 1 segundo
            if (((System.currentTimeMillis() - inicio) > paciencia) && t.isAlive()) { //Se o tempo atual for maior que o tempo inicial mais a quantidade de milissegundos que será esperado
                mensagem("Cansado de esperar!"); //Imprime a mensagem
                t.interrupt(); //Interrompe a thread
                t.join(); //Espera a thread terminar
            }
        }
        mensagem("Finalmente!"); //Imprime a mensagem
    }
}

// Esse código foi feito para testar a flag de interrupção da thread. O mecanismo de interrupção é implementado usando um flag conhecido como interrupt status.
// O método interrupt() altera o flag de interrupção da thread. O método isInterrupted() verifica o flag de interrupção.
// O método join() espera a thread terminar.
// O método sleep() espera um tempo especificado em milissegundos.
// O método currentThread() retorna a thread atual.
// O método getName() retorna o nome da thread.