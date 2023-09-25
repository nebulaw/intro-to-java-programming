package chapter12.exercise15;

import chapter11.exercise10.StackList;

import java.io.*;

public class Main {
  public static void main(String[] args) {
    try (
      DataOutputStream out = new DataOutputStream(new FileOutputStream("numbers2.txt", true));
    ) {
      for (int i = 0; i < 100; i++)
        out.writeInt((int)(Math.random() * 100));
    } catch (IOException e) {
      System.out.println("error happened while writing");
    }

    try (
      DataInputStream in = new DataInputStream(new FileInputStream("numbers2.txt"));
    ) {
      StackList numbers = new StackList();
      for (int i = 0; i < 100; i++)
        numbers.push(in.readInt());
      numbers.sort();
      System.out.println(numbers);
    } catch (IOException e) {
      System.out.println("error happened while reading");
    }


  }
}
