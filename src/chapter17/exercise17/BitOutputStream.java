package chapter17.exercise17;

import java.io.*;

public class BitOutputStream implements AutoCloseable {
    BufferedOutputStream out;
    byte byteValue;
    int filledBits;

    BitOutputStream(File file) throws FileNotFoundException {
        out = new BufferedOutputStream(new FileOutputStream(file));
        byteValue = 0;
        filledBits = 0;
    }

    void writeBit(char bit) throws IOException {
        byteValue <<= 1;
        filledBits++;
        byteValue += (bit - 48);
        if (filledBits == 8) {
            out.write(byteValue);
            byteValue = 0;
            filledBits = 0;
        }
    }

    void writeBit(String bit) throws IOException {
        for (char b : bit.toCharArray())
            writeBit(b);
    }

    public void close() throws IOException {
        out.close();
    }
}
