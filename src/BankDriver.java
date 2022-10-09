import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BankDriver {

    public static Boolean debug = false;
    static List<BankAccount> accounts = new ArrayList<BankAccount>();

    public static void main(String[] args) {

        System.out.println("------------------------------");
        System.out.println(Welcome());
        System.out.println("------------------------------");

        BankAccount accountOne = new BankAccount();
        BankAccount accountTwo = new BankAccount();

        accountOne.BankAccount();
        accounts.add(accountOne);

//        accountTwo.BankAccount();
//        accounts.add(accountTwo);

        MainMenu(accountOne);

        if (debug == true) {
            System.out.println(accountOne.toString());
            //System.out.println(accountTwo.toString());
        }

    }

    public static void MainMenu(BankAccount account) {

        Scanner reader = new Scanner(System.in);
        int userInput;

        do {

            System.out.println("BANKING MAIN MENU - Select one option");
            System.out.println("1. Deposit Amount to an account");
            System.out.println("2. Withdraw an Amount from an account");
            System.out.println("3. Print Account Details");
            System.out.println("4. Print All Account Details");
            System.out.println("5. Print Max Loan Amount Details");
            System.out.println("6. Exit the app");

            userInput = reader.nextInt();

            switch(userInput) {
                case 1:
                    if (account.Auth(account)) {
                        System.out.print("Deposit: ");
                        BankAccount.Deposit(reader.nextInt());
                    }
                    break;
                case 2:
                    if (account.Auth(account)) {
                        System.out.print("Withdraw: ");
                        BankAccount.Withdraw(reader.nextInt());
                    }
                    break;
                case 3:
                    if (account.Auth(account)) {
                        System.out.println(account.toString());
                    }
                    break;
                case 4:
                    if (account.Auth(account)) {
                        for (BankAccount acc : accounts) {
                            System.out.println(acc.toString());
                        }
                    }
                    break;
                case 5:
                    if (account.Auth(account)) {
                        System.out.println(account.MaximumLoanAmountText());
                    }
                    break;
                case 6:
                    break;
                default:
                    System.out.println("INVALID OPTION");
            }
        } while (userInput != 6);
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
