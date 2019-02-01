package ca.ubc.cpsc210.quizbuilder.test;

import ca.ubc.cpsc210.quizbuilder.model.question.Question;
import ca.ubc.cpsc210.quizbuilder.model.question.TrueFalseQuestion;
import ca.ubc.cpsc210.quizbuilder.model.questionslist.QuestionsList;
import ca.ubc.cpsc210.quizbuilder.model.quiz.DecrementMarksQuiz;
import ca.ubc.cpsc210.quizbuilder.model.quiz.Quiz;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class DecrementMarksQuizTests {

    private Question q1, q2;
    private QuestionsList qList;
    private Quiz testQuiz;

    @BeforeEach
    public void runBefore() {
        // feel free to modify this as needed
        q1 = new TrueFalseQuestion(8, "You are awesome.", true);
        q2 = new TrueFalseQuestion(16, "Donuts are bad for you.", true);
        qList = new QuestionsList();
        qList.addQuestion(q1);
        qList.addQuestion(q2);
    }

    @Test
    public void correctSubmitAnswersTest(){
        testQuiz = new DecrementMarksQuiz(qList);
        testQuiz.getNextQuestion();
        assertEquals(testQuiz.submitAnswer("true"),  "Your answer is  correct You earned 8 points!");

    }
    @Test
    public void incorrectThenCorrectSubmitAnswersTest(){
        testQuiz = new DecrementMarksQuiz(qList);
        testQuiz.getNextQuestion();
        assertEquals(testQuiz.submitAnswer("false"),  "Your answer is not correct. Max marks remaining for question: 7" );
        assertEquals(testQuiz.getMarkSoFar(),0);
        assertEquals(testQuiz.submitAnswer("true"),  "Your answer is  correct You earned 7 points!");


    }
    @Test
    public void anyMoreQuestionsTest(){
        testQuiz = new DecrementMarksQuiz(qList);
        testQuiz.getNextQuestion();
        assertTrue(testQuiz.anymoreQuestions());
        testQuiz.getNextQuestion();
        assertFalse(testQuiz.anymoreQuestions());

    }



    @Test
    public void isOutOFTriesTest(){
        testQuiz = new DecrementMarksQuiz(qList);
        testQuiz.getNextQuestion();
        testQuiz.submitAnswer("false");
        assertFalse(testQuiz.isOutOfTries());
        testQuiz.submitAnswer("false");
        testQuiz.submitAnswer("false");
        testQuiz.submitAnswer("false");
        testQuiz.submitAnswer("false");
        testQuiz.submitAnswer("false");
        testQuiz.submitAnswer("false");
        testQuiz.submitAnswer("false");
        assertTrue(testQuiz.isOutOfTries());


    }

    @Test
    public void endQuizTest(){

        String finalString = "Your final mark is: 24";

        testQuiz = new DecrementMarksQuiz(qList);
        testQuiz.getNextQuestion();
        testQuiz.submitAnswer("true");
        testQuiz.getNextQuestion();
        testQuiz.submitAnswer("true");

        assertEquals(testQuiz.endQuiz(),finalString);



    }


}
