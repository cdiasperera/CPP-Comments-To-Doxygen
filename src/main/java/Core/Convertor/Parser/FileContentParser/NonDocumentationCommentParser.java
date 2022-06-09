package Core.Convertor.Parser.FileContentParser;

import Core.Convertor.FileContentTypes.FileContent;

public class NonDocumentationCommentParser extends FileContentParser {
    @Override
    public FileContent parse(String copy) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getContentAfterParsing(String copy) {
        throw new UnsupportedOperationException();
    }
}
