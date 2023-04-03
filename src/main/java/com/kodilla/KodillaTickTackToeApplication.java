package com.kodilla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class KodillaTickTackToeApplication {

	public static void main(String[] args) {
		SpringApplication.run(KodillaTickTackToeApplication.class, args);

		String[] fields = {" ", " ", " ",  " ", " ", " ", " ", " ", " "};

		System.out.printf("""
						|%s|%s|%s|
						|%s|%s|%s|
						|%s|%s|%s|\n""",
				fields[0], fields[1], fields[2],
				fields[3], fields[4], fields[5],
				fields[6], fields[7], fields[8]);

		Scanner myScanner = new Scanner(System.in);

		System.out.println("What do you want to insert? ");
		String userInput = myScanner.nextLine();
		System.out.println("Where do you want to put it? ");
		int place = myScanner.nextInt();

		switch (place) {
			case 1 -> fields[0] = userInput;
			case 2 -> fields[1] = userInput;
			case 3 -> fields[2] = userInput;
			case 4 -> fields[3] = userInput;
			case 5 -> fields[4] = userInput;
			case 6 -> fields[5] = userInput;
			case 7 -> fields[6] = userInput;
			case 8 -> fields[7] = userInput;
			case 9 -> fields[8] = userInput;
			default -> System.out.println("Invalid number");
		}

	}

}

// klasa user communication
// klasa mechanika gry
// klasa pole w tablicy gry: przechowywanie stanu, współrzedne, itp
