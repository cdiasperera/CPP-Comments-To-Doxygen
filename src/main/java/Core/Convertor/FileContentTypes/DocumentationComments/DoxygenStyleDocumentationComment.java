package Core.Convertor.FileContentTypes.DocumentationComments;

import Core.Convertor.FileContentTypes.DocumentationComments.Elements.Param;
import Core.Convertor.FileContentTypes.DocumentationComments.Elements.Return;
import Core.Convertor.FileContentTypes.DocumentationComments.Elements.Summary;

import java.util.ArrayList;

public class DoxygenStyleDocumentationComment extends DocumentationComment {
    public DoxygenStyleDocumentationComment(String content) {
        super(content);
    }

    public DoxygenStyleDocumentationComment(String content, ArrayList<Param> params, Return aReturn, Summary summary) {
        super(content, params, aReturn, summary);
    }

    @Override
    public StandardStyleDocumentationComment generateConvertedComment() {
        return new DocumentationCommentBuilder()
                .addContent(content)
                .addParams(params)
                .addReturn(aReturn)
                .addSummary(summary)
                .buildSSDocumentationComment();
    }
}
