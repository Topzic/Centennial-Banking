/*
    Author:     Ian Cunningham
    Date:       10/08/2022
 */

import java.util.concurrent.ThreadLocalRandom;

public class BankAccount {

    // region Getters and Setters
    private String name;
    public String GetName() { return name; }
    public void SetName(String setName) { this.name = setName; }

    int pin;
    public int GetPin() { return pin; }
    public void SetPin(int setPin ) { this.pin = setPin; }

    double balance;
    public double GetBalance() { return balance; }
    public void SetBalance(double setBalance) { this.balance = setBalance; }

    long accountNumber;
    public long GetAccountNumber() { return accountNumber; }
    public void SetAccountNumber(long number) { this.accountNumber = number; }
    // endregion

    // Bank Account Number Generator
    public int AccountNumberGenerator() {
        accountNumber = ThreadLocalRandom.current().nextInt(1000, 2000);
        return (int) accountNumber;
    }

    // Checks and Returns Account Type
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

    // Checks Accounts Maximum Loan Amount Depending on Account Type
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

    // Deposit Money
    public void Deposit(double amount) {
        balance += amount;
    }

    // Withdraw Money
    public void Withdraw(double amount) {
        balance -= amount;
    }

    @Override // object to string
    public String toString() {
        return "BankAccount{" +
                "name='" + GetName() + '\'' +
                ", pin=" + GetPin() +
                ", balance=" + GetBalance() +
                ", accountNumber=" + GetAccountNumber() +
                '}';
    }
}
