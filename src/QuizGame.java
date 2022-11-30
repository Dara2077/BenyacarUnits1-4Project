import java.util.Scanner;
import java.lang.Object;
import java.util.Arrays;


/**
 * The QuizGame class represents a quiz game. A quiz game is a game with a certain number of questions
 * asked and a score that represents the total number of questions answered correctly
 */
public class QuizGame {
    Scanner scan = new Scanner (System.in);
    private int numQuestions;
    private int score;

    /**
     * Constructor for the person class. This creates a new instance of a QuizGame
     * given the below parameter
     *
     * @param numQuestions an integer representing the number of questions the user wantd to answer
     */
    public QuizGame(int numQuestions) {
        this.numQuestions = numQuestions;
    }

    /**
     * mathQuiz method for the QuizGame class. If the user chooses to play the math game,
     * this method will cause the user to answer randomized math questions involving different operations
     */
    public void mathQuiz(){
        int numOne = 0;
        int numTwo = 0;
        int userAnswer = 0;
        for (int i = 1; i <=numQuestions; i ++){
            numOne = (int) (Math.random() *20) +1;
            numTwo = (int) (Math.random() *20) +1;
            String operator = chooseOperator();
            int answer = solveProblem(numOne, numTwo, operator);
            if (operator.equals("/") && numOne%numTwo != 0){
                System.out.print("What is " + numOne + operator + numTwo + " rounded to the nearest integer? ");
            }
            else{
                System.out.print("What is " + numOne + operator + numTwo + "? ");
            }
            userAnswer = scan.nextInt();
            if (userAnswer == answer){
                score ++;
                System.out.println("Correct!");
            }
            else {
                System.out.println("Incorrect. The answer is " + answer);
            }
        }
    }

    /**
     * the getScore method will give what the user's score is
     * @return returns the integer value of the score parameter
     */

    public int getScore(){
        return score;
    }

    /**
     * chooseOperator uses the math class to select a random number from one to four.
     * Each number from one to four corresponds to an operator, and the operator the number corresponds to will be the
     * operator used in a math question for the math quiz. It is used for all the math questions so that there is a random operator each time.
     * For example, if the user inputted that the want to be asked four math questions, this method will run four times.
     * @return returns the randomly chosen operator as a String
     */
    public String chooseOperator(){
        int randomNum = (int)(Math.random() *4) +1;
        if (randomNum == 1){
            return "+";
        }
        if (randomNum == 2){
            return "-";
        }
        if (randomNum == 3){
            return "*";
        }
        else{
            return "/";
        }
    }

    /**
     * solveProblem identifies the operator being used for the given problem, as well as the two numbers involved, and solves the problem accordingly.
     * For example, if numOne is 3 and numTwo is 5 and the operator is +, the solution will be 8.
     * @param numOne an integer representing the first number of the calculation
     * @param numTwo an integer representing the second number of the calculation
     * @param operator a String representing the operator used in the calculation
     * @return returns the appropriate solution to the problem based on the numbers and operator.
     */
    public int solveProblem(int numOne, int numTwo, String operator){
        if (operator.equals("+")){
            return numOne + numTwo;
        }
        if (operator.equals("-")){
            return numOne - numTwo;
        }
        if (operator.equals("*")){
            return numOne * numTwo;
        }
        else{
            return numOne/numTwo;
        }
    }

    public void englishQuiz(String[] input){
        String[] myArray = input;
        for (int i = 0; i <numQuestions; i++){
            String question = pickEnglishQuestion();
            String word = myArray[i];
            int answer = findEnglishAnswer(question, word);
            System.out.print("How many " + question + " are in \"" + word + "\"? ");
            int userAnswer = scan.nextInt();
            if (answer == userAnswer){
                System.out.println("Correct!");
                score ++;
            }
            else{
                System.out.println("Incorrect. The answer is " + answer);
            }
        }

    }

    public String pickEnglishQuestion(){
        int randomNum = (int)(Math.random() * 2 + 1);
        if (randomNum == 1){
            return "vowels";
        }
        else{
            return "consonants";
        }
    }

    public int findEnglishAnswer(String question, String word){
        if (question.equals("vowels")){
            return vowelCounter(word);
        }
        else{
            return consonantCounter(word);
        }
    }

    public int vowelCounter(String str){
        str = str.toLowerCase();
        int count = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.substring(i, i+1).equals("a") || str.substring(i, i+1).equals("e") || str.substring(i, i+1).equals("i") || str.substring(i, i+1).equals("o") || str.substring(i, i+1).equals("u")){
                count ++;
            }
        }
        return count;
    }

    public int consonantCounter(String str){
        int numVowels = vowelCounter(str);
        int lengthStr = str.length();
        return lengthStr - numVowels;
    }
}




