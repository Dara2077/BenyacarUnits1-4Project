import java.util.Scanner;

public class QuizGame {
    Scanner scan = new Scanner (System.in);
    private int numQuestions;
    private int count;

    public QuizGame(int numQuestions) {
        this.numQuestions = numQuestions;
    }

    //Method for the math quiz
    public void mathQuiz(){
        int numOne = 0;
        int numTwo = 0;
        int userAnswer = 0;
        for (int i = 1; i <=numQuestions; i ++){
            numOne = (int) (Math.random() *20) +1;
            numTwo = (int) (Math.random() *20) +1;
            String operator = chooseOperator();
            int answer = solveProblem(numOne, numTwo, operator);
            if (operator.equals("/")){
                System.out.print("What is " + numOne + operator + numTwo + " rounded to the nearest integer? ");
            }
            else{
                System.out.print("What is " + numOne + operator + numTwo + "? ");
            }
            userAnswer = scan.nextInt();
            if (userAnswer == answer){
                count ++;
                System.out.println("Correct!");
            }
            else {
                System.out.println("Incorrect");
            }
        }
    }

    //Getter method to return the count
    public int getCount(){
        return count;
    }

    //Chooses operator for math quiz
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

    //Solves math problem based on operator for math quiz
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

    public void EnglishQuiz (){
        String[] javaWords = {"Method", "Class", "Boolean", "Conditional", "Iteration", "Loop", "IDE", "Semicolon", "Parameter", "Constructor"};
        String[] sportsWords = {"baseball", "football", "soccer", "basketball", "basket", "goal", "helmet", "cleats", "jersey", "layup"};
        String[] stateWords = {"Alaska", "California", "Florida", "Georgia", "Hawaii", "Maryland", "Michigan", "Nevada", "Pennsylvania", "Vermont"};

    }
}




