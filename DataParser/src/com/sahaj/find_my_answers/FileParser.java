package com.sahaj.find_my_answers;

import java.util.List;

/**
 * Created by rupam.ghosh on 23/09/16.
 */
public interface FileParser {

    /**
     * Used to parse the file passed in constructor
     */
    void parse();

    /**
     *
     * @return all lines in the file is file is parsed otherwise null
     */
    List<String> getLines();

    /**
     *
     * @return whether file was parsed
     */
    boolean isFileParsed();
}
