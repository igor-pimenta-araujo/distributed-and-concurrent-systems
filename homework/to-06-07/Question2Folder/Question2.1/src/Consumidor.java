public class Consumidor implements Runnable {
    private Deposito dep;
    private int time;

    public Consumidor(Deposito dep, int time) {
        this.dep = dep;
        this.time = time;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            dep.retirar();
            try {
                Thread.sleep(this.time * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
