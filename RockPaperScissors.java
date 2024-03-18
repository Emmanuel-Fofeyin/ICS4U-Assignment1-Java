import java.util.Random;
import java.util.Scanner;

/**
 * This program creates a game of "rock-paper-scissors"
 * with a computer.
 *
 * @author Emmanuel.FN
 * @version 1.0
 * @since 2024-03-17
 */
public final class RockPaperScissors {
    // Define constants
    /**
    * Represents the string "rock".
    */
    private static final String ROCK_STRING = "rock";
    /**
    * Represents the string "paper".
    */
    private static final String PAPER_STRING = "paper";
    /**
    * Represents the string "scissors".
    */
    private static final String SCISSORS_STRING = "scissors";

    // Private constructor to prevent instantiation
    /**
    * Private constructor to prevent instantiation of this utility class.
    * Throws an IllegalStateException if called.
    *
    * @throws IllegalStateException if called, as this class should not be seen.
    */
    private RockPaperScissors() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This function simulates a game of "rock-paper-scissors".
     *
     * @param userInputString The user's input.
     * @param computerChoice  The computer's choice.
     * @param tiedOutcome     The outcome if it's a tie.
     * @param lostOutcome     The outcome if the user loses.
     * @param winOutcome      The outcome if the user wins.
     * @return The outcome of the game.
     */
    public static String rockPaperScissor(
            final String userInputString, final String computerChoice,
            final String tiedOutcome, final String lostOutcome,
            final String winOutcome
    ) {
        String output = "";

        // Process
        System.out.println("You choose: " + userInputString);
        System.out.println("The computer choose: " + computerChoice);
        if (userInputString.equals(computerChoice)) {
            output = tiedOutcome;
        } else {
            switch (computerChoice) {
                case ROCK_STRING:
                    if (userInputString.equals(SCISSORS_STRING)) {
                        output = lostOutcome;
                    } else {
                        output = winOutcome;
                    }
                    break;
                case PAPER_STRING:
                    if (userInputString.equals(ROCK_STRING)) {
                        output = lostOutcome;
                    } else {
                        output = winOutcome;
                    }
                    break;
                case SCISSORS_STRING:
                    if (userInputString.equals(PAPER_STRING)) {
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
    public static void main(final String[] args) {
        // Input
        final Scanner scanner = new Scanner(System.in);
        System.out.print("rock, paper, or scissors? (lowercase): ");
        final String userInputString = scanner.nextLine().trim();

        // Error check
        if (userInputString.equals(ROCK_STRING)
                || userInputString.equals(PAPER_STRING)
                || userInputString.equals(SCISSORS_STRING)) {
            // Computer chooses rock, paper, or scissors
            final Random random = new Random();
            final String[] computerOptions =
            {ROCK_STRING, PAPER_STRING, SCISSORS_STRING};
            final String computerChoice =
            computerOptions[random.nextInt(computerOptions.length)];

            final String output = rockPaperScissor(userInputString,
            computerChoice, "You tied.", "You lost...", "You won!");
            System.out.println(output);
        } else {
            System.out.println("Invalid input.");
        }

        scanner.close();
        System.out.println("\nDone.");
    }
}

