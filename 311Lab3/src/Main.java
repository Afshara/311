import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
	// write your code here
        FileSystem directA = new Folder("DirectA", LocalTime.now());
        FileSystem directB = new Folder("DirectB",LocalTime.now());
        FileSystem directC = new Folder("DirectC",LocalTime.now());
        FileSystem directD = new Folder("DirectD",LocalTime.now());
        FileSystem directE = new Folder("DirectE",LocalTime.now());
        FileSystem directF = new Folder("DirectF",LocalTime.now());
        FileSystem directG = new Folder("DirectG",LocalTime.now());
        FileSystem directH = new Folder("DirectH",LocalTime.now());
        FileSystem directI = new Folder("DirectI",LocalTime.now());
        FileSystem directJ = new Folder("DirectJ",LocalTime.now());


        FileSystem everyFile = new Folder("FileList",LocalTime.now());

        //Level1 every>A
        everyFile.add(directA);
        directA.add(new File("file1",50,LocalTime.now()));
        directA.add(new File("file2",50,LocalTime.now()));
        directA.add(new File("file3",50,LocalTime.now()));

        //level2 every>A>C
        directA.add(directC);
        directC.add(new File("file4",50,LocalTime.now()));
        directC.add(new File("file5",50,LocalTime.now()));

        //Level1 every>B
        everyFile.add(directB);
        directB.add(new File("file6",50,LocalTime.now()));
        directB.add(new File("file7",50,LocalTime.now()));

        //Level1 every>D
        everyFile.add(directD);
        directD.add(new File("file8",50,LocalTime.now()));
        directD.add(new File("file9",50,LocalTime.now()));

        //level3 every>A>C>E
        directC.add(directE);
        directE.add(new File("file10",50,LocalTime.now()));
        directE.add(new File("file11",50,LocalTime.now()));

        //level2 every>A>F
        directA.add(directF);
        directF.add(new File("file11",50,LocalTime.now()));
        directF.add(new File("file12",50,LocalTime.now()));

        //Level1 every>G
        everyFile.add(directG);
        directG.add(new File("file13",50,LocalTime.now()));
        directG.add(new File("file14",50,LocalTime.now()));

        //Level1 every>H
        everyFile.add(directH);
        directH.add(new File("file15",50,LocalTime.now()));
        directH.add(new File("file16",50,LocalTime.now()));

        //level2 every>H>I
        directH.add(directI);
        directI.add(new File("file17",50,LocalTime.now()));
        directI.add(new File("file18",50,LocalTime.now()));

        //level2 every>H>J
        directH.add(directJ);
        directJ.add(new File("file17",50,LocalTime.now()));
        directJ.add(new File("file18",50,LocalTime.now()));

        FolderVisitor folderVisitor = new FolderVisitor();
        ((Folder) everyFile).accept(folderVisitor);
        CountVisitor countVisitor = new CountVisitor();
        everyFile.accept(countVisitor);
        countVisitor.getFileCount();
        DateVisitor dateVisitor = new DateVisitor();
        everyFile.accept(dateVisitor);
        dateVisitor.getEarliestFile();

    }
}
