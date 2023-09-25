package chapter10.exercise07;

import java.io.*;
import java.util.*;

public class ATM {

  private enum Operation { WITHDRAW, DEPOSIT; }

  private static final int MAXIMUM_ACCOUNTS = 200;
  private static HashMap<Integer, Account> accounts = new HashMap<>(MAXIMUM_ACCOUNTS);
  private static int id = 0; // Current Account id
  private static final Scanner scanner = new Scanner(System.in);
  private static final String filepath = "data/chapter10/accounts.dat";

  private static void handleMainMenu() {
    clearDisplay();
    System.out.println("\t\t---- Main Menu ---- ");
    System.out.println("\t\t(1) Check Balance");
    System.out.println("\t\t(2) Withdraw");
    System.out.println("\t\t(3) Deposit");
    System.out.println("\t\t(4) Transactions");
    System.out.println("\t\t(5) Logout");
    int userInput = getUserInputInt();
    switch (userInput) {
      case 1  -> handleCheckBalance();
      case 2  -> handleWithdrawal();
      case 3  -> handleDeposit();
      case 4  -> handleTransactions();
      case 5  -> run();
      default -> handleMainMenu();
    }
  }

  private static void handleTransactions() {
    clearDisplay();
    System.out.println("\t\t---- Transactions ---- ");
    int count = 1;
    for (Transaction tran : accounts.get(id).getTransactions()) {
      System.out.println("\t\t(" + count + ") " + tran);
      count++;
    }
    System.out.println("\t\t---- Input ---- ");
    System.out.println("\t\t(1) Main Menu");
    int userInput = getUserInputInt();
    handleMainMenu();
  }

  private static void handleCheckBalance() {
    clearDisplay();
    System.out.println("\t\t---- Balance ----");
    System.out.printf( "\t\tYou have $%-12.4f\n", accounts.get(id).getBalance());
    System.out.println("\t\t-----------------");
    System.out.println("\t\t(-) Main Menu");
    int userInput = getUserInputInt();
    handleMainMenu();
  }

  private static void handleWithdrawal()  {
    clearDisplay();
    System.out.println("\t\t---- Withdraw ----");
    System.out.printf( "\t\tBalance: $%-12.4f\n", accounts.get(id).getBalance());
    System.out.println("\t\t------------------");
    System.out.println("\t\tEnter Amount in $");
    try {
      double amount = getUserInputDouble();
      accounts.get(id).withdraw(amount);
      updateFile();
      handleOperationMenu("Response: Success", Operation.WITHDRAW);
    } catch (RuntimeException e) {
      handleOperationMenu("Response: Insufficient balance", Operation.WITHDRAW);
    }
  }

  private static void handleDeposit() {
    clearDisplay();
    System.out.println("\t\t---- Deposit ----");
    System.out.printf( "\t\tBalance: $%-12.4f\n", accounts.get(id).getBalance());
    System.out.println("\t\t------------------");
    System.out.println("\t\tEnter Amount in $");
    double amount = getUserInputDouble();
    accounts.get(id).deposit(amount);
    updateFile();
    handleOperationMenu("Response: success", Operation.DEPOSIT);
  }

  private static void exit(int status) {
    System.out.println("\t\tExiting...");
    scanner.close();
    System.exit(status);
  }

  private static void handleLogin() {
    clearDisplay();
    System.out.println("\t\t---- Login ----");
    System.out.println("\t\t- Username");
    String username = getUserInput();
    // check if user exists
    if (getUserIdByUsername(username) == -1) {
      handleATMMenu("Response: User Doesn't Exist");
    } else {
      // if exists continue logging in
      System.out.println("\t\t- Password");
      String password = getUserInput();
      // validate password
      if (!accounts.get(getUserIdByUsername(username)).isPasswordValid(password))
        handleATMMenu("Response: Incorrect Password.");
      else {
        id = getUserIdByUsername(username);
        handleMainMenu();
      }
    }
  }

  private static void handleRegistration() {
    clearDisplay();
    System.out.println("\t\t---- Register ----");
    System.out.println("\t\t- Username");
    String username = getUserInput();
    // check if user already exists
    if (getUserIdByUsername(username) != -1) {
      handleATMMenu("Response: Username Exists");
    } else {
      // if it does not exist then require password
      System.out.println("\t\t- Password");
      String password = getUserInput();
      // Create an account using given credentials
      Account newAccount = new Account(username, password);
      accounts.put(newAccount.getId(), newAccount);
      // also save object in the file
      try (
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filepath, true));
        RandomAccessFile raf = new RandomAccessFile(filepath, "rw");
      ) {
        // write an object
        out.writeObject(newAccount);
        out.close();
        // update number of accounts in the file
        raf.writeInt(Account.CURRENT_ID);
      } catch (IOException e) {
        System.out.println("Error occurred while registering.");
        exit(-1);
      }
      // ask for input
      handleATMMenu("Response: Success");
    }
  }

  private static void handleATMMenu(String message) {
    System.out.println("\t\t" + message);
    System.out.println("\t\t(1) Login");
    System.out.println("\t\t(2) Register");
    System.out.println("\t\t(-) Exit");
    int userInput = getUserInputInt();
    switch (userInput) {
      case 1  -> handleLogin();
      case 2  -> handleRegistration();
      default -> exit(0);
    }
  }

  private static void handleOperationMenu(String message, Operation op) {
    System.out.println("\t\t" + message);
    System.out.println("\t\t---- Input ---- ");
    System.out.println("\t\t(1) Try Again");
    System.out.println("\t\t(2) Main Menu");
    int userInput = getUserInputInt();
    if (userInput == 1)
      switch (op) {
        case WITHDRAW -> handleWithdrawal();
        case DEPOSIT -> handleDeposit();
      }
    else
      handleMainMenu();
  }

  private static int getUserIdByUsername(String username) {
    for (Map.Entry<Integer, Account> entry : accounts.entrySet())
      if (entry.getValue().getUsername().equals(username))
        return entry.getKey();
    return -1;
  }

  private static String getUserInput() {
    System.out.print("\t\t>> ");
    return scanner.next();
  }

  private static int getUserInputInt() {
    System.out.print("\t\t>> ");
    return scanner.nextInt();
  }

  private static double getUserInputDouble() {
    System.out.print("\t\t>> ");
    return scanner.nextDouble();
  }

  /**
   * This function won't work on IDE's or Windows terminal. Only
   * linux and macOS is supported.
   * */
  private static void clearDisplay() {
    System.out.print("\033[H\033[2J");
  }

  private static void updateFile() {
    try (
      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filepath));
    ) {
      out.writeInt(Account.CURRENT_ID);
      for (Account account : accounts.values())
        out.writeObject(account);
    } catch (IOException e) {
      System.out.println("Error while updating file.");
      exit(-1);
    }
  }

  private static void cleanFile() {
    try (
      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filepath));
    ) {
      out.writeInt(0);
    } catch (IOException e) {
      System.out.println("Error while cleaning file.");
      exit(-1);
    }
  }

  public static void run() {
    // check if file exists
    File accountsFile = new File(filepath);
    if (accountsFile.exists())
      // Initialize accounts
      try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(accountsFile));
      ) {
        // first line stores number of accounts
        int numOfAccounts = in.readInt();
        Account.setCurrentId(numOfAccounts);
        // rest is accounts
        for (int i = 0; i < numOfAccounts; i++) {
          // get object
          Account account = (Account) in.readObject();
          accounts.put(account.getId(), account);
        }
      } catch (IOException | ClassNotFoundException e) {
        System.out.println("\t\tError while initializing accounts.");
        exit(-1);
      }
    else {
      // if not, create one
      try (
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(accountsFile));
      ) {
        out.writeInt(0);
      } catch (IOException e) {
        System.out.println("\t\tError while creating accounts file.");
        exit(-1);
      }
    }

    clearDisplay();
    handleATMMenu("---- ATM ----");
  }

  public static void main(String[] args) {
    cleanFile();
    run();
  }
}

class Transaction implements Serializable {
  protected static final char WITHDRAW = 'W';
  protected static final char DEPOSIT = 'D';
  private MyDate date;
  private final char type;
  private final double amount;
  private final double balance;
  private final String description;

  Transaction(char type, double amount, double balance, String description) {
    this.type = type;
    this.amount = amount;
    this.balance = balance;
    this.description = description;
    this.date = new MyDate();
  }

  @Override
  public String toString() {
    return description + " : " + date;
  }
}

class Account implements Serializable {
  protected int id;
  protected String username, password;
  protected double balance;
  protected static double annualInterestRate = 0.12;
  protected static int CURRENT_ID = 0;
  protected ArrayList<Transaction> transactions = new ArrayList<>();
  protected MyDate dateCreated;

  Account(String username, String password) {
    this.username = username;
    this.password = password;
    this.id = CURRENT_ID++;
    this.balance = 0;
  }

  void withdraw(double amount) {
    if (amount < 0)
      throw new RuntimeException("Cannot withdraw negative amount");
    if (amount > balance)
      throw new RuntimeException(
        String.format("Account%d: Cannot withdraw $%-4.4g. Balance is $%-4.4g.", id, amount, balance));
    balance -= amount;
    transactions.add(new Transaction(Transaction.WITHDRAW, amount, balance,
      String.format("Withdraw : $%-12.2f", amount)));
  }

  void deposit(double amount) {
    if (amount < 0)
      throw new RuntimeException("Cannot deposit negative amount");
    balance += amount;
    transactions.add(new Transaction(Transaction.DEPOSIT, amount, balance,
      String.format("Deposit  : $%-12.2f", amount)));
  }

  String getUsername() {
    return username;
  }

  public ArrayList<Transaction> getTransactions() {
    return transactions;
  }

  double getMonthlyInterest() {
    return balance * getMonthlyInterestRate();
  }

  double getMonthlyInterestRate() {
    return annualInterestRate / 12;
  }

  public double getBalance() {
    return balance;
  }

  public int getId() {
    return id;
  }

  public boolean isPasswordValid(String password) {
    return this.password.equals(password);
  }

  MyDate getDateCreated() {
    return dateCreated;
  }

  static void setAnnualInterestRate(int annualInterestRate) {
    Account.annualInterestRate = annualInterestRate;
  }

  static void setCurrentId(int id) {
    Account.CURRENT_ID = id;
  }

  @Override
  public String toString() {
    return String.format("Account[id=%d, user=%s, balance=$%.4f]", id, username, balance);
  }
}

class SavingsAccount extends Account {
  SavingsAccount(String username, String password) {
    super(username, password);
  }

  @Override
  public String toString() {
    return String.format("SavingsAccount[id=%d, user=%s, balance=%.4g]", id, username, balance);
  }
}
class CheckingAccount extends Account {
  CheckingAccount(String username, String password) {
    super(username, password);
  }

  @Override
  public String toString() {
    return String.format("CheckingAccount[id=%d, user=%s, balance=%.4g]", id, username, balance);
  }
}


class MyDate implements Serializable {
  private int year, month, day;

  public MyDate() {
    setDate(System.currentTimeMillis());
  }

  public MyDate(long elapsedTime) {
    setDate(elapsedTime);
  }

  public MyDate(int year, int month, int day) {
    this.year = year;
    this.month = month;
    this.day = day;
  }

  public void setDate(long elapsedTime) {
    Calendar cal = new GregorianCalendar();
    cal.setTimeZone(TimeZone.getTimeZone("Asia/Yerevan"));
    cal.setTimeInMillis(elapsedTime);
    this.year = cal.get(Calendar.YEAR);
    this.month = cal.get(Calendar.MONTH);
    this.day = cal.get(Calendar.DAY_OF_MONTH);
  }

  @Override
  public String toString() {
    return year + "/" + month + "/" + day;
  }

}
