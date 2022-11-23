import java.util.Scanner;

public class TriviaRunner {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        //Asks user how many trivia questions they want to answer
        System.out.print("How many trivia questions do you want? (1-10): ");
        int numQuestions = scan.nextInt();
        while (!(numQuestions >0 && numQuestions<=10)){
            System.out.print("That's not a number from 1-10! Enter one that is: ");
            numQuestions = scan.nextInt();
        }
        scan.nextLine(); //Clearing \n

        //Create new trivia object
        Trivia myTrivia = new Trivia(numQuestions);

        //Ask user what trivia topic they want
        System.out.print("Do you want trivia on math or English? ");
        String triviaType = scan.nextLine();
        if(triviaType.equals("Math") || triviaType.equals("math")){
            myTrivia.mathTrivia();
        }
        else if (triviaType.equals("English") || triviaType.equals("english")){
            return;
        }
        else{
            while (!(triviaType.equals("Math") || triviaType.equals("math") || triviaType.equals("English") || triviaType.equals("english"))) {
                System.out.print("Your answer isn't one of the options! Try again: ");
                triviaType = scan.nextLine();
            }
        }

        System.out.println("Thanks for playing! You finished with a score of " + myTrivia.getCount() + " out of " + numQuestions + "!");
    }
}
