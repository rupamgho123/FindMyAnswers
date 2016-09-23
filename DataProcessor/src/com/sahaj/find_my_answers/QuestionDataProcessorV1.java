package com.sahaj.find_my_answers;

import java.util.*;

/**
 * Created by rupam.ghosh on 23/09/16.
 */
public class QuestionDataProcessorV1 extends BaseQuestionDataProcessor {
    public QuestionDataProcessorV1(QuestionParser questionParser) {
        super(questionParser);
    }

    @Override
    public void process() {
        List<String> paragraph = getQuestionParser().getParagraph();
        List<String> questions = getQuestionParser().getQuestions();
        List<String> answers = getQuestionParser().getAnswers();
        Map<String, Set<Integer>> paragraphIndex = new HashMap<String, Set<Integer>>();
        Map<String, Map<String, Integer>> questionIndex = new HashMap<String, Map<String, Integer>>();
        Map<String, Map<String, Integer>> answerIndex = new HashMap<String, Map<String, Integer>>();

        IndexingUtil.indexWordsByLineNumber(paragraph, paragraphIndex);
        IndexingUtil.indexWordsByCount(questions, questionIndex);
        IndexingUtil.indexWordsByCount(answers, answerIndex);

        for (String question : questions) {
            String correctAnswer = "UNDETERMINED";
            Set<Integer> questionUsage = UsageUtil.getQuestionUsage(question, questionIndex, paragraphIndex);
            for (String answer : answers) {
                Set<Integer> answerUsage = UsageUtil.getAnswerUsage(answer, answerIndex, paragraphIndex);
                if(answerUsage != null) {
                    Set<Integer> intersection = new HashSet<Integer>(answerUsage);
                    intersection.retainAll(questionUsage);
                    if (intersection.size() >= 1) {
                        correctAnswer = answer;
                        break;
                    }
                }
            }
            acceptAnswer(correctAnswer);
        }
    }
}
