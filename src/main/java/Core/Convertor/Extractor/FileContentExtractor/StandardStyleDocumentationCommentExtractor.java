package Core.Convertor.Extractor.FileContentExtractor;

import Core.Convertor.FileContentTypes.DocumentationComments.StandardStyleDocumentationComment;
import Core.Convertor.FileContentTypes.FileContent;

public class StandardStyleDocumentationCommentExtractor extends FileContentExtractor {
    private boolean insideComment = false;
    @Override
    protected FileContent constructFileContent(String fileContentAsString) {
        return new StandardStyleDocumentationComment(fileContentAsString);
    }

    @Override
    protected boolean endsParsedItem(String currLine) {
        // Check if we have opened a comment.
        if (currLine.matches("\s*/\\*\\*.*")) {
            insideComment = true;
            return false;
        }

        // Check if we have closed a comment. We are still technically inside a comment, even if true.
        if (currLine.matches("\s*\\*/.*")) {
            insideComment = false;
            return false;
        }

        return !insideComment;

    }

}
