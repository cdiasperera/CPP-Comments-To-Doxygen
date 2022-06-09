package Core.IO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class InputReader {
    private final File inputFile;
    private String inputFileContents = null;
    private final Logger logger = LogManager.getLogger(InputReader.class);

    public InputReader(String file) {
        inputFile = new File(file);
    }

    public String getContents() {
        if (inputFileContents != null) {
            return inputFileContents;
        }
        readFile();
        return inputFileContents;
    }

    private void readFile() {
        try {
            inputFileContents = FileUtils.readFileToString(inputFile, Charset.defaultCharset());
        } catch (IOException e) {
            logger.error("Could not read input file: " + inputFile);
        }
    }
}
