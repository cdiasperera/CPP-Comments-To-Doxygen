package Core.Convertor.FileContentTypes.DocumentationComments;

public class DoxygenStyleDocumentationComment extends DocumentationComment {
    public DoxygenStyleDocumentationComment(String content) {
        super(content);
    }

    @Override
    public StandardStyleDocumentationComment generateConvertedComment() {
        return new DocumentationCommentBuilder()
                .addParams(params)
                .addReturn(aReturn)
                .addSummary(summary)
                .buildSSDocumentationComment();
    }
}
