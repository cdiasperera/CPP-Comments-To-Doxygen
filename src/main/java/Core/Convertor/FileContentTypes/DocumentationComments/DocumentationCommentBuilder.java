package Core.Convertor.FileContentTypes.DocumentationComments;

import Core.Convertor.FileContentTypes.DocumentationComments.Elements.Param;
import Core.Convertor.FileContentTypes.DocumentationComments.Elements.Return;
import Core.Convertor.FileContentTypes.DocumentationComments.Elements.Summary;

import java.util.ArrayList;

public class DocumentationCommentBuilder {
    public DocumentationCommentBuilder addParams(ArrayList<Param> params) {
        throw new UnsupportedOperationException();
    }

    public DocumentationCommentBuilder addReturn(Return aReturn) {
        throw new UnsupportedOperationException();
    }

    public DocumentationCommentBuilder addSummary(Summary summary) {
        throw new UnsupportedOperationException();
    }

    public StandardStyleDocumentationComment buildSSDocumentationComment() {
        throw new UnsupportedOperationException();
    }

    public DoxygenStyleDocumentationComment buildDoxygenStyleDocumentationComment() {
       throw new UnsupportedOperationException();
    }
}
