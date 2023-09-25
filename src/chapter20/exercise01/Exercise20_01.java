package chapter20.exercise01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise20_01 {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java source");
			System.exit(-1);
		}

		File file = new File(args[0]);
		if (!file.exists()) {
			System.out.println(args[0] + " was not found.");
			System.exit(-1);
		}
		if (file.isDirectory()) {
			System.out.println(args[0] + " is directory.");
			System.exit(-1);
		}

		ArrayList<String> words = new ArrayList<>();

		try (Scanner in = new Scanner(new FileInputStream(file))) {
			while (in.hasNext()) {
				String word = in.next();
				if (Character.isDigit(word.charAt(0))) {
					System.out.println("Skipping " + word);
					continue;
				}
				words.add(word);
			}
		} catch (IOException e) {
			System.out.println("error: cannot read file");
		}

		System.out.println(words.stream()
				.sorted((s1, s2) -> s1.compareToIgnoreCase(s2))
				.reduce("sorted:", (rest, word) -> rest + " " + word));

	}	
}

