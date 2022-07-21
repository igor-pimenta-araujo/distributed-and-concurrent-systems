public class RequestRelease {
    public static void main(String[] args) {

        // Criação do recurso a ser compartilhado
        Tela recurso = new Tela();

        // Criação do monitor
        ControlaAcesso monitor = new ControlaAcesso(recurso);
        // ** Criando as threads
        Usuario us01 = new Usuario("Usuario 01", monitor);
        Usuario us02 = new Usuario("Usuario 02", monitor);
        Usuario us03 = new Usuario("Usuario 03", monitor);
        Usuario us04 = new Usuario("Usuario 04", monitor);

        // ** Executando as threads
        us02.start();
        us01.start();
        us04.start();
        us03.start();
    }
}