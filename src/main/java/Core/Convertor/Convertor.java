package Core.Convertor;

import Core.Convertor.FileContentTypes.Code;
import Core.Convertor.FileContentTypes.DocumentationComments.DocumentationComment;
import Core.Convertor.FileContentTypes.FileContent;
import Core.Convertor.FileContentTypes.NonDocumentationComment;
import Core.Convertor.Parser.FileParser;
import Core.Exceptions.ConvertorNoStringException;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class Convertor {
    String toConvert = null;
    String convertedString = null;
    public void setStringToConvert(String toConvert) {
        this.toConvert = toConvert;
    }

    public String getConvertedString() throws ConvertorNoStringException{
        if (convertedString != null) {
            return convertedString;
        }

        // Need to convert string
        if (toConvert == null) {
            throw new ConvertorNoStringException("No string to convert");
        }

        convertedString = convertString();

        return convertedString;
    }

    public void setToConvert(String toConvert) {
        this.toConvert = toConvert;
        this.convertedString = null;
    }

    private String convertString() {
        FileParser fileParser = new FileParser(toConvert);

        // Extract file contents
        ArrayList<DocumentationComment> comments = getDocumentationComments();
        ArrayList<Code> codes = fileParser.getCodes();
        ArrayList<NonDocumentationComment> nonDocumentationComments = fileParser.getNonDocumentationComments();

        ArrayList<DocumentationComment> convertedComments = convertComments(comments);

        return convertedString = mergeFileContents(codes, nonDocumentationComments, convertedComments);
    }

    protected abstract ArrayList<DocumentationComment> getDocumentationComments();

    private String mergeFileContents(
            ArrayList<Code> codes,
            ArrayList<NonDocumentationComment> nonDocumentationComments,
            ArrayList<DocumentationComment> documentationComments
    ) {
        ArrayList<FileContent> allContent = mergeAndSortContents(codes, nonDocumentationComments, documentationComments);

        return createStringFromContentList(allContent);
    }

    private String createStringFromContentList(ArrayList<FileContent> allContent) {
        StringBuilder sb = new StringBuilder();
        allContent.forEach(fileContent -> sb.append(fileContent.getContentAsString()));

        return sb.toString();
    }

    /**
     * @param codes The code content in the file
     * @param nonDocumentationComments The non-docu comments in the file
     * @param documentationComments The docu comments in the file
     * @return The array list of file contents for the file, sorted by the position they appear in the file
     */
    private ArrayList<FileContent> mergeAndSortContents(ArrayList<Code> codes, ArrayList<NonDocumentationComment> nonDocumentationComments, ArrayList<DocumentationComment> documentationComments) {
        ArrayList<FileContent> allContent = new ArrayList<>();

        allContent.addAll(codes);
        allContent.addAll(nonDocumentationComments);
        allContent.addAll(documentationComments);

        allContent.sort(Comparator.comparingInt(FileContent::getPosition));
        return allContent;
    }

    private ArrayList<DocumentationComment> convertComments(ArrayList<DocumentationComment> comments) {
        ArrayList<DocumentationComment> convertedComments = new ArrayList<>();

        comments.forEach(comment -> convertedComments.add(
                comment.generateConvertedComment()
        ));

        return convertedComments;
    }
}
