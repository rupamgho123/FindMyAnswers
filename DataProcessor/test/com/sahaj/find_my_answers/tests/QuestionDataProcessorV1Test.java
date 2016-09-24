package com.sahaj.find_my_answers.tests;

import com.sahaj.find_my_answers.QuestionDataProcessor;
import com.sahaj.find_my_answers.QuestionDataProcessorV1;
import com.sahaj.find_my_answers.QuestionParser;
import com.sahaj.find_my_answers.QuestionParserImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by rupam.ghosh on 24/09/16.
 */
public class QuestionDataProcessorV1Test {

    @Test
    public void shouldFindAnswersCorrectly() {
        QuestionParser questionParser = new QuestionParserImpl("/Users/rupam.ghosh/repositories/FindMyAnswers/sample_inputs/input1.txt",
                0, 1, 6, 6);
        questionParser.parse();
        QuestionDataProcessor questionDataProcessor = new QuestionDataProcessorV1(questionParser);
        questionDataProcessor.process();
        List<String> orderedAnswers = questionDataProcessor.getOrderedAnswers();
        Assert.assertEquals(5,orderedAnswers.size());
        Assert.assertEquals("Grévy's zebra and the mountain zebra",orderedAnswers.get(0));
        Assert.assertEquals("aims to breed zebras that are phenotypically similar to the quagga",orderedAnswers.get(1));
        Assert.assertEquals("horses and donkeys",orderedAnswers.get(2));
        Assert.assertEquals("the plains zebra, the Grévy's zebra and the mountain zebra",orderedAnswers.get(3));
        Assert.assertEquals("subgenus Hippotigris",orderedAnswers.get(4));

    }
}
