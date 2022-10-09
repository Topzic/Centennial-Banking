import java.util.Random;
import java.util.Scanner;

public class BankDriver {

    public static Boolean debug = false;

    public static void main(String[] args) {

        System.out.println("------------------------------");
        System.out.println(Welcome());
        System.out.println("------------------------------");

        BankAccount accountOne = new BankAccount();
        accountOne.BankAccount();
        System.out.println(accountOne.toString());

        MainMenu(accountOne);

    }

    public static void MainMenu(BankAccount account) {

        Scanner reader = new Scanner(System.in);

        System.out.println("BANKING MAIN MENU - Select one option");
        System.out.println("1. Deposit Amount to an account");
        System.out.println("2. Withdraw an Amount from an account");
        System.out.println("3. Print Account Details");
        System.out.println("4. Print All Account Details");
        System.out.println("5. Print Max Loan Amount Details");
        System.out.println("6. Exit the app");

        switch(reader.nextInt()) {
            case 1:
                if (account.Auth(account)) {
                    System.out.print("Deposit: ");
                    BankAccount.Deposit(reader.nextInt());
                    MainMenu(account);
                } else {
                    MainMenu(account);
                }
                break;
            case 2:
                if (account.Auth(account)) {
                    System.out.print("Withdraw: ");
                    BankAccount.Withdraw(reader.nextInt());
                    MainMenu(account);
                } else {
                    MainMenu(account);
                }
                break;
            case 3:
                if (account.Auth(account)) {
                    System.out.println(account.toString());
                    MainMenu(account);
                } else {
                    MainMenu(account);
                }
                break;
            case 4:

        }

    }

    // Generates Random Welcome Message using Random Class
    public static String Welcome() {

        String[] messages = {
                "Welcome to Centennial Bank.",
                "How can we help you today?",
                "How can we serve your needs today?",
                "Welcome to your own developed Bank."
        };

        Random random = new Random();
        int num = random.nextInt(messages.length);
        String result =  messages[num];
        return result;
    }

}
