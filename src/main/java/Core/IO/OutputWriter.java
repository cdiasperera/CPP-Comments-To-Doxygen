package Core.IO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class OutputWriter {
    private final File outputFile;
    private final Logger logger = LogManager.getLogger(InputReader.class);

    public OutputWriter(String file) {
        outputFile = new File(file);
    }

    public void write(String output) {
        try {
            FileUtils.write(outputFile, output, Charset.defaultCharset());
        } catch (IOException e) {
            logger.error("Could not write to file" + outputFile);
        }
    }
}
