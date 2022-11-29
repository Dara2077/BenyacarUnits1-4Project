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
                System.out.println("Incorrect. The answer is " + answer);
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
    public void englishQuiz(String[] input){

    }
    public void javaQuiz (String[] input){
        String[] java = {"Method", "Class", "Boolean", "Conditional", "Iteration", "Loop", "IDE", "Semicolon", "Parameter", "Constructor"};
        for (int i = 0; i <=numQuestions; i++){
            String question = pickEnglishQuestion();
            String word = java[i];
            int answer = findEnglishAnswer(question, word);
            System.out.print("How many " + question + " are in " + word + "?" );
            int userAnswer = scan.nextInt();
            if (answer == userAnswer){
                System.out.println("Correct!");
                count ++;
            }
            else{
                System.out.println("Incorrect. The answer is " + answer);
            }
        }
    }

    public void sportsQuiz(){
        String[] sports = {"Baseball", "Football", "Soccer", "Basketball", "Basket", "Goal", "Helmet", "Cleats", "Jersey", "Layup"};
        for (int i = 0; i <=numQuestions; i++){
            String question = pickEnglishQuestion();
            String word = sports[i];
            int answer = findEnglishAnswer(question, word);
            System.out.print("How many " + question + " are in " + word + "?" );
            int userAnswer = scan.nextInt();
            if (answer == userAnswer){
                System.out.println("Correct!");
                count ++;
            }
            else{
                System.out.println("Incorrect. The answer is " + answer);
            }
        }

    }

    public void statesQuiz(){
        String[] states = {"Alaska", "California", "Florida", "Georgia", "Hawaii", "Maryland", "Michigan", "Nevada", "Pennsylvania", "Vermont"};
        for (int i = 0; i <=numQuestions; i++){
            String question = pickEnglishQuestion();
            String word = states[i];
            int answer = findEnglishAnswer(question, word);
            System.out.print("How many " + question + " are in " + word + "?" );
            int userAnswer = scan.nextInt();
            if (answer == userAnswer){
                System.out.println("Correct!");
                count ++;
            }
            else{
                System.out.println("Incorrect. The answer is " + answer);
            }
        }
    }

    public void colorsQuiz(){
        String[] colors = {"Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet", "Turquoise", "Gold", "Purple"};
        for (int i = 0; i <=numQuestions; i++){
            String question = pickEnglishQuestion();
            String word = colors[i];
            int answer = findEnglishAnswer(question, word);
            System.out.print("How many " + question + " are in " + word + "?" );
            int userAnswer = scan.nextInt();
            if (answer == userAnswer){
                System.out.println("Correct!");
                count ++;
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
        int count = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.substring(i, i+1).equals("a") || str.substring(i, i+1).equals("e") || str.substring(i, i+1).equals("i") || str.substring(i, i+1).equals("o") || str.substring(i, i+1).equals("u")){
                count ++;
            }
        }
        return count;
    }

    public int consonantCounter(String str){
        int count = 0;
        int numVowels = vowelCounter(str);
        int lengthStr = str.length();
        return lengthStr - numVowels;
    }
}




