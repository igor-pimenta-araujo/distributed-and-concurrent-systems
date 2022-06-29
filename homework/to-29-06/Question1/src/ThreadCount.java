public class ThreadCount extends Thread {
    int count;

    public ThreadCount(int count) {
        this.count = count;
    }

    public void run() {
        for (int i = 1; i <= count; i++) {
            System.out.println(i);
        }
        System.out.println("Finished the thread!");
    }
}