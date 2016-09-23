package com.sahaj.find_my_answers;

/**
 * Created by rupam.ghosh on 22/09/16.
 */
public class FindMyAnswersApp {
    public static void main(String[] args) {
        QuestionParser questionParser = new QuestionParserImpl("/Users/rupam.ghosh/repositories/FindMyAnswers/sample_inputs/input1.txt",
                0, 1, 6, 6);
        questionParser.parse();
        QuestionDataProcessor questionDataProcessor = new QuestionDataProcessorV1(questionParser);
        questionDataProcessor.process();
        questionDataProcessor.printAnswersInOrder();
    }
}
