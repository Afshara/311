public class FolderVisitor implements Visitor{
    @Override
    public void visit(FileSystem fileSystem) {
        fileSystem.displayFileInfo();
    }

}
