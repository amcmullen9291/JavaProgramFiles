package anthony;

import java.util.Random;
import java.util.Scanner;

public class DragonCave {
    public static void main(String[] args) {
        System.out.println("You are in a land full of dragons.");
        System.out.println("In front of you,");
        System.out.println("you see two caves. In one cave the dragon is friendly");
        System.out.println("and will share his treasure with you.");
        System.out.println("The other dragon");
        System.out.println("is greedy and hungry and will");
        System.out.println("EAT YOU ON SIGHT.");
        System.out.println("Which cave will you go into? (1 or 2)");
        int computerChoice = 0;

        Scanner choice = new Scanner(System.in);
        int userChoice = choice.nextInt();
        try {

            if (Math.random() < 0.5) {
                computerChoice = 2;
            } else {
                computerChoice = 1;
            }

            if (userChoice == computerChoice) {
                System.out.println("You are safe. Be well.");
            } else {
                System.out.println("You will be missed.");
            }
        }catch(Exception e){
            System.out.println("undetermined outcome. Try again.");
        }

        System.out.println("computer's choice:" + computerChoice);
    }
}

