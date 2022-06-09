package Core.Convertor.FileContentTypes.DocumentationComments;

import Core.Convertor.FileContentTypes.FileContent;

public abstract class DocumentationComment extends FileContent {
    public abstract DoxygenStyleDocumentationComment generateConvertedComment();
}
