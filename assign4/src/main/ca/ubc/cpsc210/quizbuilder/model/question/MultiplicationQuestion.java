package ca.ubc.cpsc210.quizbuilder.model.question;

public class MultiplicationQuestion extends Question {
    private int correctAnswer;

    public MultiplicationQuestion(int maxMark, int factor1, int factor2) {
        super(maxMark, ("Tell us the missing number: " + factor1 +  " * " + factor2 + " = ???"));
        correctAnswer = (factor1 * factor2);

    }


    @Override
    public boolean isCorrect(String answer) {
        int answerI = Integer.parseInt(answer);
        return (answerI == correctAnswer);
    }
}
