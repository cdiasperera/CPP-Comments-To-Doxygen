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
        extractDocElements();
    }

    private void extractDocElements() {
        throw new UnsupportedOperationException();
    }

    public abstract DocumentationComment generateConvertedComment();
}
