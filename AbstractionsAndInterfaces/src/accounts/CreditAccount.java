package accounts;

public class CreditAccount extends Account {
    public CreditAccount(String holder, Long balance) {
        super(holder, balance);


    }


    @Override
    public boolean pay(Long amount) {
        if (amount > 0) {
            balance -= amount;
            return true;
        } else return false;
    }

    @Override
    public boolean accept(Long money) {
        if (money + balance <= 0 && money > 0) {
            balance += money;
            return true;
        } else return false;
    }

    @Override
    public String toString() {
        return " Кредитный счет: " + balance + " ";
    }

}
