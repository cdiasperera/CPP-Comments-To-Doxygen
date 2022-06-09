package Core.Convertor.FileContentTypes.DocumentationComments;

import Core.Convertor.FileContentTypes.FileContent;

public abstract class DocumentationComment extends FileContent {
    public DocumentationComment(String content) {
        super(content);
    }

    public abstract DoxygenStyleDocumentationComment generateConvertedComment();
}
