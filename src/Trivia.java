import java.util.Scanner;

public class Trivia {
    Scanner scan = new Scanner (System.in);
    private int numQuestions;
    private int count;

    public Trivia(int numQuestions) {
        this.numQuestions = numQuestions;
    }

    //Method for the math trivia
    public void mathTrivia(){
        int numOne = 0;
        int numTwo = 0;
        int userAnswer = 0;
        for (int i = 1; i <=numQuestions; i ++){
            numOne = (int) (Math.random() *10) +1;
            numTwo = (int) (Math.random() *10) +1;
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
                System.out.println("You got that question right, so your score increases by one");
            }
            else {
                System.out.println("Sorry, that's not correct. Your score remains at " + count);
            }
        }
    }

    //Getter method to return the count
    public int getCount(){
        return count;
    }

    //Chooses operator for math trivia
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

    //Solves math problem based on operator for math trivia
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

}




