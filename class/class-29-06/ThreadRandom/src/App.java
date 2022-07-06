public class App {
    static int a = 0;

    public static void main(String[] args) throws Exception {
        new MyThread().start();
        a = 1;
    }

    public static class MyThread extends Thread {
        public void run() {
            System.out.println(a);
        }
    }
}
