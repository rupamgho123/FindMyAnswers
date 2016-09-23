package com.sahaj.find_my_answers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rupam.ghosh on 23/09/16.
 */
public abstract class BaseQuestionDataProcessor implements QuestionDataProcessor {
    private QuestionParser questionParser;
    private List<String> orderedAnswers;

    public BaseQuestionDataProcessor(QuestionParser questionParser) {
        if (questionParser == null) {
            throw new IllegalArgumentException("questionParser cannot be null");
        }
        questionParser.checkIfParsed();
        this.questionParser = questionParser;
        orderedAnswers = new ArrayList<String>();
    }

    @Override
    public abstract void process();

    @Override
    public final void printAnswersInOrder() {
        if (orderedAnswers != null) {
            for (String answer : orderedAnswers) {
                System.out.println(answer);
            }
        }
    }

    @Override
    public void acceptAnswer(String answer) {
        if (orderedAnswers != null) {
            orderedAnswers.add(answer);
        }
    }

    public final QuestionParser getQuestionParser() {
        return questionParser;
    }
}
