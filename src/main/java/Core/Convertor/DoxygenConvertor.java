package Core.Convertor;

import Core.Convertor.FileContentTypes.DocumentationComments.DocumentationComment;
import Core.Convertor.Extractor.FileExtractor;

import java.util.ArrayList;

public class DoxygenConvertor extends Convertor {
    @Override
    protected ArrayList<DocumentationComment> getDocumentationComments() {
        FileExtractor fileExtractor = new FileExtractor(toConvert);

        return fileExtractor.getDoxygenStyleDocumentationComments();
    }
}
