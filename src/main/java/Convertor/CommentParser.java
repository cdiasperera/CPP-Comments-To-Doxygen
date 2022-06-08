package Convertor;

import Convertor.FileContentTypes.Code;
import Convertor.FileContentTypes.DocumentationComments.DocumentationComment;
import Convertor.FileContentTypes.NonDocumentationComment;

import java.util.ArrayList;

public class CommentParser {
    public CommentParser(String toConvert) {
        throw new UnsupportedOperationException();
    }
    public ArrayList<Code> getCodes() {
        throw new UnsupportedOperationException();
    }

    public ArrayList<NonDocumentationComment> getNonDocumentationComments() {
        throw new UnsupportedOperationException();
    }

    public ArrayList<DocumentationComment> getStandardStyleDocumentationComments() {
        throw new UnsupportedOperationException();
    }

    public ArrayList<DocumentationComment> getDoxygenStyleDocumentationComments() {
        throw new UnsupportedOperationException();
    }
}
