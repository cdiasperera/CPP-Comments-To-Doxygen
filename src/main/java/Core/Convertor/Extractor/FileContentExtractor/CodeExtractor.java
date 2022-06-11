package Core.Convertor.Extractor.FileContentExtractor;

import Core.Convertor.FileContentTypes.Code;
import Core.Convertor.FileContentTypes.FileContent;

public class CodeExtractor extends FileContentExtractor {

    @Override
    protected FileContent constructFileContent(String fileContentAsString) {
        return new Code(fileContentAsString);
    }

    @Override
    protected boolean endsParsedItem(String currLine) {
        return currLine.matches("\s*//.*") || currLine.matches("\s*/\\*\\*.*");
    }
}
