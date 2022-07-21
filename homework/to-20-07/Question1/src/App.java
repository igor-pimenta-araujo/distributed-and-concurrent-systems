public class App {
    public static void main(String[] args) throws Exception {
        ThreadPrimos threadPrimos = new ThreadPrimos( 1000000, 30000000);
        ThreadPrimos threadPrimos2 = new ThreadPrimos(90000000, 120000000);

        threadPrimos.start();
        threadPrimos2.start();

        try {
            threadPrimos.join();
            threadPrimos2.join();
        }catch(InterruptedException e){
            System.out.println(e);
        }

        threadPrimos.printaTempoExec();
        threadPrimos2.printaTempoExec();

    }
}
