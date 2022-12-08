import java.util.Scanner;

public class QuizGameRunner {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        //Asks user how many quiz questions they want to answer
        System.out.print("How many questions do you want? (1-10). Or, if you want the computer to choose for you, enter 0: ");
        int numQuestions = scan.nextInt();
        QuizGame myQuiz;
        if (numQuestions == 0){
            myQuiz = new QuizGame();
            System.out.println(myQuiz.toString());
        }
        else{
            while (!(numQuestions >0 && numQuestions<=10)){
                System.out.print("That's not a number from 1-10! Enter one that is: ");
                numQuestions = scan.nextInt();
            }
            //Create new quiz object
            myQuiz = new QuizGame(numQuestions);
        }
        scan.nextLine(); //Clearing \n

        //Ask user what quiz topic they want
        System.out.print("Do you want a quiz on Math or English? ");
        String quizType = scan.nextLine();
        while (!(quizType.equals("Math") || quizType.equals("math") || quizType.equals("English") || quizType.equals("english"))) {
            System.out.print("Your answer isn't one of the options! Try again: ");
            quizType = scan.nextLine();
        }
        if(quizType.equals("Math") || quizType.equals("math")){
            myQuiz.mathQuiz();
        }
        else if (quizType.equals("English") || quizType.equals("english")){
            System.out.print("What theme do you want your quiz words to have? Choose between Java, sports, states, or colors! ");
            String englishType = scan.nextLine();
            englishType = englishType.toLowerCase();
            while (!(englishType.equals("java") || englishType.equals("sports") || englishType.equals("states") || englishType.equals("colors"))){
                System.out.print("Your answer isn't one of the options! Try again: ");
                englishType = scan.nextLine();
            }
            if (englishType.equals("java")){
                String[] myArray = {"Method", "Class", "Boolean", "Conditional", "Iteration", "Loop", "IDE", "Semicolon", "Parameter", "Constructor"};
                myQuiz.englishQuiz(myArray);
            }
            else if(englishType.equals("sports")){
                String[] myArray = {"Baseball", "Football", "Soccer", "Basketball", "Basket", "Goal", "Helmet", "Cleats", "Jersey", "Layup"};
                myQuiz.englishQuiz(myArray);
            }
            else if(englishType.equals("states")){
                String[] myArray = {"Alaska", "California", "Florida", "Georgia", "Hawaii", "Maryland", "Michigan", "Nevada", "Pennsylvania", "Vermont"};
                myQuiz.englishQuiz(myArray);
            }
            else if(englishType.equals("colors")){
                String[] myArray = {"Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet", "Turquoise", "Gold", "Purple"};
                myQuiz.englishQuiz(myArray);
            }
        }

        System.out.println("Thanks for playing! You finished with a score of " + myQuiz.getScore() + " out of " + myQuiz.getNumQuestions() + "!");
    }
}
