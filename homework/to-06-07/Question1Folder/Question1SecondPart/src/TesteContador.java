public class TesteContador {
    public static void main(String[] args) throws Exception {
        Contador c1 = new Contador();
        Thread thread = new Thread(c1);
        thread.start();
    }
}
