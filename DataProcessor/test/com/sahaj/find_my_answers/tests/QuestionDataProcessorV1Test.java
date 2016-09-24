package com.sahaj.find_my_answers.tests;

import com.sahaj.find_my_answers.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by rupam.ghosh on 24/09/16.
 */
public class QuestionDataProcessorV1Test {

    @Test
    public void shouldFindAnswersCorrectlyForInput1() {
        QuestionParser questionParser = new QuestionParserImpl("/Users/rupam.ghosh/repositories/FindMyAnswers/sample_inputs/input1.txt",
                0, 1, 6, 6);
        questionParser.parse();
        QuestionDataProcessor questionDataProcessor = new QuestionDataProcessorV1(questionParser, new WordIndexer(new SimpleLanguageProcessor()));
        questionDataProcessor.process();
        List<String> orderedAnswers = questionDataProcessor.getOrderedAnswers();
        Assert.assertEquals(5, orderedAnswers.size());
        Assert.assertEquals("Grévy's zebra and the mountain zebra", orderedAnswers.get(0));
        Assert.assertEquals("aims to breed zebras that are phenotypically similar to the quagga", orderedAnswers.get(1));
        Assert.assertEquals("horses and donkeys", orderedAnswers.get(2));
        Assert.assertEquals("the plains zebra, the Grévy's zebra and the mountain zebra", orderedAnswers.get(3));
        Assert.assertEquals("subgenus Hippotigris", orderedAnswers.get(4));
    }

    @Test
    public void shouldFindAnswersCorrectlyForInput2() {
        QuestionParser questionParser = new QuestionParserImpl("/Users/rupam.ghosh/repositories/FindMyAnswers/sample_inputs/input2.txt",
                0, 1, 6, 6);
        questionParser.parse();
        QuestionDataProcessor questionDataProcessor = new QuestionDataProcessorV1(questionParser, new WordIndexer(new SimpleLanguageProcessor()));
        questionDataProcessor.process();
        List<String> orderedAnswers = questionDataProcessor.getOrderedAnswers();
        Assert.assertEquals(5, orderedAnswers.size());
        Assert.assertEquals("aims to breed zebras that are phenotypically similar to the quagga", orderedAnswers.get(0));
        Assert.assertEquals("the plains zebra, the Grévy's zebra and the mountain zebra", orderedAnswers.get(1));
        Assert.assertEquals("Grévy's zebra and the mountain zebra", orderedAnswers.get(2));
        Assert.assertEquals("subgenus Hippotigris", orderedAnswers.get(3));
        Assert.assertEquals("horses and donkeys", orderedAnswers.get(4));
    }
}
