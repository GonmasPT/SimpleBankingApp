package src;

import java.util.Scanner;

public class SimpleBankingApp {

    private final String userName;
    private double balance;

    public SimpleBankingApp(String userName, double initialBalance) {
        this.userName = userName;
        this.balance = initialBalance;
    }

    public void checkBalance() {
        System.out.println("\nCurrent balance: " + this.balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("\nDeposit successful! Current balance: " + this.balance);
        } else {
            System.out.println("\nInvalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("\nWithdraw successful! Current balance: " + this.balance);
        } else if (amount > this.balance) {
            System.out.println("\nInsufficient balance.");
        } else {
            System.out.println("\nInvalid withdraw amount.");
        }
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.printf("\nWelcome %s!\n", this.userName);
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your option: ");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid option!");
            }

        } while (option != 4);

        scanner.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Simple Banking App!");
        System.out.println("Enter your name: ");
        String userName = scanner.nextLine();

        System.out.println("Enter your initial balance: ");
        double initialBalance = scanner.nextDouble();

        SimpleBankingApp bankingApp = new SimpleBankingApp(userName, initialBalance);
        bankingApp.showMenu();
    }
}