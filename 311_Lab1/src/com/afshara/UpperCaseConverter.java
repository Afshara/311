package com.afshara;

import java.io.*;

//An UpperCaseConverter that transforms all the lines in the pipe to uppercase, and
//prints the converted lines to the screen and a file.
public class UpperCaseConverter extends Filter{

    public UpperCaseConverter(Pipe input_, Pipe output_) {
        super(input_, output_);
    }

    @Override
    protected void transform() throws InterruptedException, IOException {
        //File file = new File("./ReturnFile.txt");
       FileWriter writer = new FileWriter("Return.txt",true);
        String line =(String) input_.get();
        while(line!=null){
            writer.write(line.toUpperCase());
            writer.write("\n");
            System.out.println(line.toUpperCase());
            writer.flush();
            line = (String) input_.get();
        }
        writer.close();
    }
}
