package accounts;

public class SavingAccount extends Account {
    protected Long minBalance;

    public SavingAccount(String holder, Long balance, Long minBalance) {
        super(holder, balance);
        this.minBalance = minBalance;
    }

    @Override
    public boolean pay(Long amount) {
        if (amount > 0 && (balance - amount >= minBalance)) {
            balance -= amount;
            return true;
        } else return false;
    }

    @Override
    public String toString() {
        return " Накопительный счет: " + balance + " ";
    }
}
