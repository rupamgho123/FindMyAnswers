package com.sahaj.find_my_answers;

import java.util.List;

/**
 * Created by rupam.ghosh on 23/09/16.
 */
public interface QuestionDataProcessor {
    /**
     * Used to process the file
     */
    void process();

    /**
     *
     * @return the QuestionParser used
     * @see QuestionParser
     */
    QuestionParser getQuestionParser();

    /**
     *
     * @return the WordIndexer used
     * @see WordIndexer
     */
    WordIndexer getWordIndexer();

    /**
     * prints all the answers in order
     */
    void printAnswersInOrder();

    /**
     * used to accept an answer
     * @param answer
     */
    void acceptAnswer(String answer);

    /**
     *
     * @return list of answers in order
     */
    List<String> getOrderedAnswers();
}
