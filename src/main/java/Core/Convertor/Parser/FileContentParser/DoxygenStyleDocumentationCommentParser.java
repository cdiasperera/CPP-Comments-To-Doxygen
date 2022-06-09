package Core.Convertor.Parser.FileContentParser;

import Core.Convertor.FileContentTypes.DocumentationComments.DoxygenStyleDocumentationComment;
import Core.Convertor.FileContentTypes.FileContent;

public class DoxygenStyleDocumentationCommentParser extends FileContentParser {
    @Override
    protected FileContent constructFileContent(String fileContentAsString) {
        return new DoxygenStyleDocumentationComment(fileContentAsString);
    }

    @Override
    protected boolean endsParsedItem(String currLine)  {
        throw new UnsupportedOperationException();
    }

}
