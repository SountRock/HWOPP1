import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Account account = new Account("Anton");
        //account.putAmount(2000.0);
        //System.out.println(account.takeAmount(2000.0));
        //account.commandUp();

        //CreditAccount creditAccount = new CreditAccount("Vlad", 1000);
        //creditAccount.commandUp();

        DepositAccount depositAccount = new DepositAccount(1000,"Vlad");
        depositAccount.commandUp();

    }

}