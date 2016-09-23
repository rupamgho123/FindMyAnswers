package com.sahaj.find_my_answers;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rupam.ghosh on 23/09/16.
 */
public class QuestionParserImpl extends FileParserImpl implements QuestionParser {

    private static final String SEMI_COLON = ";";
    private static final String FULL_STOP = "\\.";
    private int paragraphIndex, questionStartIndex, questionEndIndex, answerIndex;

    /**
     * Usage:
     * QuestionParser questionParser = new QuestionParserImpl("/Users/rupam.ghosh/repositories/FindMyAnswers/sample_inputs/input1.txt",
     * 0,1,5,6);
     * questionParser.parse();
     * List<String> questions = questionParser.getQuestions();
     * List<String> answers = questionParser.getAnswers();
     */
    QuestionParserImpl(String path, int paragraphIndex, int questionStartIndex, int questionEndIndex, int answerIndex) {
        super(path);
        this.paragraphIndex = paragraphIndex;
        this.questionStartIndex = questionStartIndex;
        this.questionEndIndex = questionEndIndex;
        this.answerIndex = answerIndex;
    }

    @Override
    public List<String> getParagraph() {
        checkIfParsed();
        return Arrays.asList(getLines().get(paragraphIndex).split(FULL_STOP));
    }

    @Override
    public List<String> getQuestions() {
        checkIfParsed();
        return getLines().subList(questionStartIndex, questionEndIndex);
    }

    @Override
    public List<String> getAnswers() {
        checkIfParsed();
        return Arrays.asList(getLines().get(answerIndex).split(SEMI_COLON));
    }

    @Override
    public void checkIfParsed() {
        if (!isFileParsed()) {
            throw new IllegalStateException("File is not parsed,perhaps you did not call questionParser.parse() first");
        }
    }
}
