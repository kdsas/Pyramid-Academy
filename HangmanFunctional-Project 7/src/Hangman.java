
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    static BufferedReader reader;
    static int score=0;
    static int highScore = 0;



    private static void printHangman(int numWrong) {
        System.out.println("  ____");
        System.out.println("  |  |");
        if (numWrong > 0) {
            printArt();
            if (numWrong == 2) {
                printArt1();
            } else if (numWrong == 3) {
                printArt2();
            } else if (numWrong >= 4) {
                printArt3();
            }
            if (numWrong == 5) {
                printArt4();
            } else if (numWrong == 6) {
                printArt5();
            }

        }
        for (int k = 6 - numWrong; k > 0; k--) {
            printArt6();
        }
        System.out.println("__|__");
        System.out.println();
    }

    public static void printArt(){
        try {score-=10;
            if(score<0){
                score=0;
                System.out.println("Score:"+ score);
            }
            reader = new BufferedReader(new FileReader(
                    "src/art"));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printArt1(){
        try {score-=10;
            if(score<0){
                score=0;
                System.out.println("Score:"+ score);
            }
            reader = new BufferedReader(new FileReader(
                    "src/art1"));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void printArt2(){
        try {score-=10;
            if(score<0){
                score=0;
                System.out.println("Score:"+ score);
            }
            reader = new BufferedReader(new FileReader(
                    "src/art2"));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void printArt3(){
        try {score-=10;
            if(score<0){
                score=0;
                System.out.println("Score:"+ score);
            }
            reader = new BufferedReader(new FileReader(
                    "src/art3"));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void printArt4(){
        try {score-=10;
            if(score<0){
                score=0;
                System.out.println("Score:"+ score);
            }
            reader = new BufferedReader(new FileReader(
                    "src/art4"));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printArt5(){
        try {score-=10;
            if(score<0){
                score=0;
                System.out.println("Score:"+ score);
            }
            reader = new BufferedReader(new FileReader(
                    "src/art5"));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printArt6(){
        try {score-=10;
            if(score<0){
                score=0;
                System.out.println("Score:"+ score);
            }
            reader = new BufferedReader(new FileReader(
                    "src/art6"));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean printWordState(String word,List<Character> playerGuesses){
        int correctCount=0;
        for(int i=0; i<word.length(); i++){

            if(playerGuesses.contains(word.charAt(i))){

                System.out.print(word.charAt(i));
                correctCount++;
                score+=10;

            }else{

                System.out.print("-");
            }

        }
        System.out.println();
        System.out.println("Score:"+ score);

        return (word.length()==correctCount);
    }

private static void getPlayerGuess(Scanner keyboard,String word,List<Character>playerGuesses){
    System.out.println("Please Enter a Letter");
    String letterGuess=keyboard.nextLine();
    playerGuesses.add(letterGuess.charAt(0));


}

    public static void main(String[] args) throws FileNotFoundException {


        boolean gameOver = false;


        System.out.println("Welcome to Hangman");

        File dictionary = new File("src/dictionary");
        Scanner wordScanner = new Scanner(dictionary);
        List<String> words= new ArrayList<>();
        while (wordScanner.hasNext()){
            words.add(wordScanner.nextLine());
        }
        Scanner keyboard= new Scanner(System.in);  // Create a Scanner object



        Scanner myName = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter your name");

        String userName = myName.nextLine();  // Read user input
        System.out.println("Hello: " + userName);  // Output user input
        Random rand =new Random();
        String word=words.get(rand.nextInt(words.size()));
        //System.out.println(word);
        List<Character> playerGuesses=new ArrayList<>();
        int wrongCount=0;


        try {
            while (!gameOver) {


                       printWordState(word,playerGuesses);
                       getPlayerGuess(keyboard, word, playerGuesses);
                System.out.println("Please enter your guess for the word:");
                if (keyboard.nextLine().equals(word)) {
                    System.out.println(userName + " You Win!");

                    break;
                } else {

                    System.out.println("Nope! Try again");
                    wrongCount+=1;
                    printHangman(wrongCount);
                    if(wrongCount>=7){
                        System.out.println(userName + " You Lost!");
                        System.out.println(userName + ":"+"Score:"+ score);
                        System.out.println("The word was: "+ word);

                        gameOver = true;
                        break;
                    }
                }
                       if (printWordState(word, playerGuesses)) {
                           System.out.println(userName + " You Win!");

                           System.out.println(userName + ":"+"Score:"+ score);

                           if(score > highScore){
                               highScore = score;
                               System.out.println(userName + ":"+"High Score:"+ highScore);
                               BufferedWriter bw = null;
                               try {
                                   bw = new BufferedWriter(new FileWriter( "highscore.dat", false)); //append - set to false
                                   bw.write(userName +" : " +" High Score "+ highScore );
                                   bw.flush();
                                   bw.close();
                               } catch (IOException e) {
                                   System.out.println(  "Error while saving high score");
                               }
                               gameOver = true;
                               break;
                           }





                   }



            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }





    }







}