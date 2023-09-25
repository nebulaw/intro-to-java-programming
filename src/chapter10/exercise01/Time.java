package chapter10.exercise01;

public class Time {
  private long hour, minute, second;

  private static int offset = 0;

  public Time() {
    setTime(System.currentTimeMillis());
  }

  public Time(long elapsedTimeMS) {
    setTime(elapsedTimeMS);
  }

  public Time(long hour, long minute, long second) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  public void setTime(long elapsedTime) {
    elapsedTime /= 1000; // obtain seconds
    second = elapsedTime % 60;
    elapsedTime /= 60;
    minute = elapsedTime % 60;
    elapsedTime /= 60;
    hour = (elapsedTime + offset) % 24;
  }

  public static void setOffset(int offset) {
    if (offset > 12 || offset < -12)
      throw new RuntimeException("Offset must be between -12 and 12.");
    Time.offset = offset;
  }

  @Override
  public String toString() {
    return String.format("Hour[%s%d:%s%d:%s%d]",
      hour < 10 ? "0" : "", hour,
      minute < 10 ? "0" : "", minute,
      second < 10 ? "0" : "", second);
  }
}
