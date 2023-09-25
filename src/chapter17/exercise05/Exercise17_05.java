package chapter17.exercise05;

import java.io.*;
import java.util.Date;

public class Exercise17_05 {
  public static void main(String[] args) {

    final String filepath = "data/chapter17/Exercise17_05.dat";

    // write
    try (
      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filepath));
    ) {
      out.writeInt(1);
      out.writeInt(2);
      out.writeInt(3);
      out.writeInt(4);
      out.writeInt(5);
      out.writeObject(new Date());
      out.writeDouble(5.5);
    } catch (IOException ignored) {}


    // read to assure
    try (
      ObjectInputStream in = new ObjectInputStream(new FileInputStream(filepath));
    ) {
      System.out.println(in.readInt());
      System.out.println(in.readInt());
      System.out.println(in.readInt());
      System.out.println(in.readInt());
      System.out.println(in.readInt());
      System.out.println(in.readObject());
      System.out.println(in.readDouble());
    } catch (IOException | ClassNotFoundException ignored) {}

  }
}
