package Core.Convertor.Extractor.FileContentExtractor;

import Core.Convertor.FileContentTypes.FileContent;
import Core.Convertor.FileContentTypes.NonDocumentationComment;

public class NonDocumentationCommentExtractor extends FileContentExtractor {
    private boolean commentAlreadyParsed = false;
    @Override
    protected FileContent constructFileContent(String fileContentAsString) {
        return new NonDocumentationComment(fileContentAsString);
    }

    @Override
    protected boolean endsParsedItem(String currLine) {
        if (commentAlreadyParsed) {
            return true;
        }

        if (currLine.matches("\s*//\s.*")) {
            commentAlreadyParsed = true;
            return false;
        } else {
            return true;
        }
    }
}
