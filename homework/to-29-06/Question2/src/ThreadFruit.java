public class ThreadFruit extends Thread {
    String fruitName;

    public ThreadFruit(String name) {
        this.fruitName = name;
    }

    public void run() {
        try {
            for (int i = 0; i < 6; i++) {
                System.out.println(i + " " + fruitName);
                Thread.sleep(500);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}