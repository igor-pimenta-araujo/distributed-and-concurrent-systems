public class Account extends Thread {

    private double balance;
    private String name;
    private String accountNumber;
    private boolean isOccupied;

    public Account(String name, String accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = 100;
        this.isOccupied = false;
    }

    public void run() {
       updateBalance();
    }

    public double getBalance() {
        return this.balance;
    }

    public synchronized void updateBalance() {
        if (isOccupied) {
            System.out.println(this.name + "'s account is occupied");
        } else {
            isOccupied = true;
            this.balance = this.balance * 1.1;
            System.out.println(this.name+ "'s balance is: " + balance);
            isOccupied = false;
        }

    }

    public synchronized void deposit(double amount) {
        if (isOccupied) {
            System.out.println(this.name + "'s account is occupied");
        } else {
            isOccupied = true;
            this.balance += amount;
            System.out.println(this.name+ "'s balance is: " + balance);
            isOccupied = false;
        }
    }

}
