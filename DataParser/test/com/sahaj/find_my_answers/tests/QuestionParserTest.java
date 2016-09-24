package com.sahaj.find_my_answers.tests;

import com.sahaj.find_my_answers.QuestionParser;
import com.sahaj.find_my_answers.QuestionParserImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by rupam.ghosh on 24/09/16.
 */
public class QuestionParserTest {
    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionIfParsingNotDoneAndGetQuestionsCalled() {
        QuestionParser questionParser = new QuestionParserImpl("/Users/rupam.ghosh/repositories/FindMyAnswers/sample_inputs/input1.txt",
                0, 1, 6, 6);
        questionParser.getQuestions();
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionIfParsingNotDoneAndGetParagraphCalled() {
        QuestionParser questionParser = new QuestionParserImpl("/Users/rupam.ghosh/repositories/FindMyAnswers/sample_inputs/input1.txt",
                0, 1, 6, 6);
        questionParser.getParagraph();
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionIfParsingNotDoneAndGetAnswersCalled() {
        QuestionParser questionParser = new QuestionParserImpl("/Users/rupam.ghosh/repositories/FindMyAnswers/sample_inputs/input1.txt",
                0, 1, 6, 6);
        questionParser.getAnswers();
    }

    @Test
    public void shouldWorkCorrectlyIfParsingDone() {
        QuestionParser questionParser = new QuestionParserImpl("/Users/rupam.ghosh/repositories/FindMyAnswers/sample_inputs/input1.txt",
                0, 1, 6, 6);
        questionParser.parse();

        List<String> paragraph = questionParser.getParagraph();
        List<String> questions = questionParser.getQuestions();
        List<String> answers = questionParser.getAnswers();

        Assert.assertNotNull(paragraph);
        Assert.assertTrue(paragraph.size() > 0);
        Assert.assertEquals(5,questions.size());
        Assert.assertEquals(5,answers.size());
    }
}
