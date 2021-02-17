public class CountVisitor implements Visitor {
    private int fileCount = -1;
    @Override
    public void visit(FileSystem fileSystem) {
        if(fileSystem instanceof File){
            this.fileCount++;
        }
    }

    public void getFileCount() {
        System.out.println("The total number of files are: "+ this.fileCount);
    }
}
