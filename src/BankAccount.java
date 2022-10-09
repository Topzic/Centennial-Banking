/**
    Author:     Ian Cunningham
    Date:       10/08/2022
 */

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class BankAccount {

    // region Getters and Setters
    private String name;
    public String GetName() { return name; }
    public void SetName(String setName) { this.name = setName; }

    private int pin;
    public int getPin() { return pin; }
    public void setPin(int setPin ) { this.pin = setPin; }

    private double balance;
    public double getBalance() { return balance; }
    public void setBalance(double setBalance) { this.balance = setBalance; }

    private long accountNumber;
    public long getAccountNumber() { return accountNumber; }
    public void SetAccountNumber(long number) { this.accountNumber = number; }

    private int accountType;
    public int getAccountType() { return accountType; }
    public void setAccountType(int accountType) { this.accountType = accountType; }
    // endregion

    /** Bank Account Number Generator */
    public int accountNumberGenerator() {
        accountNumber = ThreadLocalRandom.current().nextInt(1000, 2000);
        return (int) accountNumber;
    }

    /** BankAccount Constructor */
    public BankAccount(String Name, int Pin, double Balance, int Type) {
        accountNumberGenerator();
        this.name = Name;
        this.pin = Pin;
        this.balance = Balance;
        this.setAccountType(Type);
    }

    /** Default BankAccount Constructor */
    public BankAccount() {
        this.accountNumber = accountNumberGenerator();
        this.name = "";
        this.pin = 0000;
        this.balance = 0.00;
        this.accountType = 1;
    }

    /** Bank Account Creation */
    public void createBankAccount() {

        Scanner reader = new Scanner(System.in);

        System.out.println("-----Account Creation-----");

        accountNumberGenerator();

        System.out.print("Enter your name: ");
        this.SetName(reader.nextLine());

        System.out.print("Enter your Pin (4 digit - no spaces): ");
        this.setPin(reader.nextInt());

        System.out.print("Enter your Account Balance: ");
        this.setBalance(reader.nextInt());

        System.out.println("Select your Account Type: ");
        System.out.println("1. CHEQUING");
        System.out.println("2. SAVINGS");
        System.out.println("3. RRSP");
        System.out.println("4. TFSA");
        this.setAccountType(reader.nextInt());

        if (BankDriver.debug == true) {
            System.out.println(this.toString());
        }
    }

    /** Checks and Returns Account Type */
    public static AccountType conversion(int reference) {
        AccountType type;
        switch (reference) {
            case 1:
                type = AccountType.CHEQUING;
                break;
            case 2:
                type = AccountType.SAVING;
                break;
            case 3:
                type = AccountType.TFSA;
                break;
            case 4:
                type = AccountType.RRSP;
                break;
            default:
                type = null;
                break;
        }
         return type;
    }

    /**
     * Checks Accounts Maximum Loan Amount Depending on Account Type
     */
    public String maximumLoanAmountText() {

        double loanAmount = 0;
        DecimalFormat f = new DecimalFormat("##.00");
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
        return "------------------------------\n" +
                "Max Loan Amount: $" + f.format(loanAmount) +
                "\n------------------------------";
    }

    /**
     * Checks Accounts Maximum Loan Amount Depending on Account Type
     */
    public String maximumLoanAmount() {

        double loanAmount = 0.00;
        DecimalFormat f = new DecimalFormat("##.00");

        if (accountType == 1) {
            loanAmount = balance * 0.3;
        } else if (accountType == 2) {
            loanAmount = balance * 0.3;
        }
        else if (accountType == 3) {
            loanAmount = balance * 0.4;
        }
        else if (accountType == 4) {
            loanAmount = balance * 0.0;
        }

        return f.format(loanAmount);
    }

    /** Account Authentication */
    public BankAccount auth(List<BankAccount> accounts) {

        Scanner reader = new Scanner(System.in);
        System.out.print("Enter your Pin (4 digit - no spaces): ");
        int pin = reader.nextInt();

        for (BankAccount acc : accounts) {
            if (pin == acc.getPin()) {
                return acc;
            } else {

            }
        }
        System.out.println("Authentication Error.");
        return null;
    }

    /** Deposit Money */
    public void deposit(int amount) {
        System.out.println("-----Account Deposit-----");
        this.balance += amount;
    }

    /** Withdraw Money */
    public void withdraw(double amount) {
        System.out.println("-----Account Withdraw-----");

        if (this.balance > amount) {
            this.balance -= amount;
        } else {
            System.out.println("You do not have enough balance to withdraw that amount!");
        }
    }

    /** object to string */
    @Override
    public String toString() {
        return "------------------------------\n" +
                "Account Number: " + getAccountNumber() +
                "\nAccount Holder Name: " + GetName() +
                "\nAccount Balance: " + getBalance() +
                "\nAccount Type: " + conversion(getAccountType()) +
                "\nAccount Pin: " + getPin() +
                "\nMax Loan Amount: $" + maximumLoanAmount() +
                "\n------------------------------\n";
    }
}
