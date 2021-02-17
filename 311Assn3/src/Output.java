import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Output extends EventController {

    FileVerification fileVerification = new FileVerification();

    public void stringOutput(String printString){System.out.println(printString);}

    //Output to File
    public void getOutput(LineStorage readyToOutput, String consoleInput) throws FileNotFoundException, UnsupportedEncodingException {
        if(fileVerification.fileExistCheck(consoleInput,"1").equals(Boolean.FALSE)){return;}
        PrintWriter writer = new PrintWriter("./storedFiles/"+consoleInput+".txt", "UTF-8");
        for (String each : readyToOutput.getLineStorage()) {writer.println(each);}
        writer.flush();
        writer.close();}

    //Output to Console
    public void getOutput(LineStorage readyToOutput) {
        for (String each : readyToOutput.getLineStorage()){stringOutput(each);}
    }

}
