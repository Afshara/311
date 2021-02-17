import java.time.LocalTime;

public class DateVisitor implements Visitor {
    private LocalTime earliestDate = LocalTime.now();
    private String fileName = "";
    @Override
    public void visit(FileSystem fileSystem) {
        if(fileSystem instanceof File){
            if(((File) fileSystem).fileCreationDate.isBefore(this.earliestDate)){
                this.earliestDate = ((File) fileSystem).fileCreationDate;
                this.fileName = ((File) fileSystem).fileName;
            }
        }
    }

    public void getEarliestFile() {
        System.out.println("The earliest file is : " + this.fileName + " at dateTime: " + this.earliestDate);
    }
}
