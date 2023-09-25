package chapter13.exercise04;

/**
 * (Display calendars) Rewrite the PrintCalendar class in Listing 6.12 to display
 * a calendar for a specified month using the Calendar and GregorianCalendar
 * classes. Your program receives the month and year from the command line
 * */

public class Exercise04 {

  public static void main(String[] args) {
    if (args.length < 1 || args.length > 2) {
      System.out.println("Usage: java month year");
      System.exit(1);
    }

    int month = 1, year = 1970;

    try {
      month = Integer.parseInt(args[0]);
      year = args.length == 2 ?
          Integer.parseInt(args[1]) : 2023;
    } catch (NumberFormatException e) {
      System.out.println("error: invalid value");
      System.exit(-1);
    }

    if (month < 0 || month > 12) {
      System.out.println("error: invalid month or year");
      System.exit(-1);
    }

    printMonth(month, year);
  }

  public static void printMonth(int month, int year) {
    printMonthTitle(month, year);
    printMonthBody(month, year);
  }

  public static void printMonthTitle(int month, int year) {
    System.out.println("        " + getMonthName(month) + " " + year);
    System.out.println("-----------------------------");
    System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
  }

  public static void printMonthBody(int month, int year) {
    int startDay = getStartDay(month, year);
    int numberOfDaysInMonth = getNumberOfDaysInMonth(month, year);

    int i = 0;
    for (i = 0; i < startDay; i++)
      System.out.print("    ");
    for (i = 1; i <= numberOfDaysInMonth; i++) {
      System.out.printf("%4d", i);
      if ((i + startDay) % 7 == 0)
        System.out.println();
    }
    System.out.println();
  }

  public static int getStartDay(int month, int year) {
    final int START_FOR_JAN_1_1800 = 3;
    int totalNumberOfDays = getTotalNumberOfDays(month, year);
    return (totalNumberOfDays + START_FOR_JAN_1_1800) % 7;
  }

  private static int getTotalNumberOfDays(int month, int year) {
    int total = 0;

    for (int i = 1800; i < year; i++)
      total += (isLeapYear(i) ? 366 : 365);

    for (int i = 1; i < month; i++)
      total = total + getNumberOfDaysInMonth(i, year);
    return total;
  }

  public static int getNumberOfDaysInMonth(int month, int year) {
    if (month == 1 || month == 3 || month == 5 || month == 7 ||
        month == 8 || month == 10 || month == 12)
      return 31;
    if (month == 4 || month == 6 || month == 9 || month == 11)
      return 30;
    if (month == 2) return isLeapYear(year) ? 29 : 28;
    return 0;
  }

  public static boolean isLeapYear(int year) {
    return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
  }

  public static String getMonthName(int month) {
    return switch (month) {
      case 1  -> "January";
      case 2  -> "February";
      case 3  -> "March";
      case 4  -> "April";
      case 5  -> "May";
      case 6  -> "June";
      case 7  -> "July";
      case 8  -> "August";
      case 9  -> "September";
      case 10 -> "October";
      case 11 -> "November";
      case 12 -> "December";
      default -> "Invalid";
    };
  }

}
