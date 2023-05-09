public class BankBalance {
    private long balance = 10000;
    public BankBalance() {
        balance = 10000;
    }
    public synchronized void add(long amount) {
        System.out.println("Balance before the operation " + getBalance());
        System.out.println("Sum of the operation " + amount);
        if ((amount+balance)<0) {
            System.out.println("Operation with amount " + amount + " cannot be performed");
        }
        else {
            balance += amount;
        }
    }
    public long getBalance(){
        return balance;
    }
}