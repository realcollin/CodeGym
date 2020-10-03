package com.codegym.task.task19.task1902;

/* 
Adapter

*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter {

    private FileOutputStream fileOutputStream;

    public AdapterFileOutputStream(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
    }

    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("Data.txt");
        AmigoStringWriter amigoStringWriter = new AdapterFileOutputStream(fileOutputStream);
        amigoStringWriter.writeString("Hello Collin\r\nHow you doing man?");
    }


    @Override
    public void flush() throws IOException {
        this.fileOutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        byte[] bytes = s.getBytes();
        this.fileOutputStream.write(bytes);
    }

    @Override
    public void close() throws IOException {
        this.fileOutputStream.close();
    }
}

