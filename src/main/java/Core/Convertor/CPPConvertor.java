package Core.Convertor;

import Core.Convertor.FileContentTypes.DocumentationComments.DocumentationComment;
import Core.Convertor.Parser.FileParser;

import java.util.ArrayList;

public class CPPConvertor extends Convertor {
    @Override
    protected ArrayList<DocumentationComment> getDocumentationComments() {
        FileParser fileParser = new FileParser(toConvert);

        return fileParser.getStandardStyleDocumentationComments();
    }
}
