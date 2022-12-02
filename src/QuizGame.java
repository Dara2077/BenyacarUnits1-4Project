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
     * Constructor for the QuizGame class. This creates a new instance of a QuizGame
     * given the below parameter
     *
     * @param numQuestions - an integer representing the number of questions the user wants to answer
     */
    public QuizGame(int numQuestions) {
        this.numQuestions = numQuestions;
    }

    /**
     * Constructor for the QuizGame class. This creates a new instance of a QuizGame.
     * It does not have any parameters because it will randomly choose the number of questions the user answers.
     * So, there's no need for user input
     */
    public QuizGame(){
        int randomNum = (int) (Math.random() *10 + 1);
        this.numQuestions = randomNum;
    }

    /**
     * Gets the number of questions the user will answer, formatted correctly
     * @return returns the number of questions the user will answer in a formatted sentence
     */
    public String toString(){
        return "You will be asked " + getNumQuestions() + " questions";
    }
    /**
     * If the user chooses to play the math game,
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
     * Gets the user's score
     * @return returns the integer value of the score instance variable
     */
    public int getScore(){
        return score;
    }

    /**
     * Gets the number of questions the user will be asked
     * @return returns the integer value of the numQuestions instance variable
     */
    public int getNumQuestions(){
        return numQuestions;
    }

    /**
     * Uses the math class to select a random number from one to four.
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
     * Identifies the operator being used for the given problem, as well as the two numbers involved, and solves the problem accordingly.
     * For example, if numOne is 3 and numTwo is 5 and the operator is +, the solution will be 8.
     * @param numOne - an integer representing the first number of the calculation
     * @param numTwo - an integer representing the second number of the calculation
     * @param operator - a String representing the operator used in the calculation
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

    /** If the user chooses to play the English Quiz game, the user will be asked
     * questions relating to English.
     *
     * @param array - An array that corresponds to the theme the user has chosen for their English question. For example, if the user has chosen Java, the array will contain String literals related to Java.
     *
     */
    public void englishQuiz(String[] array){
        for (int i = 0; i <numQuestions; i++){
            String question = pickEnglishQuestion();
            String word = array[i];
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

    /** Uses the Math class to randomly pick between one or two. Based on the number, the user will be asked to find
     * either the number of vowels or consonants in the word. This is because this method is used in the englishQuiz method.
     *
     * @return returns either "vowels" or "consonants" to indicate what the user will be asked for
     */
    public String pickEnglishQuestion(){
        int randomNum = (int)(Math.random() * 2 + 1);
        if (randomNum == 1){
            return "vowels";
        }
        else{
            return "consonants";
        }
    }

    /** Given what the user is being asked for in a given word, this method finds the correct answer
     *
     * @param question - a String representing what the user is being asked for
     * @param word - a String representing what word the user is being asked about
     * @return returns the appropriate answer to the question based on the parameters
     */
    public int findEnglishAnswer(String question, String word){
        boolean vowels = question.equals("vowels");
        if (vowels){
            return vowelCounter(word);
        }
        else{
            return consonantCounter(word);
        }
    }

    /** Counts the number of vowels in a String
     *
     * @param str - String that the method determines how many vowels are in
     * @return returns the amount of vowels in the given String
     */
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

    /** Counts the number of consonants in a String
     *
     * @param str - String that the method determines how many consonants are in
     * @return returns the amount of consonants in the given String
     */
    public int consonantCounter(String str){
        int numVowels = vowelCounter(str);
        int lengthStr = str.length();
        return lengthStr - numVowels;
    }
}




