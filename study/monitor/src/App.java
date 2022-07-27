public class App {
    public static void main(String[] args) throws Exception {
        
        Tela tela = new Tela();

        ControlaAcesso monitor = new ControlaAcesso(tela);

        Usuario usuario1 = new Usuario(monitor, "Usuario 1");
        Usuario usuario2 = new Usuario(monitor, "Usuario 2");

        usuario1.start();
        usuario2.start();
    }
}
