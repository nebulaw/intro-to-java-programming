package chapter10.exercise14;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class MyDate {
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