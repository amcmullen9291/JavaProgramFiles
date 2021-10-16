package anthony;

import java.util.ArrayList;
import java.util.Scanner;
// Note: the while loop is currently in an infinite loop. DO NOT RUN YET
public class HangmanGame {
    public static void main(String[] args) {
        String[] words = {"puppy", "vacation", "football", "oxymoron", "hyperbole", "Champagne",
                "Germany", "JavaScript", "Java", "modifier", "sandwich", "cartoon",
                "campus", "compass", "water", "salamander", "grape", "orange", "Auburn", "Kalamazoo"};
        int random  = (int) (Math.random() * words.length);
        String secretWord = words[random];
        char[] letters = new char[secretWord.length()];

        System.out.println("JAVA - HANGMAN (written by Anthony)");
        System.out.println(".");
        int lives = 5;
        Scanner scanner= new Scanner(System.in);
        while(lives > 0){
            System.out.print("Guesses remaining: ");
            for (int i =0; i > lives; i++){
                System.out.print("X");
            }

            System.out.println();

            System.out.println("Guess a letter.");
            if(scanner.hasNextLine()) {
                String usersGuess = scanner.nextLine();
                char letter = usersGuess.charAt(0);
            }else{
                System.out.println("That was not a letter. Please select a letter, A-Z.");
                if(scanner.hasNextLine()) {
                    String usersGuess = scanner.nextLine();
                    char letter = usersGuess.charAt(0);
                }else{
                    System.out.println("GOODBYE!");
                    System.exit(0);
                }
            }
        }
    }
}

