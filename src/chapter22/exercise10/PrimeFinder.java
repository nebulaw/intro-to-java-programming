package chapter22.exercise10;

import java.io.*;
import java.util.Scanner;

public class PrimeFinder {
  private static final String targetFilePath = "data/chapter22/PrimeNumbers.dat";
  private static long LIMIT = 10_000_000_000L;
  private static long[] buf = new long[10_000];
  private static RandomAccessFile raf;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("Enter limit: ");
    LIMIT = in.nextLong();
    in.close();

    openFile(targetFilePath);
    generatePrimeNumbers();
    closeFile();

    check();
  }

  public static void openFile(String filePath) {
    File file = new File(filePath);
    // handle file creation
    if (file.exists()) {
      try (PrintWriter out = new PrintWriter(file);) {
        out.print("");
      } catch (FileNotFoundException e) {
        System.out.println("error");
      }
    } else {
      try {
        if (!file.createNewFile()) {
          System.out.println("cannot create " + file.getName());
          System.exit(-1);
        }
      } catch (IOException e) {
        System.out.println("error while creating " + file.getName());
        System.exit(-1);
      }
    }

    // random access file will be the best solution for the problem
    try {
      raf = new RandomAccessFile(file, "rws");
    } catch (FileNotFoundException e) {
      System.out.println(file.getName() + " not found");
    }
  }

  public static void closeFile() {
    try {
      raf.close();
    } catch (IOException e) {
      System.out.println("error while closing");
    }
  }

  public static void initialize() {
    // initialize first values, and we are ready to
    // generate other prime numbers
    try {
      raf.writeLong(2L);
      raf.writeLong(3L);
    } catch (IOException e) {
      System.out.println("error while initializing");
      System.exit(-1);
    }
  }

  public static void append(long prime) {
    try {
      raf.seek(raf.length());
      raf.writeLong(prime);
    } catch (IOException e) {
      System.out.println("error while appending file");
      System.exit(-1);
    }
  }

  public static void read() {
    try {
      raf.seek(0);
      for (int i = 0; i < buf.length && (raf.getFilePointer() < raf.length()); i++)
        buf[i] = raf.readLong();
    } catch (EOFException ignored) {
    } catch (IOException e) {
      System.out.println("error while reading primes");
      System.exit(-1);
    }
  }

  private static boolean isPrime(long number) {
    for (long div : buf) {
      if (div == 0)
        return true;
      if (number % div == 0)
        return false;
    }
    return true;
  }

  public static void generatePrimeNumbers() {
    long number = 4;
    while (number < LIMIT) {
      read();
      if (isPrime(number))
        append(number);
      number++;
    }
  }

  public static void check() {
    try (DataInputStream in = new DataInputStream(new FileInputStream(targetFilePath))) {
      int i = 1;
      while (i <= LIMIT) {
        System.out.printf("%-13d", in.readLong());
        if (i++ % 10 == 0)
          System.out.println();
      }
    } catch (EOFException ignored) {
    } catch (IOException e) {
      System.out.println("error while checking");
    }
  }
}

