package Convertor;

import Convertor.FileContentTypes.Code;
import Convertor.FileContentTypes.DocumentationComments.DoxygenStyleDocumentationComment;
import Convertor.FileContentTypes.NonDocumentationComments;
import Convertor.FileContentTypes.DocumentationComments.StandardStyleDocumentationComment;
import Exceptions.ConvertorNoStringException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;

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
        CommentParser parser = new CommentParser(toConvert);

        // Extract file contents
        ArrayList<StandardStyleDocumentationComment> comments = parser.getDocumentationComments();
        ArrayList<Code> codes = parser.getCodes();
        ArrayList<NonDocumentationComments> nonDocumentationComments = parser.getNonDocumentationComments();

        // Create converted doxygen comments
        ArrayList<DoxygenStyleDocumentationComment> convertedComments = convertComments(comments);

        mergeFileContents(codes, nonDocumentationComments, convertedComments);
    }

    private void mergeFileContents(ArrayList<Code> codes, ArrayList<NonDocumentationComments> nonDocumentationComments, ArrayList<DoxygenStyleDocumentationComment> convertedComments) {
        throw new UnsupportedOperationException();
    }

    private ArrayList<DoxygenStyleDocumentationComment> convertComments(ArrayList<StandardStyleDocumentationComment> comments) {
        throw new UnsupportedOperationException();
    }
}
