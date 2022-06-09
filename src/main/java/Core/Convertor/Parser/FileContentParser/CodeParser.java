package Core.Convertor.Parser.FileContentParser;

import Core.Convertor.FileContentTypes.Code;
import Core.Convertor.FileContentTypes.FileContent;

public class CodeParser extends FileContentParser {

    @Override
    protected FileContent constructFileContent(String fileContentAsString) {
        return new Code(fileContentAsString);
    }

    @Override
    protected boolean endsParsedItem(String currLine) {
        return currLine.matches("\s*//.*") || currLine.matches("\s*/\\*\\*.*");
    }
}
