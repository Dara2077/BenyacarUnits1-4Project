import java.util.Scanner;

public class QuizRunner {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        //Asks user how many quiz questions they want to answer
        System.out.print("How many questions do you want? (1-10): ");
        int numQuestions = scan.nextInt();
        while (!(numQuestions >0 && numQuestions<=10)){
            System.out.print("That's not a number from 1-10! Enter one that is: ");
            numQuestions = scan.nextInt();
        }
        scan.nextLine(); //Clearing \n

        //Create new quiz object
        QuizGame myQuiz = new QuizGame(numQuestions);

        //Ask user what trivia topic they want
        System.out.print("Do you want trivia on Math or English? ");
        String quizType = scan.nextLine();
        if(quizType.equals("Math") || quizType.equals("math")){
            myQuiz.mathQuiz();
        }
        else if (quizType.equals("English") || quizType.equals("english")){
            System.out.print("What theme do you want your quiz words to have? Choose between Java, sports, states, or colors! ");
            String englishType = scan.nextLine();
            while (!(englishType.equals("Java") || englishType.equals("java") || englishType.equals("Sports") || englishType.equals("sports") || englishType.equals("States") || englishType.equals("states") || englishType.equals("Colors") || englishType.equals("colors"))){
                System.out.print("Your answer isn't one of the options! Try again: ");
                englishType = scan.nextLine();
            }
            englishType = englishType.toLowerCase();
            if (englishType.equals("Java") || englishType.equals("java"))
            myQuiz.englishQuiz({"Method", "Class", "Boolean", "Conditional", "Iteration", "Loop", "IDE", "Semicolon", "Parameter", "Constructor"});
            //This has a lot of errors rn...
        }
        else{
            while (!(quizType.equals("Math") || quizType.equals("math") || quizType.equals("English") || quizType.equals("english"))) {
                System.out.print("Your answer isn't one of the options! Try again: ");
                quizType = scan.nextLine();
            }
        }

        System.out.println("Thanks for playing! You finished with a score of " + myQuiz.getCount() + " out of " + numQuestions + "!");
    }
}
