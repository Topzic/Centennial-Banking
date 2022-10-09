/*
    Author:     Ian Cunningham
    Date:       10/08/2022
 */

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class BankAccount {

    // region Getters and Setters
    static String name;
    public static String GetName() { return name; }
    public void SetName(String setName) { this.name = setName; }

    public static int pin;
    public int GetPin() { return pin; }
    public void SetPin(int setPin ) { this.pin = setPin; }

    static double balance;
    public static double GetBalance() { return balance; }
    public void SetBalance(double setBalance) { this.balance = setBalance; }

    static long accountNumber;
    public static long GetAccountNumber() { return accountNumber; }
    public void SetAccountNumber(long number) { this.accountNumber = number; }

    static int accountType;
    public static int GetAccountType() { return accountType; }
    public void SetAccountType(int accountType) { this.accountType = accountType; }
    // endregion

    /** Bank Account Number Generator */
    public int AccountNumberGenerator() {
        accountNumber = ThreadLocalRandom.current().nextInt(1000, 2000);
        return (int) accountNumber;
    }

    /** Bank Account Creation */
    public void BankAccount() {

        Scanner reader = new Scanner(System.in);

        System.out.println("-----Account Creation-----");

        AccountNumberGenerator();

        System.out.print("Enter your name: ");
        name = reader.nextLine();

        System.out.print("Enter your Pin (4 digit - no spaces): ");
        pin = reader.nextInt();

        System.out.print("Enter your Account Balance: ");
        balance = reader.nextInt();

        System.out.println("Select your Account Type: ");
        System.out.println("1. CHEQUING");
        System.out.println("2. SAVINGS");
        System.out.println("3. RRSP");
        System.out.println("4. TFSA");
        accountType = reader.nextInt();

        if (BankDriver.debug == true) {
            System.out.println(this.toString());
        }
    }

    /** Checks and Returns Account Type */
    public static AccountType conversion(int reference) {
        AccountType type;
        switch (reference) {
            case 1:
                type = AccountType.CHEQUEING;
                break;
            case 2:
                type = AccountType.SAVING;
                break;
            case 3:
                type = AccountType.RRSP;
                break;
            case 4:
                type = AccountType.TFSA;
                break;
            default:
                type = AccountType.CHEQUEING;
                break;
        }
         return type;
    }

    /** Checks Accounts Maximum Loan Amount Depending on Account Type */
    public double MaximumLoanAmount() {

        double loanAmount = 0;

        for (int i = 1; i < 4; i++) {
            AccountType account = conversion(i);

            if (account == conversion(1)) {
                loanAmount = balance * 0.3;
            } else if (account == conversion(2)) {
                loanAmount = balance * 0.3;
            }
            else if (account == conversion(3)) {
                loanAmount = balance * 0.4;
            }
            else if (account == conversion(4)) {
                loanAmount = balance * 0.0;
            }
        }
        return loanAmount;
    }

    /** Account Authentication */
    public boolean Auth(BankAccount account) {

        Scanner reader = new Scanner(System.in);
        System.out.print("Please enter pin: ");

        if (reader.nextInt() == account.GetPin()) {
            return true;
        } else {
            System.out.println("Authentication Error.");
            return false;
        }

    }


    /** Deposit Money */
    public static void Deposit(int amount) {
        double oldBalance = GetBalance();
        System.out.println("Old Balance: " + oldBalance);
        balance += amount;
        System.out.println("New Balance: " + BankAccount.balance);
    }

    /** Withdraw Money */
    public static void Withdraw(double amount) {
        double oldBalance = GetBalance();
        System.out.println("Old Balance: " + oldBalance);
        balance -= amount;
        System.out.println("New Balance: " + BankAccount.balance);
    }

    /** object to string */
    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + GetName() + '\'' +
                ", pin=" + GetPin() +
                ", balance=" + GetBalance() +
                ", accountNumber=" + GetAccountNumber() +
                ", accountType=" + conversion(GetAccountType()) +
                '}';
    }
}
