public class UserSemControle extends Thread {
    private Tela recurso; // Recurso disputado, sem proteção de acesso
    private String nomeThread; // Identificacao da thread

    public UserSemControle(String str, Tela r) {
        recurso = r;
        nomeThread = str;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            recurso.setTexto(nomeThread); // Seta recurso compartilhado
            try {
                sleep(30);
            } catch (Exception e) {
            }
            recurso.mostraTexto(); // Usa recurso compartilhado
        }
    }
}