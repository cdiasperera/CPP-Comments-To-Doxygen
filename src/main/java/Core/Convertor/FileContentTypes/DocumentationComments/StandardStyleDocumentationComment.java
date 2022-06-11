package Core.Convertor.FileContentTypes.DocumentationComments;

public class StandardStyleDocumentationComment extends DocumentationComment {
    public StandardStyleDocumentationComment(String content) {
        super(content);
    }

    @Override
    public DoxygenStyleDocumentationComment generateConvertedComment() {
        return new DocumentationCommentBuilder()
                .addParams(params)
                .addReturn(aReturn)
                .addSummary(summary)
                .buildDoxygenStyleDocumentationComment();
    }
}
