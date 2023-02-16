package clients;

import accounts.Account;
import accounts.MoneyTarget;

public class Client implements MoneyTarget {
    protected int maxNumberOfAccounts;
    public Account[] accounts;
    public Long balance;
    public String holder;

    public Client(String holder, Long balance) {
        this.holder = holder;
        this.balance = balance;
        maxNumberOfAccounts = 3;
        this.accounts = new Account[]{null, null, null};

    }

    public boolean add(Account account) {
        for (int i = 0; i < maxNumberOfAccounts; i++) {
            if (this.accounts[i] == null) {
                this.accounts[i] = account;
                //System.out.println(Arrays.toString(accounts));
                return true;
            }
        }
        System.out.println("Достигнуто максимальное кол-во счетов");
        return false;
    }

    @Override
    public boolean accept(Long money) {
        for (int i = 0; i < maxNumberOfAccounts; i++) {
            if (accounts[i] != null) {
                if (accounts[i].pay(money)) {
                    break;
                }
            }
        }
        return false;
    }
}