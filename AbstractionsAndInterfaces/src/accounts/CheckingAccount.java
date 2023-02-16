package accounts;

public class CheckingAccount extends Account {
    public CheckingAccount(String holder, Long balance) {
        super(holder, balance);
    }

    @Override
    public String toString() {
        return " Расчетный счет: " + balance + " ";
    }


}
