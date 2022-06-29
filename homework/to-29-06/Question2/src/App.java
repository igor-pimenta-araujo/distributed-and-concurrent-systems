public class App {
    public static void main(String[] args) throws Exception {
        ThreadFruit fruitOne = new ThreadFruit("pineapple");
        ThreadFruit fruitTwo = new ThreadFruit("apple");
        ThreadFruit fruitThree = new ThreadFruit("orange");
        ThreadFruit fruitFour = new ThreadFruit("banana");
        ThreadFruit fruitFive = new ThreadFruit("grape");

        fruitOne.start();
        fruitTwo.start();
        fruitThree.start();
        fruitFour.start();
        fruitFive.start();

        try {
            fruitOne.join();
            fruitTwo.join();
            fruitThree.join();
            fruitFour.join();
            fruitFive.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("Finished all the threads!");
    }
}
