import java.time.LocalTime;
import java.util.ArrayList;

public class Folder extends FileSystem implements Visitable{
    ArrayList<FileSystem> fileComponents = new ArrayList<FileSystem>();

    String folderName;
    LocalTime folderCreationDate;

    public Folder(String newFolderName, LocalTime newFolderCreationDate){
        folderName = newFolderName;
        folderCreationDate= newFolderCreationDate;
    }

    public String getFolderName() { return folderName; }

    public LocalTime getFolderCreationDate() { return folderCreationDate; }

    public void add(FileSystem newFileSytem) {
        fileComponents.add(newFileSytem);
    }

//    public void remove(FileSystem newFileSytem) {
//        fileComponents.remove(newFileSytem);
//    }
//
//    public FileSystem getComponent(int componentIndex) {
//        return (FileSystem) fileComponents.get(componentIndex);
//    }

    //implement--> print out the fileSystem in a readle format
    public void displayFileInfo(){
        System.out.println(getFolderName() + " " + getFolderCreationDate() + "\n");
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for(FileSystem file: fileComponents){
            file.accept(visitor);
        }
    }
}
