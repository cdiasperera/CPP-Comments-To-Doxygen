package Core.Convertor.Parser.FileContentParser;

import Core.Convertor.FileContentTypes.FileContent;

import java.util.Scanner;

public abstract class FileContentParser {
    public static FileContentParser[] getAllParsers() {
        return new FileContentParser[]{
                new CodeParser(),
                new NonDocumentationCommentParser(),
                new DoxygenStyleDocumentationCommentParser(),
                new StandardStyleDocumentationCommentParser()
        };
    }

    public FileContent parse(String copy) {
        Scanner scanner = new Scanner(copy);

        StringBuilder sb = new StringBuilder();

        while (scanner.hasNextLine()) {
            String currLine = scanner.nextLine();
            if (!endsParsedItem(currLine)) {
                sb.append(currLine).append("\n");
            } else {
                break;
            }
        }

        return constructFileContent(sb.toString());
    }

    protected abstract FileContent constructFileContent(String fileContentAsString);

    protected abstract boolean endsParsedItem(String currLine);

    public String getContentAfterParsing(String copy) {
        Scanner scanner = new Scanner(copy);

        StringBuilder sb = new StringBuilder();

        while (scanner.hasNextLine()) {
            String currLine = scanner.nextLine();
            if(endsParsedItem(currLine)) {
                sb.append(currLine).append("\n");
                break;
            }
        }
        scanner.useDelimiter("\\A");
        sb.append(scanner.hasNext() ? scanner.next() : "");
        return sb.toString();
    }
}
