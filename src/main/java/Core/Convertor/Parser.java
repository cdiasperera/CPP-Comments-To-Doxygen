package Core.Convertor;

import Core.Convertor.FileContentTypes.Code;
import Core.Convertor.FileContentTypes.DocumentationComments.DocumentationComment;
import Core.Convertor.FileContentTypes.DocumentationComments.DoxygenStyleDocumentationComment;
import Core.Convertor.FileContentTypes.DocumentationComments.StandardStyleDocumentationComment;
import Core.Convertor.FileContentTypes.FileContent;
import Core.Convertor.FileContentTypes.NonDocumentationComment;

import java.util.ArrayList;

public class Parser {
    private ArrayList<FileContent> fileContents;
    public Parser(String fileContentsAsString) {
        parse(fileContentsAsString);
    }

    private void parse(String fileContentsAsString) {
        throw new UnsupportedOperationException();
    }

    public ArrayList<Code> getCodes() {
        return getSubListOfSubclass(Code.class);
    }

    public ArrayList<NonDocumentationComment> getNonDocumentationComments() {
        return getSubListOfSubclass(NonDocumentationComment.class);
    }

    public ArrayList<DocumentationComment> getStandardStyleDocumentationComments() {
        var comments = getSubListOfSubclass(StandardStyleDocumentationComment.class);

        return new ArrayList<>(comments);
    }

    public ArrayList<DocumentationComment> getDoxygenStyleDocumentationComments() {
        var comments = getSubListOfSubclass(DoxygenStyleDocumentationComment.class);

        return new ArrayList<>(comments);
    }
    private <T extends FileContent> ArrayList<T> getSubListOfSubclass(Class<T> clazz) {
        ArrayList<T> subList = new ArrayList<>();

        fileContents.forEach(fileContent -> {
            if (clazz.isInstance(fileContent)) {
                subList.add((T) fileContent);
            }
        });

        return subList;
    }
}
