public class Contador extends Thread {

    public void run() {
        for (int i = 1; i < 11; i++) {
            System.out.println("Contador da Thread " + Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }    
}
