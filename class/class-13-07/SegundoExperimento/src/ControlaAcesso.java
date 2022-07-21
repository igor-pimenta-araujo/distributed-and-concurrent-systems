public class ControlaAcesso {
    private boolean ocupado = false;// controla se request foi feito
    private Tela recurso; // recurso do monitor
    // ** Construtor

    public ControlaAcesso(Tela r) {
        recurso = r;
    }

    // ** Método para liberar o recurso
    public synchronized void release() {
        ocupado = false;
        notifyAll();
    }

    // ** Método para requisitar o recurso
    public synchronized void request() {
        while (ocupado) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        ocupado = true;
    }

    public void setRecurso(String s) {
        recurso.setTexto(s);
    }

    public void usaRecurso() {
        recurso.mostraTexto();
    }
}