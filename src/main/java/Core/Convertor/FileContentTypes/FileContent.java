package Core.Convertor.FileContentTypes;

public abstract class FileContent {
    /**
     * This is the position of content, in the file it was extracted from.
     */
    protected int position;

    protected final String content;

    public FileContent(String content) {
        this.content = content;
    }

    public int getPosition() {
        return position;
    }

    public String getContentAsString() {
        return content;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
