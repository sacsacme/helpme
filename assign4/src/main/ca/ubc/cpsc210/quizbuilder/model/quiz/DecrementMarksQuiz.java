package ca.ubc.cpsc210.quizbuilder.model.quiz;

import ca.ubc.cpsc210.quizbuilder.model.question.Question;
import ca.ubc.cpsc210.quizbuilder.model.questionslist.QuestionsList;


public class DecrementMarksQuiz extends Quiz {
    private int tries;

    private int nextQuestion;
    private int markSoFar;




    public DecrementMarksQuiz(QuestionsList questions) {
        super(questions);
    }


    @Override
    // EFFECTS: returns true if user is out of tries to answer current question or has answered
    // current question correctly, false otherwise
    public boolean isOutOfTries() {
        return (tries == 0);
    }

    // REQUIRES: curQuestion must not be the last question
    // MODIFIES: this
    // EFFECTS: returns next question in quiz
    @Override
    public Question getNextQuestion() {
        Question ret = questions.getQuestion(nextQuestion);
        this.nextQuestion += 1;
        curQuestion = ret;
        tries = curQuestion.getMaxMark();
        return ret;
    }

    // MODIFIES: this
    // EFFECTS: checks the answer to the current question; if answer is true, updates marks earned;
    // returns true if the answer is correct, and false otherwise.
    @Override
    protected boolean checkAnswer(String answer) {
        if (this.curQuestion.isCorrect(answer)) {
            markSoFar += tries;
            return true;
        }
        return false;
    }

    // EFFECTS: returns whether or not curQuestion is the last question.
    @Override
    public boolean anymoreQuestions() {
        return (nextQuestion < this.questions.length());
    }

    // MODIFIES: this
    // EFFECTS: Ends the quiz. Returns a string to tell user their final mark.
    @Override
    public String endQuiz() {
        super.endQuiz();
        return "Your final mark is: " + markSoFar;
    }



    // REQUIRES: !isOutOfTries()
    // MODIFIES: this
    // EFFECTS: submit an answer to the current question and return feedback string
    public String submitAnswer(String answer) {

        boolean isCorrect = checkAnswer(answer);
        System.out.println(markSoFar);


        if (isCorrect) {
            int marksEarned = tries;
            tries = 0;
            return "Your answer is  correct You earned " + marksEarned + " points!";
        }

        tries = tries - 1;
        return "Your answer is not correct. Max marks remaining for question: " + tries;
    }

}
