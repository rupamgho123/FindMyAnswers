package com.sahaj.find_my_answers;

import java.util.List;

/**
 * Created by rupam.ghosh on 23/09/16.
 */
public interface FileParser {
    void parse();

    List<String> getLines();

    boolean isFileParsed();
}
