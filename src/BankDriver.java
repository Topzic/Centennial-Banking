import java.util.*;

public class BankDriver {

    // Debug
    public static Boolean debug = false;

    // Bank Account List
    public static List<BankAccount> accounts = new ArrayList<BankAccount>();

    public static void main(String[] args) {

        // welcome message
        System.out.println("------------------------------");
        System.out.println(welcome());
        System.out.println("------------------------------");

        // creation of account one
        BankAccount accountOne = new BankAccount();
        accountOne.createBankAccount();
        accounts.add(accountOne);

        // creation of account two
        BankAccount accountTwo = new BankAccount();
        accountTwo.createBankAccount();
        accounts.add(accountTwo);

        // creation of account three
        BankAccount accountThree = new BankAccount("Jeff Thompson", 7777, 7500.00, 3);
        accounts.add(accountThree);

        // creation of account using default constructor
        BankAccount accountFour = new BankAccount();

        mainMenu(accountOne);

        if (debug == true) {
            System.out.println(accountOne.toString());
            System.out.println(accountTwo.toString());
            System.out.println(accountThree.toString());
        }

    }

    /** User Interface */
    public static void mainMenu(BankAccount account) {

        Scanner reader = new Scanner(System.in);
        int userInput;

        BankAccount temp = account;

        do {

            System.out.println("BANKING MAIN MENU - Select one option");
            System.out.println("1. Deposit Amount to an account");
            System.out.println("2. Withdraw an Amount from an account");
            System.out.println("3. Print Account Details");
            System.out.println("4. Print All Account Details");
            System.out.println("5. Print Max Loan Amount Details");
            System.out.println("6. Exit the app");

            userInput = reader.nextInt();

            /**
             * User input redirects to selected menu location, then User enters pin corresponding
             * to the account they want to access. If pin is incorrect it will return to main menu.
             * by calling MainMenu using a temp user, so it does not crash from having null user.
             */
            switch(userInput) {
                case 1:
                    account = account.auth(accounts);
                    if (account != null) {
                        System.out.print("Deposit: ");
                        account.deposit(reader.nextInt());
                    } else {
                        mainMenu(temp);
                    }
                    break;
                case 2:
                    account = account.auth(accounts);
                    if (account != null) {
                        System.out.print("Withdraw: ");
                        account.withdraw(reader.nextInt());
                    } else {
                        mainMenu(temp);
                    }
                    break;
                case 3:
                    account = account.auth(accounts);
                    if (account != null) {
                        System.out.println(account.toString());
                    } else {
                        mainMenu(temp);
                    }
                    break;
                case 4:
                    account = account.auth(accounts);
                    if (account != null) {
                        System.out.println("-----All Account Details-----");
                        for (BankAccount acc : accounts) {
                            System.out.println(acc.toString());
                        }
                    } else {
                        mainMenu(temp);
                    }
                    break;
                case 5:
                    account = account.auth(accounts);
                    if (account != null) {
                        System.out.println(account.maximumLoanAmountText());
                    } else {
                        mainMenu(temp);
                    }
                    break;
                case 6:
                    break;
                default:
                    System.out.println("INVALID OPTION");
            }
        } while (userInput != 6);
    }

    /** Generates Random Welcome Message using Random Class */
    public static String welcome() {

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
