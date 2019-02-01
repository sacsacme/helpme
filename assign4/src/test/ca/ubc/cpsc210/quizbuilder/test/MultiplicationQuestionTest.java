package ca.ubc.cpsc210.quizbuilder.test;

import ca.ubc.cpsc210.quizbuilder.model.question.MultiplicationQuestion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicationQuestionTest {


    private MultiplicationQuestion multiplicationQ;

    @BeforeEach
    public void beforeEach(){
         multiplicationQ = new MultiplicationQuestion(10,7,6);
    }

    @Test
    public void isCorrectWrongAnswerTest(){
        assertFalse(multiplicationQ.isCorrect("5"));

    }
    @Test

    public void isCorrectRightAnswer(){
        assertTrue(multiplicationQ.isCorrect("42"));
    }

    @Test
    public void getQuestionString(){
        String properString = "Tell us the missing number: 7 * 6 = ??? [10 points]";
        assertEquals(multiplicationQ.getQuestionString(),properString);


    }
    @Test
    public void setMaxMark(){
        multiplicationQ.setMaxMark(5);
        assertEquals(multiplicationQ.getMaxMark(),5);
    }



}