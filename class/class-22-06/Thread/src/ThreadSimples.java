public class ThreadSimples extends Thread {
    String nomeThread;

    public ThreadSimples(String str) {
        nomeThread = str;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + nomeThread);
        }
        System.out.println("Ok! " + nomeThread);
    }
}