package chapter10.exercise08;

public class Tax {

  private static final int SINGLE_FILER = 0;
  private static final int MARRIED_JOINTLY_WIDOW = 1;
  private static final int MARRIED_SEP = 2;
  private static final int HEAD_OF_HOUSEHOLD = 3;


  private int fStatus;
  int[][] brackets;
  double[] rates;
  double taxableIncome;

  public Tax(int filingStatus, int[][] brackets, double[] rates, double taxableIncome) {
    this.fStatus = filingStatus;
    this.brackets = brackets;
    this.rates = rates;
    this.taxableIncome = taxableIncome;
  }

  public double getTax() {
    if (taxableIncome <= brackets[fStatus][0])
      return taxableIncome * rates[0];
    else if (taxableIncome <= brackets[fStatus][1])
      return brackets[fStatus][0] * rates[0] +
        (taxableIncome - brackets[fStatus][0]) * rates[1];
    else if (taxableIncome <= brackets[fStatus][2])
      return brackets[fStatus][0] * rates[0] +
        (brackets[fStatus][1] - brackets[fStatus][0]) * rates[1] +
        (taxableIncome - brackets[fStatus][1]) * rates[2];
    else if (taxableIncome <= brackets[fStatus][3])
      return brackets[fStatus][0] * rates[0] +
        (brackets[fStatus][1] - brackets[fStatus][0]) * rates[1] +
        (brackets[fStatus][2] - brackets[fStatus][1]) * rates[2] +
        (taxableIncome - brackets[fStatus][2]) * rates[3];
    else
      return brackets[fStatus][0] * rates[0] +
        (brackets[fStatus][1] - brackets[fStatus][0]) * rates[1] +
        (brackets[fStatus][2] - brackets[fStatus][1]) * rates[2] +
        (brackets[fStatus][3] - brackets[fStatus][2]) * rates[3] +
        (taxableIncome - brackets[fStatus][3]) * rates[4];
  }

  public static void main(String[] args) {
    int brackets[][] = {
      { 27050, 65550,  136750, 297350 }, // single filer
      { 45200, 109250, 166500, 297350 }, // married 1
      { 22600, 54625,  83250,  148675 }, // married sep
      { 36250, 93650,  151650, 297350 }  // hoh
    };
    double[] rates = { 0.15, 0.275, 0.305, 0.355, 0.391 };

    Tax singleFilerTax = new Tax(SINGLE_FILER, brackets, rates, 341444);
    System.out.println("single tax: " + singleFilerTax.getTax());

    Tax widowTax = new Tax(MARRIED_JOINTLY_WIDOW, brackets, rates, 38240);
    System.out.println("widow tax: " + widowTax.getTax());

  }

}
