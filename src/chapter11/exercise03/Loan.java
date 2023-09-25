package chapter11.exercise03;

public class Loan {

  private double annualInterestRate;

  private int numberOfYears;

  private double loanAmount;

  private java.util.Date loanDate;

  public Loan() {
    this(2.5, 1, 1000);
  }

  public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
    if (annualInterestRate <= 0 || numberOfYears <= 0 || loanAmount <= 0)
      throw new IllegalArgumentException("You must provide positive values");
    this.annualInterestRate = annualInterestRate;
    this.numberOfYears = numberOfYears;
    this.loanAmount = loanAmount;
    loanDate = new java.util.Date();
  }

  public double getAnnualInterestRate() {
    return annualInterestRate;
  }

  public void setAnnualInterestRate(double annualInterestRate) {
    this.annualInterestRate = annualInterestRate;
  }


  public int getNumberOfYears() {
    return numberOfYears;
  }

  public void setNumberOfYears(int numberOfYears) {
    this.numberOfYears = numberOfYears;
  }


  public double getLoanAmount() {
    return loanAmount;
  }

  public void setLoanAmount(double loanAmount) {
    this.loanAmount = loanAmount;
  }
}

