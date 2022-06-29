public class App {
    public static void main(String[] args) throws Exception {
        ThreadCount t1 = new ThreadCount(100);

        t1.start();

        try {
            t1.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("Finished all the threads!");
    }
}
