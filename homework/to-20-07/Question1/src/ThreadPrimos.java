public class ThreadPrimos extends Thread {

    int inicio = 0;
    int fim = 0;
    int contador = 0;
    long tempoExec = 0;
    
    public ThreadPrimos(int inicio, int fim) {
        this.inicio = inicio;
        this.fim = fim;
    }
    
    public void run() {
        long tempoInicio = System.currentTimeMillis();
        for (int i = inicio; i <= fim; i++){
            if (isPrimo(i)){
                contador++;
                System.out.println(i);
            }
        }
        long tempoFim = System.currentTimeMillis();
        tempoExec = tempoFim - tempoInicio;
        System.out.println("Foram encontrados " + contador + " numeros primos.");
    }

    private static boolean isPrimo(int numero) {
        for (int j = 2; j < numero; j++) {
            if (numero % j == 0)
                return false;   
        }
        return true;
    }

    public void printaTempoExec(){
        System.out.println("O tempo de execução foi de: " + tempoExec + "ms");
    }
    
}
