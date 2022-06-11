package Core.Convertor.FileContentTypes.DocumentationComments;

import Core.Convertor.FileContentTypes.DocumentationComments.Elements.Param;
import Core.Convertor.FileContentTypes.DocumentationComments.Elements.Return;
import Core.Convertor.FileContentTypes.DocumentationComments.Elements.Summary;

import java.util.ArrayList;

public class StandardStyleDocumentationComment extends DocumentationComment {
    public StandardStyleDocumentationComment(String content) {
        super(content);
    }

    public StandardStyleDocumentationComment(String content, ArrayList<Param> params, Return aReturn, Summary summary) {
        super(content, params, aReturn, summary);
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
