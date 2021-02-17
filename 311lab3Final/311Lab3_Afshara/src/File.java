import java.time.LocalTime;

public class File extends FileSystem implements Visitable{
    String fileName;
    int fileSize;
    LocalTime fileCreationDate;

    public File(String newFileName, int newFileSize, LocalTime newFileCreationDate){
        fileName = newFileName;
        fileSize = newFileSize;
        fileCreationDate = newFileCreationDate;
    }

    //filename with extension
    public String getFileName() {
        return fileName;
    }

    //file size of the file
    public int getFileSize() {
        return fileSize;
    }

    //creation date
    public LocalTime getFileCreationDate() {
        return fileCreationDate;
    }

    public void displayFileInfo(){
        System.out.println(getFileName() + " " + getFileSize() + " " + getFileCreationDate() +"\n");
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
