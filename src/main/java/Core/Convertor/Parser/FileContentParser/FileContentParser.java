package Core.Convertor.Parser.FileContentParser;

import Core.Convertor.FileContentTypes.FileContent;

public abstract class FileContentParser {
    public static FileContentParser[] getAllParsers() {
        return new FileContentParser[]{
                new CodeParser(),
                new NonDocumentationCommentParser(),
                new DoxygenStyleDocumentationCommentParser(),
                new StandardStyleDocumentationCommentParser()
        };
    }

    public abstract FileContent parse(String copy);

    public abstract String getContentAfterParsing(String copy);
}
