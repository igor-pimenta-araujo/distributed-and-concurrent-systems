public class ControlaAcesso {

    private boolean ocupado = false;
    private Tela recurso;

    public ControlaAcesso(Tela recurso) {
        this.recurso = recurso;
    }

    public synchronized void request() {
        while (ocupado) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        ocupado = true;
    }

    public synchronized void release() {
        ocupado = false;
        notifyAll();
    }

    public void setRecurso(String texto) {
        this.recurso.setTexto(texto);
    }

    public void getRecurso() {
        this.recurso.getTexto();
    }
    
}
