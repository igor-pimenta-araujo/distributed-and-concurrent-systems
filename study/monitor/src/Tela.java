public class Tela {
    //recurso disputado
    private String texto;

    public synchronized void setTexto(String texto) {
        this.texto = texto;
    }

    public synchronized void getTexto() {
        System.out.println("Recurso: " + texto);
    }
}