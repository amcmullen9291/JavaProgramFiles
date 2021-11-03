package anthony;

import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        int secretNumber;
        int userGuess;
        boolean bingo = false;

        int random = (int) (Math.random() * 20 + 1);

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to \"Guess the Number\"! ");
        System.out.println("Choose a number; any number:");
        try {
            secretNumber = keyboard.nextInt();
        }catch(Exception e){
            System.out.println("please enter a valid response.");
        }
        System.out.println("good choice!");
        System.out.println("");
        System.out.println("NOW ITS MY TURN. Guess a number between 1 and 20.");
        System.out.println("***FYI, my number for this round is " + random + ". (Ain't I a stinker?)");

        String[] foods = {"bananas", "corndogs", "pillowcases", "four leaf clovers", "tacos and burritos", "hula hoops", "bottles of mouth wash", "sticks of chewing gum", "corn cob pipes"};
        int randomFood = (int) (Math.random() * 6 + 1);
        String endFood = foods[randomFood];
        try {
            while (!bingo) {
                System.out.print("Guess My Number.:");
                userGuess = keyboard.nextInt();
                if (userGuess == random) {
                    bingo = true;
                    System.out.println("Bingo! I will give you " + secretNumber + " " + endFood + ". Let's play again?");
                } else if (userGuess < random) {
                    System.out.println("Higher.");
                } else if (userGuess > random) {
                    System.out.println("Lower.");
                }
            }
        }catch(Exception e){
            System.out.println("An error occurred.");
        }
    }
}