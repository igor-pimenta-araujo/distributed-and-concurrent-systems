public class App {
    public static void main(String[] args) {
        int[] a = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int numberOfThreads = 5;
        int x = 20;
        findElement(numberOfThreads, x, a);
    }

    private static void findElement(int numberOfThreads, int x, int[] a) {
        int sizeOfa = a.length;
        int range = sizeOfa/numberOfThreads;
        for (int i = 0; i <= numberOfThreads-1; i++) {
            Thread searcher;
            if (i == numberOfThreads-1) {
                searcher = new Thread(new ParallelSearch(x, i*range, sizeOfa-1, a));
            } else {
                searcher = new Thread(new ParallelSearch(x, i*range, i*range+range-1, a));
            }
            searcher.start();
        }
    }
}