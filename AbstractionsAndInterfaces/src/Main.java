import accounts.Account;
import accounts.SavingAccount;
import accounts.CheckingAccount;
import accounts.CreditAccount;
import clients.Client;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("Petr", 5_000_000L);
        //накопительный счет
        Account savingsAccount = new SavingAccount(client1.holder, client1.balance, -2_000_000L);
        //расчетный счет
        Account checkingAccount = new CheckingAccount(client1.holder, client1.balance + 2_000_000L);
        //кредитный счет
        Account creditAccount = new CreditAccount(client1.holder, 0L);
        //добавим сразу 3 счета клиенту
        client1.add(savingsAccount);
        client1.add(checkingAccount);
        client1.add(creditAccount);
        Long amount = 4_000_000L;
        System.out.println(client1.holder + "| Накопительный -> Расчетный на сумму: " + amount);
        //покажем счета до операции трансфера
        System.out.println(client1.holder + " " + Arrays.toString(client1.accounts));
        //операция трансфера
        savingsAccount.transfer(checkingAccount, amount);
        //покажем счета после операции трансфера
        System.out.println(client1.holder + " " + Arrays.toString(client1.accounts));

        //Добавляем второго клиента
        Client client2 = new Client("Ivan", 3_000_000L);
        Account checkingAccountClient2 = new CheckingAccount(client2.holder, client2.balance);
        Account creditAccountClient2 = new CreditAccount(client2.holder, 0L);
        client2.add(checkingAccountClient2);
        client2.add(creditAccountClient2);

        //покажем счета второго клиента
        System.out.println("------------------------");
        System.out.println(client2.holder + " " + Arrays.toString(client2.accounts));
        //Перевод средств от первого второму клиенту
        System.out.println("------------------------");
        //Ошибочный перевод средств второму клиенту от первого клиента
        System.out.println(client1.holder + "| Расчетный -> " + client2.holder + "| Кредитный на сумму: " + amount);
        System.out.println("Перевод клиенту " + client2.holder + " на кредитный счет: " + checkingAccount.transfer(creditAccountClient2, amount));
        //Успешный перевод средств второму клиенту от первого клиента
        System.out.println("------------------------");
        System.out.println(client1.holder + "| Расчетный -> " + client2.holder + "| Расчетный на сумму: " + amount);
        System.out.println("Перевод клиенту " + client2.holder + " на расчетный счет: " + checkingAccount.transfer(checkingAccountClient2, amount));
        System.out.println(client1.holder + " " + Arrays.toString(client1.accounts));
        System.out.println(client2.holder + " " + Arrays.toString(client2.accounts));
    }
}