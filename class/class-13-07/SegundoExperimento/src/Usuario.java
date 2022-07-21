public class Usuario extends Thread {
    private ControlaAcesso monitor; // Monitor
    private String nomeThread; // Identificação da thread

    public Usuario(String str, ControlaAcesso m) {
        monitor = m;
        nomeThread = str;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            monitor.request(); // Solicita o monitor para usar o recurso
            monitor.setRecurso(nomeThread);
            try {
                sleep(30);
            } catch (Exception e) {
            }
            monitor.usaRecurso();
            monitor.release(); // Libera o monitor para o uso do recurso
        }
    }
}