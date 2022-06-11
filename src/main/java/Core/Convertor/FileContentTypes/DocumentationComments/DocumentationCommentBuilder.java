package Core.Convertor.FileContentTypes.DocumentationComments;

import Core.Convertor.FileContentTypes.DocumentationComments.Elements.Param;
import Core.Convertor.FileContentTypes.DocumentationComments.Elements.Return;
import Core.Convertor.FileContentTypes.DocumentationComments.Elements.Summary;

import java.util.ArrayList;

public class DocumentationCommentBuilder {
    ArrayList<Param> params;
    Return aReturn;
    Summary summary;
    String content;
    public DocumentationCommentBuilder addParams(ArrayList<Param> params) {
        this.params = params;
        return this;
    }

    public DocumentationCommentBuilder addReturn(Return aReturn) {
        this.aReturn = aReturn;
        return this;
    }

    public DocumentationCommentBuilder addSummary(Summary summary) {
        this.summary = summary;
        return this;
    }

    public StandardStyleDocumentationComment buildSSDocumentationComment() {
        return new StandardStyleDocumentationComment(content, params, aReturn, summary);
    }

    public DoxygenStyleDocumentationComment buildDoxygenStyleDocumentationComment() {
        return new DoxygenStyleDocumentationComment(content, params, aReturn, summary);
    }

    public DocumentationCommentBuilder addContent(String content) {
        this.content = content;
        return this;
    }
}
