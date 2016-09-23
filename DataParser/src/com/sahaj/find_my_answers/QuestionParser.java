package com.sahaj.find_my_answers;

import java.util.List;

/**
 * Created by rupam.ghosh on 23/09/16.
 */
public interface QuestionParser {
    void parse();

    List<String> getParagraph();

    List<String> getQuestions();

    List<String> getAnswers();

    void checkIfParsed();
}
