package Core.Convertor.Parser.FileContentParser;

import Core.Convertor.FileContentTypes.DocumentationComments.StandardStyleDocumentationComment;
import Core.Convertor.FileContentTypes.FileContent;

public class StandardStyleDocumentationCommentParser extends FileContentParser {
    @Override
    protected FileContent constructFileContent(String fileContentAsString) {
        return new StandardStyleDocumentationComment(fileContentAsString);
    }

    @Override
    protected boolean endsParsedItem(String currLine) {
        throw new UnsupportedOperationException();
    }

}
