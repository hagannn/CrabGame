import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    static int rollDice() {
        Random random = new Random();
        return random.nextInt(7) + 1;
    }

    static boolean playAgain() throws IOException {
        InputStreamReader sr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(sr);

        System.out.print("Would you like to play again? (y/n): ");
        String userInput = br.readLine();
        userInput = userInput.toLowerCase();

        if (userInput.equals("y")) {
            return true;
        } else if (userInput.equals("n")) {
            return false;
        } else {
            return playAgain();
        }

    }

    public static void main(String[] args) throws IOException {
        int dice1;
        int dice2;
        int point;
        int sum;
        boolean playing = true;

        while (playing) {
            dice1 = rollDice();
            dice2 = rollDice();
            sum = dice1 + dice2;

            System.out.println("Dice 1: " + dice1);
            System.out.println("Dice 2: " + dice2);
            System.out.println("Sum: " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("You crapped out, you lose");
            } else if (sum == 7 || sum == 11) {
                System.out.println("It's natural");
            } else {
                point = sum;
                System.out.println("\nTrying for point\n");
                while (sum != 7) {
                    dice1 = rollDice();
                    dice2 = rollDice();
                    sum = dice1 + dice2;

                    System.out.println("Dice 1: " + dice1);
                    System.out.println("Dice 2: " + dice2);
                    System.out.println("Sum: " + sum);

                    if (sum == point) {
                        System.out.println("Made point and won\n");
                        break;
                    } else if (sum == 7) {
                        System.out.println("Did not make point and rolled 7, you lose\n");
                    } else {
                        System.out.println("Missed point, try again\n");
                    }
                }
            }


            playing = playAgain();
        }
    }
}