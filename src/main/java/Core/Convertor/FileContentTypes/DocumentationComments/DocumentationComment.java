package Core.Convertor.FileContentTypes.DocumentationComments;

import Core.Convertor.FileContentTypes.DocumentationComments.Elements.Param;
import Core.Convertor.FileContentTypes.DocumentationComments.Elements.Return;
import Core.Convertor.FileContentTypes.DocumentationComments.Elements.Summary;
import Core.Convertor.FileContentTypes.FileContent;

import java.util.ArrayList;

public abstract class DocumentationComment extends FileContent {
    protected ArrayList<Param> params;
    protected Return aReturn;
    protected Summary summary;

    public DocumentationComment(String content) {
        super(content);
        parseDocElements();
    }

    public DocumentationComment(String content, ArrayList<Param> params, Return aReturn, Summary summary) {
        super(content);
        this.params = params;
        this.aReturn = aReturn;
        this.summary = summary;
    }

    protected abstract void parseDocElements();

    public abstract DocumentationComment generateConvertedComment();
}
