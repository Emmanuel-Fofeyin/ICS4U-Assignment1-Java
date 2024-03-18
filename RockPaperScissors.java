/*
 * This program creates a game of "rock-paper-scissors"
 * with a computer.
 *
 * @author  Emmanuel.FN
 * @version 1.0
 * @since   2024-03-17
 */

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    // Define constants
    private static final String rockString = "rock";
    private static final String paperString = "paper";
    private static final String scissorsString = "scissors";

    /**
    * This function simulates a game of "rock-paper-scissors".
    *
    * @param userInputString  The user's input.
    * @param computerChoice  The computer's choice.
    * @param tiedOutcome  The outcome if it's a tie.
    * @param lostOutcome  The outcome if the user loses.
    * @param winOutcome  The outcome if the user wins.
    * @return The outcome of the game.
    */
    public static String rockPaperScissor(
        String userInputString, String computerChoice,
        String tiedOutcome, String lostOutcome, String winOutcome
    ) {
        String output = "";

        // Process
        System.out.println("You choose: " + userInputString);
        System.out.println("The computer choose: " + computerChoice);
        if (userInputString.equals(computerChoice)) {
            output = tiedOutcome;
        } else {
            switch (computerChoice) {
                case rockString:
                    if (userInputString.equals(scissorsString)) {
                        output = lostOutcome;
                    } else {
                        output = winOutcome;
                    }
                    break;
                case paperString:
                    if (userInputString.equals(rockString)) {
                        output = lostOutcome;
                    } else {
                        output = winOutcome;
                    }
                    break;
                case scissorsString:
                    if (userInputString.equals(paperString)) {
                        output = lostOutcome;
                    } else {
                        output = winOutcome;
                    }
                    break;
                default:
                    break;
            }
        }
        return output;
    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(String[] args) {
        // Input
        Scanner scanner = new Scanner(System.in);
        System.out.print("rock, paper, or scissors? (lowercase): ");
        String userInputString = scanner.nextLine().trim();

        // Error check
        if (userInputString.equals(rockString)
            || userInputString.equals(paperString)
            || userInputString.equals(scissorsString)) {
            // Computer chooses rock, paper, or scissors
            Random random = new Random();
            final String[] computerOptions = {rockString, paperString, scissorsString};
            String computerChoice = computerOptions[random.nextInt(computerOptions.length)];

            String output = rockPaperScissor(userInputString, computerChoice, "You tied.", "You lost...", "You won!");
            System.out.println(output);
        } else {
            System.out.println("Invalid input.");
        }

        scanner.close();
        System.out.println("\nDone.");
    }
}

