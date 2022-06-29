public class ThreadExemplo {
    public static void main(String[] args) {
        ThreadSimples t01 = new ThreadSimples("Thread01");
        ThreadSimples t02 = new ThreadSimples("Thread02");

        t01.start();
        t02.start();
    }
}