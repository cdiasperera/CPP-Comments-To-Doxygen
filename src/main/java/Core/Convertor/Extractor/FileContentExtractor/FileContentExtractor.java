package Core.Convertor.Extractor.FileContentExtractor;

import Core.Convertor.FileContentTypes.FileContent;

import java.util.Scanner;

public abstract class FileContentExtractor {
    public static FileContentExtractor[] getAllExtractors() {
        return new FileContentExtractor[]{
                new CodeExtractor(),
                new NonDocumentationCommentExtractor(),
                new DoxygenStyleDocumentationCommentExtractor(),
                new StandardStyleDocumentationCommentExtractor()
        };
    }

    public FileContent extractor(String copy) {
        Scanner scanner = new Scanner(copy);

        StringBuilder sb = new StringBuilder();

        while (scanner.hasNextLine()) {
            String currLine = scanner.nextLine();
            if (!endsExtractedItem(currLine)) {
                sb.append(currLine).append("\n");
            } else {
                break;
            }
        }

        return constructFileContent(sb.toString());
    }

    protected abstract FileContent constructFileContent(String fileContentAsString);

    protected abstract boolean endsExtractedItem(String currLine);

    public String getContentAfterExtraction(String copy) {
        Scanner scanner = new Scanner(copy);

        StringBuilder sb = new StringBuilder();

        while (scanner.hasNextLine()) {
            String currLine = scanner.nextLine();
            if(endsExtractedItem(currLine)) {
                sb.append(currLine).append("\n");
                break;
            }
        }
        scanner.useDelimiter("\\A");
        sb.append(scanner.hasNext() ? scanner.next() : "");
        return sb.toString();
    }
}
