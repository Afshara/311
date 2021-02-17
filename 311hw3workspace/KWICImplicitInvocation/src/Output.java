import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Output implements Observer {
    private LineStorage lineStorage;
    private Alphabetizer alphabetizer;
    Scanner scanner = new Scanner(System.in);

    public Output(Alphabetizer alphabetizer){
        this.lineStorage = alphabetizer.getLineStorage();
        alphabetizer.register(this);
    }

    public void outputLines(LineStorage lineStorage) throws FileNotFoundException, UnsupportedEncodingException {
        if(lineStorage.getOuputNow().equals(Boolean.TRUE)){
            System.out.println("Type 'C' for Console Output\n");
            System.out.println("Type 'F' for File Output\n");
            String outputType = scanner.nextLine();

            if(outputType.equals("C")){
                lineStorage.printLineStorage();
            }

            else if(outputType.equals("F")){
                System.out.println("Type your filename\n");
                String filename = scanner.nextLine();
                if(fileExistCheck(filename,"1").equals(Boolean.FALSE)){return;}
                PrintWriter writer = new PrintWriter("./storedFiles/"+filename+".txt", "UTF-8");
                for (String each : lineStorage.getLineStorage()) {writer.println(each);}
                writer.flush();
                writer.close();

            }

            System.out.println("Type 'EXIT' to exit the system\n");
            System.exit(0);
        }
    }

    public Boolean fileExistCheck(String consoleInput,String typeFlag){
        String PATH = "./storedFiles";
        File folder = new File(PATH);
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles.length > 0) {
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile() ) {
                    if (listOfFiles[i].getName().equals(consoleInput+".txt")){
                        if(typeFlag.equals("1")){System.out.println("File name is already taken");}
                        return Boolean.FALSE;}}}}
        return Boolean.TRUE;}

        //Observer
    @Override
    public void update(Event e) throws FileNotFoundException, UnsupportedEncodingException {
        this.lineStorage = e.getLineStorage();
        outputLines(lineStorage);

    }

}
