public class Usuario extends Thread {
    private ControlaAcesso monitor;
    private String nomeThread;

    public Usuario(ControlaAcesso monitor, String nomeThread) {
        this.monitor = monitor;
        this.nomeThread = nomeThread;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            monitor.request(); // Solicita o monitor para usar o recurso
            monitor.setRecurso(nomeThread);
            try {
                sleep(30);
            } catch (Exception e) {
            }
            monitor.getRecurso(); // Imprime o recurso
            monitor.release(); // Libera o monitor para o uso do recurso
        }
    }
}