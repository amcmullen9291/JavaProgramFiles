package anthony;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        Arrays.fill(letters, '_');
        System.out.println(letters);

        int lives = 5;
        Scanner scanner= new Scanner(System.in);
        while(lives > 0){
            System.out.print("Guesses remaining: ");
            for (int i =0; i < lives; i++){
                System.out.print("X");
            }

            System.out.println();

            System.out.println("Guess a letter.");
            String usersGuess = scanner.nextLine();

            String patternString = ".*[A-Za-z]{1}.*";
            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(usersGuess);
            boolean matches = matcher.matches();
            if(matches && usersGuess.length() == 1) {
                char letter = Character.toLowerCase(usersGuess.charAt(0));
            }else{
                System.out.println("That was not a letter. Please select a letter, A-Z.");
                usersGuess = scanner.nextLine();
                Matcher matcher2 = pattern.matcher(usersGuess);
                boolean matches2 = matcher2.matches();
                if(matches2 && usersGuess.length() == 1) {
                    char letter = Character.toLowerCase(usersGuess.charAt(0));
                }else{
                    System.out.println("GOODBYE!");
                    System.exit(0);
                }
            }
        }
    }
}

