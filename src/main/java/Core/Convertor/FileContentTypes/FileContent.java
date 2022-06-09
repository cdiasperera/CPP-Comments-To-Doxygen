package Core.Convertor.FileContentTypes;

public abstract class FileContent {
    /**
     * This is the position of content, in the file it was extracted from.
     */
    private int position;

    public int getPosition() {
        return position;
    }

    public String getContentAsString() {
        throw new UnsupportedOperationException();
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
