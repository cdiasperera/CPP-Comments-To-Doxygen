import Convertor.Convertor;
import Exceptions.ConvertorNoStringException;
import IO.InputReader;
import IO.OutputWriter;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Main {
    private static final int INPUT_FILE = 0;
    private static final int OUTPUT_FILE = 1;

    public static void main(String[] args) {
        BasicConfigurator.configure();
        Logger logger = LogManager.getLogger(Main.class);
        if (args.length != 2) {
            logger.error("Usage: Java Main <input-file-path> <output-file-path>");
            System.exit(-1);
        }

        Convertor convertor = new Convertor();
        InputReader ir = new InputReader(args[INPUT_FILE]);
        convertor.setStringToConvert(ir.getContents());

        OutputWriter ow = new OutputWriter(args[OUTPUT_FILE]);
        try {
            ow.write(convertor.getConvertedString());
        } catch (ConvertorNoStringException e) {
            logger.error("Error during conversion");
        }
    }
}
