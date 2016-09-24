package com.sahaj.find_my_answers.tests;

import com.sahaj.find_my_answers.LanguageProcessor;
import com.sahaj.find_my_answers.SimpleLanguageProcessor;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by rupam.ghosh on 24/09/16.
 */
public class SimpleLanguageProcessorTest {

    @Test
    public void testDetectionOfWordsToIndex() {
        LanguageProcessor languageProcessor = new SimpleLanguageProcessor();
        Assert.assertFalse(languageProcessor.shouldIndex("is"));
        Assert.assertTrue(languageProcessor.shouldIndex("endangered"));
    }
}
