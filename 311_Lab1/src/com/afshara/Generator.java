package com.afshara;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Generator extends Filter {

    public Generator(Pipe input_, Pipe output_) {
        super(input_, output_);
    }

    @Override
    protected void transform() {
        BufferedReader reader;
        try {
            //reader = new BufferedReader(new FileReader("C:\\Users\\Owner\\IdeaProjects\\311_Lab1\\src\\com\\afshara\\TestFile.txt"));
            reader = new BufferedReader(new FileReader(
                    "./TestFile.txt"));
            String line = reader.readLine();
            while (line != null) {
                output_.put(line);
                line = reader.readLine();
            }
            output_.put(null);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
