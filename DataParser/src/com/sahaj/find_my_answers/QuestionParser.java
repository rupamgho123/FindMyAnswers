package com.sahaj.find_my_answers;

import java.util.List;

/**
 * Created by rupam.ghosh on 23/09/16.
 */
public interface QuestionParser extends FileParser{
    /**
     *
     * @return List of line in the paragraph
     */
    List<String> getParagraph();

    /**
     *
     * @return List of questions
     */
    List<String> getQuestions();

    /**
     *
     * @return List of answers
     */
    List<String> getAnswers();

    /**
     * ensures that file is parsed otherwise throws IllegalStateException
     */
    void checkIfParsed();
}
