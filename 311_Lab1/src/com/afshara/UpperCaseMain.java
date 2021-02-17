package com.afshara;

public class UpperCaseMain {

    public static void main(String args[]) {
        //Creat a pipe between a Generator and Filter
        Pipe pipe = new PipeImpl();

        //create the Generator and Filter
        Generator generator = new Generator(null,pipe);
        UpperCaseConverter upperCaseConverter = new UpperCaseConverter(pipe,null);

        //start the generator and the filter
        generator.start();
        upperCaseConverter.start();
    }
}
