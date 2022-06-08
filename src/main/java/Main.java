import Convertor.*;
import Exceptions.ConvertorNoStringException;
import IO.InputReader;
import IO.OutputWriter;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Main {
    private static final int INPUT_FILE = 0;
    private static final int OUTPUT_FILE = 1;
    private static final int CONVERT_DIRECTION = 2;
    private static final String TO_DOXYGEN = "1";
    private static final String TO_CPP = "2";

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        init();

        validateCommandLineArguments(args);

        performConversion(args);
    }

    private static void performConversion(String[] args) {
        Convertor convertor =
                args[CONVERT_DIRECTION].equals(TO_DOXYGEN) ? new CPPConvertor()  : new DoxygenConvertor();

        InputReader ir = new InputReader(args[INPUT_FILE]);
        convertor.setStringToConvert(ir.getContents());

        OutputWriter ow = new OutputWriter(args[OUTPUT_FILE]);
        try {
            ow.write(convertor.getConvertedString());
        } catch (ConvertorNoStringException e) {
            logger.error("Error during conversion");
        }
    }

    private static void validateCommandLineArguments(String[] args) {
        if (args.length != 3) {
            logger.error("Usage: Java Main <input-file-path> <output-file-path> <convertor-direction>");
            System.exit(-1);
        }

        if (!args[CONVERT_DIRECTION].equals(TO_DOXYGEN) && !args[CONVERT_DIRECTION].equals(TO_CPP)) {
            logger.error("<convert-direction> = " + TO_DOXYGEN + " | " + TO_CPP);
        }
    }

    private static void init() {
        BasicConfigurator.configure();
    }
}
