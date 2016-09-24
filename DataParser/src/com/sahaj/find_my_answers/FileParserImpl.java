package com.sahaj.find_my_answers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rupam.ghosh on 23/09/16.
 */
public class FileParserImpl implements FileParser {
    private File file;
    private List<String> lines;

    /**
     * Usage:
     * FileParser fileParser = new FileParser("<full_path_to_text>");
     * fileParser.parse();
     * fileParser.getLines();
     */
    public FileParserImpl(String path) {
        if (path == null) {
            throw new IllegalArgumentException("file path not given");
        }
        if (path.length() < 1) {
            throw new IllegalArgumentException("file path is empty");
        }
        file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException("did not find file in path " + path);
        }
    }

    /**
     * Used to parse the file passed in constructor
     */
    public void parse() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                if (lines == null) {
                    lines = new ArrayList<String>();
                }
                lines.add(line);
            }
            br.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return all lines in the file
     */
    public List<String> getLines() {
        return lines;
    }

    /**
     *
     * @return whether file was parsed
     */
    @Override
    public boolean isFileParsed() {
        return lines != null;
    }
}
