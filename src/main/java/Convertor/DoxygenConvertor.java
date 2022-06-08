package Convertor;

import Convertor.FileContentTypes.DocumentationComments.DocumentationComment;

import java.util.ArrayList;

public class DoxygenConvertor extends Convertor {
    @Override
    protected ArrayList<DocumentationComment> getDocumentationComments() {
        CommentParser parser = new CommentParser(toConvert);

        return parser.getDoxygenStyleDocumentationComments();
    }
}