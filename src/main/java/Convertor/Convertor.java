package Convertor;

import Exceptions.ConvertorNoStringException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Convertor {
    private final Logger logger = LogManager.getLogger(Convertor.class);
    String toConvert = null;
    String convertedString = null;
    public void setStringToConvert(String toConvert) {
        this.toConvert = toConvert;
    }

    public String getConvertedString() throws ConvertorNoStringException{
        if (convertedString != null) {
            return convertedString;
        }

        // Need to convert string
        if (toConvert == null) {
            throw new ConvertorNoStringException("No string to convert");
        }

        convertString();

        return convertedString;



    }

    public void setToConvert(String toConvert) {
        this.toConvert = toConvert;
        this.convertedString = null;
    }

    private void convertString() {
        convertedString = toConvert;
    }
}
