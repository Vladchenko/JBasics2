package ru.tinyprogs.buffereddemo;

import java.io.*;

/**
 * Demo of reading a file with or without a buffer.
 */
public final class BufferDemo {

    public void runBufferedNoBufferedComparisonDemo() {
        File file = new File("Some.pdf");   //Put this file a project root directory.
        verifyFile(file);

        Stopwatch stopwatch = new Stopwatch();
        // One could use org.apache.commons.lang.time.StopWatch instead of the above one.

        stopwatch.start();
        readWithBuffer(file);
        stopwatch.stop();
        System.out.println("With buffering: " + stopwatch.getElapsedTime());

        stopwatch.start();
        readWithoutBuffer(file);
        stopwatch.stop();
        System.out.println("Without buffering: " + stopwatch.getElapsedTime());

        // Sample output:
//            With buffering: 138
//            Without buffering: 206
    }

    /**
     * @param file is a file which already exists and can be read.
     */
    static public void readWithBuffer(File file) {
        try (Reader input = new BufferedReader(new FileReader(file))){
            int data = 0;
            while ((data = input.read()) != -1){
                //do nothing
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @param file is an existing file which can be read.
     */
    static public void readWithoutBuffer(File file) {
        try (Reader input = new FileReader(file)){
            int data = 0;
            while ((data = input.read()) != -1){
                //do nothing
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private static void verifyFile(File file) {
        if (file == null) {
            throw new IllegalArgumentException("File should not be null.");
        }
        if (!file.exists()) {
            throw new IllegalArgumentException ("File does not exist: " + file);
        }
        if (!file.isFile()) {
            throw new IllegalArgumentException("Should not be a directory: " + file);
        }
        if (!file.canWrite()) {
            throw new IllegalArgumentException("File cannot be written: " + file);
        }
    }
}
