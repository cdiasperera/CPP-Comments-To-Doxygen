package Convertor.FileContentTypes.DocumentationComments;

import Convertor.FileContentTypes.FileContent;

public abstract class DocumentationComment extends FileContent {
    public abstract DoxygenStyleDocumentationComment generateConvertedComment();
}
