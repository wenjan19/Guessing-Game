import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("GUESSING GAME");
        System.out.println("-------------");
        System.out.println("CHOOSE A CATEGORY: ");
        System.out.println("1. Animals");
        System.out.println("2. Food");
        System.out.println("3. Gadgets");
        System.out.println("4. OOP Concepts");
        int choice = scan.nextInt();
        String chosenWord;

        switch (choice) {
            case 1:
                Animals animals = new Animals();
                chosenWord = animals.chooseWord();
                playGame(chosenWord);
                break;

            case 2:
                Food food = new Food();
                chosenWord = food.chooseWord();
                playGame(chosenWord);
                break;

            case 3:
                Gadgets gadgets = new Gadgets();
                chosenWord = gadgets.chooseWord();
                playGame(chosenWord);
                break;

            case 4:
                OOP oop = new OOP();
                chosenWord = oop.chooseWord();
                playGame(chosenWord);
                break;
        }
    }

    public static void playGame(String wordToGuess) {
        Scanner scanner = new Scanner(System.in);
        String guessedWord;
        File_IO.createFile("input.txt");
        File_IO.createFile("output.txt");
        File_IO.createFile("attempts.txt");

        int numGuesses = 0;

        do {
            System.out.print("Enter your guess: ");
            guessedWord = scanner.nextLine();

            if (guessedWord.equalsIgnoreCase(wordToGuess)) {
                System.out.println("Congratulations! You guessed it right: " + wordToGuess);
                File_IO.writeToFile("output.txt", "User guessed: " + guessedWord);
                break;
            } else {
                System.out.println("Oops! Wrong guess. Here's a hint:");
                giveHint(wordToGuess);
            }
            numGuesses++;
            File_IO.writeToFile("input.txt", guessedWord);

        } while (!guessedWord.equalsIgnoreCase(wordToGuess));

        try {
            File_IO.writeToFile("attempts.txt", "Word: " + wordToGuess);
            File_IO.writeToFile("attempts.txt", "Total Guesses: " + numGuesses);
        } catch (Exception e) {
            Logger logger = Logger.getLogger(GuessingGame.class.getName());
            logger.log(Level.SEVERE, "An error occurred.", e);
        }

        scanner.close();
    }



    public static void giveHint(String word) {
        if (word.equalsIgnoreCase("kangaroo")) {
            System.out.println("Hint: It's a marsupial!");
        } else if (word.equalsIgnoreCase("orca")) {
            System.out.println("Hint: It's a type of whale!");
        } else if (word.equalsIgnoreCase("orangutan")) {
            System.out.println("Hint: It's a large ape from Asia!");
        } else if (word.equalsIgnoreCase("banana")) {
            System.out.println("Hint: It's a yellow fruit!");
        } else if (word.equalsIgnoreCase("hot dog")) {
            System.out.println("Hint: It's a type of sausage in a bun!");
        } else if (word.equalsIgnoreCase("salad")) {
            System.out.println("Hint: It's a mixture of vegetables!");
        } else if (word.equalsIgnoreCase("smartwatch")) {
            System.out.println("Hint: It's a wearable device!");
        } else if (word.equalsIgnoreCase("camera")) {
            System.out.println("Hint: It captures images!");
        } else if (word.equalsIgnoreCase("phone")) {
            System.out.println("Hint: It's a communication device!");
        } else if (word.equalsIgnoreCase("abstraction")) {
            System.out.println("Hint: It hides complex details!");
        } else if (word.equalsIgnoreCase("polymorphism")) {
            System.out.println("Hint: It allows objects to be treated as instances of their parent class!");
        } else if (word.equalsIgnoreCase("constructor")) {
            System.out.println("Hint: It initializes objects!");
        }

    }
}

