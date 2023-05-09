class BalanceThread extends Thread {
    private BankBalance bankBalance;
    private int amount;
    public BalanceThread(BankBalance bankBalance, int amount) {
        this.bankBalance = bankBalance;
        this.amount = amount;
    }
    @Override
    public void run() {
        bankBalance.add(this.amount);
    }
}