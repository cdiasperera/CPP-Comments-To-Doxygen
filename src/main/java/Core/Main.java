package Core;

import Core.Convertor.CPPConvertor;
import Core.Convertor.Convertor;
import Core.Convertor.DoxygenConvertor;
import Core.Exceptions.ConvertorNoStringException;
import Core.IO.InputReader;
import Core.IO.OutputWriter;
import Core.UI.Validator;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Main {
    private static final int INPUT_FILE = 0;
    private static final int OUTPUT_FILE = 1;
    public static final int CONVERT_DIRECTION = 2;
    public static final String TO_DOXYGEN = "1";
    public static final String TO_CPP = "2";

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
        Validator validator = new Validator(args);

        if(validator.hasErrors()) {
           if (validator.getMainError() == Validator.WRONG_USAGE) {
               logger.error("Usage: Java Core.Main <input-file-path> <output-file-path> <convertor-direction>");
               System.exit(-1);
           }

           if (validator.getMainError() == Validator.WRONG_CONVERT_DIRECTION) {
               logger.error("<convert-direction> = " + TO_DOXYGEN + " | " + TO_CPP);
               System.exit(-1);
           }
        }

    }

    private static void init() {
        BasicConfigurator.configure();
    }
}
