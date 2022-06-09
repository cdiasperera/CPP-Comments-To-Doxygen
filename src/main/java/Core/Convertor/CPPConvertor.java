package Core.Convertor;

import Core.Convertor.FileContentTypes.DocumentationComments.DocumentationComment;

import java.util.ArrayList;

public class CPPConvertor extends Convertor {
    @Override
    protected ArrayList<DocumentationComment> getDocumentationComments() {
        Parser parser = new Parser(toConvert);

        return parser.getStandardStyleDocumentationComments();
    }
}
