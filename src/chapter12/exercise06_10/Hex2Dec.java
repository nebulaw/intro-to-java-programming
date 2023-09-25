package chapter12.exercise06_10;

public class Hex2Dec {
  public static int hexToDecimal(String hex) {
    int decimalValue = 0;
    for (int i = 0; i < hex.length(); i++) {
      char hexChar = hex.charAt(i);
      if (!isHexChar(hexChar))
        throw new HexFormatException("Illegal character '" + hexChar + "'");
      decimalValue = decimalValue * 16 + hexToCharDecimal(hexChar);
    }
    return decimalValue;
  }

  private static boolean isHexChar(char ch) {
    return ch >= 'A' && ch <= 'F';
  }

  public static int hexToCharDecimal(char ch) {
   return (ch >= 'A' && ch <= 'F') ? (10 + ch - 'A') : ch - '0';
  }
}

