public class Lebre extends Thread {
    int metrosPulados = 0;
    int quantidadePulos = 0;
    long tempoExec = 0;
    String nome;

    public Lebre(String nome) {
        this.nome = nome;
    }
    
    public void run() {
        long tempoInicio = System.currentTimeMillis();
        while (metrosPulados < 20) {
            pular();
            try {
                Thread.yield();
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        long tempoFim = System.currentTimeMillis();
        tempoExec = tempoFim - tempoInicio;
        System.out.println("Lebre " + getName() + " terminou com " + quantidadePulos + " pulos");
    }

    public void pular(){
        int pulo = (int) (Math.random() * 3) + 1;
        System.out.println("Lebre " + Thread.currentThread().getName() + " pulou " + pulo + " metros.");
        metrosPulados += pulo;
        quantidadePulos++;
    }

    public int getMetrosPulados() {
        return metrosPulados;
    }

    public int getQuantidadePulos() {
        return quantidadePulos;
    }

    public long getTempoExec() {
        return tempoExec;
    }
}
