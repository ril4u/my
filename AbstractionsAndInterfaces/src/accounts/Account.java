package accounts;

public abstract class Account implements MoneyTarget {
    public Long balance;
    public String holder;

    public Account(String holder, Long balance) {
        this.balance = balance;
        this.holder = holder;
    }

    public boolean transfer(Account accountTo, Long amount) {
        if (amount > 0) {
            if (accountTo.accept(amount)) {
                if (this.pay(amount)) {
                    return true;
                } else {
                    accountTo.pay(amount);
                    return false;
                }

            } else {
                return false;
            }
        } else return false;

    }


    public boolean pay(Long amount) {
        if (balance >= amount && amount > 0) {
            balance -= amount;
            return true;
        } else return false;
    }

    public boolean accept(Long money) {
        if (money > 0) {
            balance += money;
            return true;
        } else return false;
    }

    @Override
    public String toString() {
        return "~~~ У клиента " + holder + " текущий баланс счета: " + balance + " ~~~";
    }
}