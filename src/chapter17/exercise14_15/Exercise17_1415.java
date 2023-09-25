package chapter17.exercise14_15;

import java.io.*;

public class Exercise17_1415 {
  public static void encryptFile(File source, File target) {
    try (
      BufferedInputStream in =
        new BufferedInputStream(new FileInputStream(source));
      BufferedOutputStream out =
        new BufferedOutputStream(new FileOutputStream(target));
    ) {
      int byteRead, bytesWritten = 0;
      while ((byteRead = in.read()) != -1) {
        out.write((byte)byteRead + 5);
        bytesWritten++;
      }
      System.out.println(bytesWritten + " bytes encrypted.");
    } catch (IOException e) {
      System.out.println("error while encrypting");
    }
  }

  public static void decryptFile(File source, File target) {
    try (
      BufferedInputStream in =
        new BufferedInputStream(new FileInputStream(source));
      BufferedOutputStream out =
        new BufferedOutputStream(new FileOutputStream(target));
    ) {
      int byteRead, bytesWritten = 0;
      while ((byteRead = in.read()) != -1) {
        out.write((byte)byteRead - 5);
        bytesWritten++;
      }
      System.out.println(bytesWritten + " bytes decrypted.");
    } catch (IOException e) {
      System.out.println("error while encrypting");
    }
  }

  public static void writeFile(File file) {
    try (
      DataOutputStream out = new DataOutputStream(new FileOutputStream(file))
    ) {
      int i = 1;
      while (i-->0)
        out.writeUTF("Weird wind goes wrong way");
      System.out.println("file written");
    } catch (IOException e) {
      System.out.println("error while writing");
    }
  }

  public static void viewFile(File file) {
    try (
      DataInputStream in = new DataInputStream(new FileInputStream(file))
    ) {
      int byteRead;
      while ((byteRead = in.read()) != -1)
        System.out.print((char)byteRead);
      System.out.println("\nfile read");
    } catch (IOException e) {
      System.out.println("error while reading");
    }
  }

  public static void main(String[] args) {
    final String filedir = "data/chapter17/";
    File sourceFile = new File(filedir + "encrypt.dat");
    File targetFile = new File(filedir + "decrypt.dat");

    writeFile(sourceFile);
    encryptFile(sourceFile, targetFile);
    System.out.println("Encrypted File:");
    viewFile(targetFile);
    decryptFile(targetFile, sourceFile);
    System.out.println("Decrypted File:");
    viewFile(sourceFile);

  }
}
