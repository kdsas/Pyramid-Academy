import java.util.LinkedList;
import java.util.Scanner;

public class Hangman {

 public static boolean checkGuess(String letter, String word){
     if(word.indexOf(letter)!=-1){
         return true;

     }else{


         return false;
     }

 }
    public static String hideWord(String word){

        String hiddenWord = "";
        for(int i =0; i<word.length(); i++){

            hiddenWord+="_";

        }
        return hiddenWord;
    }
     static int guesses=0;

 private static void gameLost() {
        if(guesses>=7){
            System.out.println("You lost!");
        }

    }

    public static String updateWord(String word, String letter, LinkedList<String>revealedLetters){

        String hiddenWord= "";

        for(int i=0; i<word.length();i++){
            if(String.valueOf(word.charAt(i)).equals(letter)|| revealedLetters.contains(String.valueOf(word.charAt(i)))){

               hiddenWord+=word.charAt(i);


            }else{

                guesses+=1;
                hiddenWord+="_";
                gameLost();

            }



        }
    return hiddenWord;
}
    private static void printHangman(int numWrong) {
        System.out.println("  ____");
        System.out.println("  |  |");
        if (numWrong > 0) {
            System.out.println("  |  O");
            if (numWrong == 2) {
                System.out.println("  |  |");
            } else if (numWrong == 3) {
                System.out.println("  | \\|");
            } else if (numWrong >= 4) {
                System.out.println("  | \\|/");
            }
            if (numWrong == 5) {
                System.out.println("  | /");
            } else if (numWrong == 6) {
                System.out.println("  | / \\");
            }

        }
        for (int k = 6 - numWrong; k > 0; k--) {
            System.out.println("  |");
        }
        System.out.println("__|__");
        System.out.println();

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        LinkedList<String> words = new LinkedList<String>();
        LinkedList<String> correctLetters = new LinkedList<String>();
        words.add("shoe");
        words.add("hat");
        words.add("shirt");
        words.add("pants");
        String word = "", playerGuess = "";
        boolean gameOver = false;

        System.out.println("Welcome to Hangman");

        int x = (int) (Math.random() * words.size() - 1);
        word = words.get(x);

        String hiddenWord = hideWord(word);



        try {
            while (!gameOver) {
                System.out.println(hiddenWord);
                System.out.println("Guess a letter\n");
                playerGuess = input.next();

                if (checkGuess(playerGuess, word)) {

                    correctLetters.add(playerGuess);
                    hiddenWord = updateWord(word, playerGuess, correctLetters);

                } else {
                    System.out.println("Incorrect, try again");
                    printHangman(guesses);


                }



                if (word.equals(hiddenWord)) {
                    gameOver = true;
                    gameWon();

                }

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



    private static void gameWon() {

        System.out.println("You won!");

    }


}
