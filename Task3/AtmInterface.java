import java.util.Scanner;

class BankAtm {
    private double balance;

    public BankAtm(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;

    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $ " + amount);
        }
        else {
            System.out.println("Invalid deposit amount. ");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn $ " + amount);
        }
        else{
            System.out.println("Invalid Withdrawal amount or Insufficient balance. ");
        }
    }
}

class ATM {
    private BankAtm account;

    public ATM(BankAtm account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance ");
        System.out.println("2. Deposit ");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");

    }

    public void start(){
        Scanner sc = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: $ " + account.getBalance());
                    break;
                
                case 2:
                    System.out.print("Enter Deposit Amount: $");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter Withdrawal amount: $");
                    double WithdrawalAmount = sc.nextDouble();
                    account.withdraw(WithdrawalAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please select a valid option. ");
            }
        }
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        BankAtm userAccount = new BankAtm(1000);

        ATM atm = new ATM(userAccount);

        atm.start();
    }
}
