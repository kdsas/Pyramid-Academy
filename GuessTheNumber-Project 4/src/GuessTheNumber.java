import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {


        boolean exit = false;
        try{
            while (!exit) {
                String name = "Hello! What is your name?";
                System.out.println(name);

                Scanner retName = new Scanner(System.in);
                String player_name = retName.nextLine();
                String sentence = "Well, " + player_name + " I am thinking of a number between 1 and 20. \n Take a guess.";
                System.out.println(sentence);
                Scanner numGuess = new Scanner(System.in);
                int guess = Integer.parseInt(numGuess.nextLine());

                Random rand = new Random();
                int number = rand.nextInt(20) + 1;
                System.out.println(number);


                int count = 1;

                while (count <= 6) {
                    if (guess == number) {
                        System.out.println(" Good job, " + player_name + "! You guessed my number in " + count + " guesses!");
                        break;
                    } else if (guess < number) {
                        System.out.println("Your guess is too low. Try Again");
                        count++;
                        Scanner numGuess1 = new Scanner(System.in);
                        guess = Integer.parseInt(numGuess1.nextLine());
                    } else if (guess > number) {
                        System.out.println("Your guess is too high. Try Again");
                        count++;
                        Scanner numGuess1 = new Scanner(System.in);
                        guess = Integer.parseInt(numGuess1.nextLine());
                    }

                }
                System.out.println("Would you like to play again?(y or n)");
                Scanner Reset = new Scanner(System.in);
                String reset = Reset.nextLine();

                if (reset.equals("y")) {
                    exit = false;
                } else {
                    System.exit(0);
                    System.out.println("See you next time");
                }
            }
        }catch (Exception e) {
            System.out.println("Something went wrong.");
        }
    }
}


