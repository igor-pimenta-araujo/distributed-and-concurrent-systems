public class Tela {
    // Recurso disputado
    String texto;

    public synchronized void setTexto(String s) {
        texto = s;
    }

    public synchronized void mostraTexto() {
        System.out.println(texto);
    }
}