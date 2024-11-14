import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    private static final int MAX_ATTEMPTS = 10;
    private static final int RANGE = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;

        while (playAgain) {
            int numberToGuess = random.nextInt(RANGE) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Guess the number between 1 and " + RANGE);

            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    totalScore += (MAX_ATTEMPTS - attempts + 1); 
                    guessedCorrectly = true;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all attempts. The number was: " + numberToGuess);
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = sc.next().equalsIgnoreCase("yes");
        }

        System.out.println("Game Over. Your total score is: " + totalScore);
        sc.close();
    }
}
