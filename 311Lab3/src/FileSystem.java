import java.time.LocalTime;

public abstract class FileSystem {
    public void add(FileSystem newFileSystem) {
        throw new UnsupportedOperationException();
    }
    public String getFileName() {
        throw new UnsupportedOperationException();
    }


    public int getFileSize() {
        throw new UnsupportedOperationException();
    }

    public LocalTime getFileCreationDate() {
        throw new UnsupportedOperationException();
    }


    public void displayFileInfo() {
        throw new UnsupportedOperationException();
    }

    public void accept(Visitor visitor) {
    }

}
