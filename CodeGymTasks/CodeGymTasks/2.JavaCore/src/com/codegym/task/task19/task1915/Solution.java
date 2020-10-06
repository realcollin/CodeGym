package com.codegym.task.task19.task1915;

/* 
Duplicate text

*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {

        // read a file name from te console
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());

        // close BufferedReader object
        reader.close();

        //Save the current PrintStream in a special variable
        PrintStream console = System.out;

        // Create a dynamic array
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // create an adapter for the PrintStream class
        PrintStream printStream = new PrintStream(outputStream);

        //Set it as the current System.out
        System.setOut(printStream);

        //Call a function that knows nothing about our changes
        testString.printSomething();

        //Convert the data written to our ByteArray into a string
        String result = outputStream.toString();

        //Put everything back to the way it was
        System.setOut(console);


        //Output it to the console
        System.out.println(result);
        byte[] bytesString = result.getBytes();
        fileOutputStream.write(bytesString);

        // close FileOutPutStream object
        fileOutputStream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("This is text for testing");
        }
    }
}

