import java.io.File;

public class FileVerification {
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

    public Integer checkNum(String input) {
        while(true){
            try {
                Integer numberC = Integer.parseInt(input);
                return numberC;}
            catch(Exception e){
                System.out.println("Please Input an integer type");
                break;}
        }
        return 0;
    }
}
