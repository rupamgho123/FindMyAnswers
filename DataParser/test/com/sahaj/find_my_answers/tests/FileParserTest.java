package com.sahaj.find_my_answers.tests;

import com.sahaj.find_my_answers.FileParser;
import com.sahaj.find_my_answers.FileParserImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by rupam.ghosh on 24/09/16.
 */
public class FileParserTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfPathIsNull(){
        new FileParserImpl(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfPathIsEmpty(){
        new FileParserImpl("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfPathIsWrong(){
        new FileParserImpl("/Users/rupam.ghosh/random.txt");
    }

    @Test
    public void shouldParseSuccessfullyIfPathIsCorrect(){
        FileParser fileParser = new FileParserImpl("/Users/rupam.ghosh/repositories/FindMyAnswers/sample_inputs/input1.txt");
        Assert.assertFalse(fileParser.isFileParsed());
        Assert.assertNull(fileParser.getLines());

        fileParser.parse();
        Assert.assertTrue(fileParser.isFileParsed());
        Assert.assertNotNull(fileParser.getLines());
    }
}
