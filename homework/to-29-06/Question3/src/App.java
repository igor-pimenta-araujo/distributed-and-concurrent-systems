public class App {
    public static synchronized void main(String[] args) throws Exception {
        Account account1 = new Account("John", "12345");
        Account account2 = new Account("Jane", "54321");
        Account account3 = new Account("Jack", "98765");

        account1.deposit(1000);
        account1.start();
        account2.start();
        account3.start();
        account2.deposit(2500);
        account3.deposit(3000);

        try {
            account1.join();
            account2.join();
            account3.join();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("----------------------------------------------------");
        System.out.println("Account 1 balance: " + account1.getBalance());
        System.out.println("Account 2 balance: " + account2.getBalance());
        System.out.println("Account 3 balance: " + account3.getBalance());

    }
}