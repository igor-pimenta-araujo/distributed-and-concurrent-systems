public class ParallelSearch implements Runnable {
    private int intToFind;
    private int startIndex;
    private int endIndex;
    private int[] arrayToSearchIn;

    public ParallelSearch(int x, int s, int e, int[] a) {
        intToFind = x;
        startIndex = s;
        endIndex = e;
        arrayToSearchIn = a;
    }

    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            if (arrayToSearchIn[i] == intToFind) System.out.println("Found x at index: " + i);
        }
    }
}