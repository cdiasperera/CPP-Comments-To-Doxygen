package Core.Convertor.Extractor.FileContentExtractor;

import Core.Convertor.FileContentTypes.DocumentationComments.DoxygenStyleDocumentationComment;
import Core.Convertor.FileContentTypes.FileContent;

public class DoxygenStyleDocumentationCommentExtractor extends FileContentExtractor {
    @Override
    protected FileContent constructFileContent(String fileContentAsString) {
        return new DoxygenStyleDocumentationComment(fileContentAsString);
    }

    @Override
    protected boolean endsParsedItem(String currLine)  {
        return !currLine.matches("\s*///.*");
    }

}
