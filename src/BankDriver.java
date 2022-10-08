import java.io.Console;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class BankDriver {

    public static void main(String[] args) {

        System.out.println("------------------------------");
        System.out.println(welcome());
        System.out.println("------------------------------");

        System.out.println("BANKING MAIN MENU - Select one option");
        System.out.println("1. Deposit Amount to an account");
        System.out.println("2. Withdraw an Amount from an account");
        System.out.println("3. Print Account Details");
        System.out.println("4. Print All Account Details");
        System.out.println("5. Print Max Loan Amount Details");
        System.out.println("6. Exit the app");



    }

    // Generates Random Welcome Message using Random Class
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
