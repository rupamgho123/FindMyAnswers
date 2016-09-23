package com.sahaj.find_my_answers;

/**
 * Created by rupam.ghosh on 23/09/16.
 */
public interface QuestionDataProcessor {
    void process();

    QuestionParser getQuestionParser();

    void printAnswersInOrder();

    void acceptAnswer(String answer);
}
