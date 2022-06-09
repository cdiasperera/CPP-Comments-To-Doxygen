package Core.Convertor.FileContentTypes.DocumentationComments;

public class DoxygenStyleDocumentationComment extends DocumentationComment {
    public DoxygenStyleDocumentationComment(String content) {
        super(content);
    }

    @Override
    public DoxygenStyleDocumentationComment generateConvertedComment() {
        throw new UnsupportedOperationException();
    }
}
