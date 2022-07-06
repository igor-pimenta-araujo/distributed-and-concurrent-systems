public class ExecutaThread {
    public static void main(String args[]) {
        ThreadSimples simples = new ThreadSimples();
        Thread thread = new Thread(simples);
        thread.start();
    }
}
