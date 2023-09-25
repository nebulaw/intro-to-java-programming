package chapter12.exercise06_10;

class Bin2Dec {
  public static int binaryToDecimal(String binaryString) {
    int decimalValue = 0;
    for (int i = 0; i < binaryString.length(); i++) {
      char binChar = binaryString.charAt(i);
      if (binChar != '1' && binChar != '0')
        throw new NumberFormatException(String.format("invalid character '%c'", binChar));
      decimalValue += binChar == '1' ? (int)Math.pow(2, binaryString.length() - 1 - i) : 0;
    }
    return decimalValue;
  }
}

