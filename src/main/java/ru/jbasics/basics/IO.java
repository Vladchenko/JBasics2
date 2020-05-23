/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.basics;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author v.yanchenko
 */
public class IO {

    public IO() {
        IO.Files_ iof = new Files_();
//        IO.Keyboard iok = new Keyboard();
    }

    public class Files_ {

        Logger logger = Logger.getLogger(this.getClass().getName());

//        http://docs.oracle.com/javase/tutorial/essential/io
        String strSourceFile = "user/files/fileSource.txt";
        String strDestFile = "user/files/fileDestination.txt";

        public Files_() {

//            try {
//                copyFile3(strSourceFile, strDestFile);
//            bufferedReader();
//            } catch (IOException ex) {
//                Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            readAndPrintFile2();
//        fileInputStreamDemo();
//        fileOutputStreamDemo();
//            inputStreamReaderDemo();
//            outputStreamWriterDemo();
//            readWithScanner(strSourceFile);
            checkFilePresence();
        }

        /**
         * Method creates a file with a random name, checks its presence and deletes it.
         */
        public void checkFilePresence() {
            File newFile = new File(Integer.toString(new Random().nextInt()));
            String f = (newFile.exists()) ? " exists" : " doesn't exist";
            System.out.println("File " + newFile.toString() + (newFile.exists() ? " exists" : " doesn't exist"));
            try {
                if (newFile.createNewFile()) {
                    System.out.println("File " + newFile + " has been created.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("File " + newFile.toString() + (newFile.exists() ? " exists" : " doesn't exist"));
            if (newFile.delete()) {
                System.out.println("File " + newFile + " has been deleted.");
            }
            System.out.println("File " + newFile.toString() + (newFile.exists() ? " exists" : " doesn't exist"));
        }

        // BYTE STREAMS
        // Copying one file to another.
        /*
         Reading each byte from a SourceFile and writing it to DestFile, 
         using FileInputStream (byte stream).
        
         This method represents a kind of low-level I/O that you should avoid. 
         Since file contains character data, the best approach is to use 
         character streams. There are also streams for more complicated data 
         types. Byte streams should only be used for the most primitive I/O.
         So why talk about byte streams? Because all other stream types are 
         built on byte streams.
         */
        public void copyFile(String strSourceFile, String strDestFile) {

            /**
             * Для считывания данных из файла предназначен класс
             * FileInputStream, который является наследником класса InputStream
             * и поэтому реализует все его методы.
             */
            // Instantiating a fileStreams
            FileInputStream in = null;
            FileOutputStream out = null;
            try {
                try {
                    in = new FileInputStream(strSourceFile);
                } catch (FileNotFoundException ex) {
                    System.out.println("Source file troubled");
                }
                try {
                    out = new FileOutputStream(strDestFile);
                } catch (FileNotFoundException ex) {
                    System.out.println("Destination file troubled");
                }
                int c;
                try {
                    while ((c = in.read()) != -1) {
                        out.write(c);
                    }
//                Slightly other way of copying one file to another one
//                while (in.available() > 0) {
//                    out.write(in.read());
//                }
                } catch (IOException ex) {
                    Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
                }
            } finally {
                /* 
                 One needs to close the streams before finishing working with 
                 them. "try" is used here, because file could be being used in 
                 some other thread.
                 */
                try {
                    // Checking for "null", because it somehow could be so, due to
                    // impact of some other thread
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException e) {
                    System.out.println("Failed to close input stream");
                }
                try {
                    if (out != null) {
                        out.close();
                    }
                } catch (IOException e) {
                    System.out.println("Failed to close output stream");
                }
            }

        }

        // Reading from file using Try-with-resources, using FileInputStream.
        public void readFile2(String strSourceFile) {

            /*
             * Try-with-resources in Java 7 is a new exception handling 
             * mechanism that makes it easier to correctly close resources 
             * that are used within a try-catch block.
             */
            try (FileInputStream fin = new FileInputStream(strSourceFile)) {
                System.out.println("File size: " + fin.available() + " bytes");
                int i;
                while ((i = fin.read()) != -1) {
                    System.out.print((char) i);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        // Reading from file using byte array.
        public void readFile3(String strSourceFile) {

            FileInputStream fin = null;

            try {
                fin = new FileInputStream(strSourceFile);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Array of bytes that is to be used to hold the data read from a file
            byte[] buffer = null;

            try {
                // Instantiating a "buffer", having it to be of a file size.
                buffer = new byte[fin.available()];
            } catch (IOException ex) {
                Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                // Reading data from a file to "buffer"
                fin.read(buffer, 0, fin.available());
            } catch (IOException ex) {
                Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("File contents:");
            for (int i = 0; i < buffer.length; i++) {
                System.out.print((char) buffer[i]);
            }
        }

        // Reading from file using "BufferedReader".
        public void bufferedReader() {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(strSourceFile));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Files_.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            }
            int data = 0;
//            try {
//                data = br.read();
//                System.out.print((char) data);
//            } catch (IOException ex) {
//                Logger.getLogger(Files_.class.getName()).log(Level.SEVERE, null, ex);
//            }
            while (data != -1) {
                try {
                    data = br.read();
                    System.out.print((char) data);
                } catch (IOException ex) {
                    Logger.getLogger(Files_.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        // NOT DONE YET
        public Object objectReader() {
            return new Object();
        }

        public void readFile() {
            // reading file line by line in Java 8
            System.out.println("Reading file line by line using Files.lines() in Java 8");
            try {
                //            Files_.lines(Paths.get("manifest.mf"))
//                    .forEach(System.out::println);
//            // You can do even better, you can read all lines
//            // trim them and filter out all empty lines
//            // before printing as shown in following example
//            System.out.println("Doing more things than just reading file using Java 8 Streams");
//            Files_.lines(new File("manifest.mf").toPath())
//                    .map(s - > s.trim())
//                    .filter(s - > !s.isEmpty())
//                    .forEach(System.out::println);
//            // You can also filter line using String methods
//            // e.g. print only lines which starts with "
//            System.out.println("Printing lines which starts with"); 
//            Files_.lines(Paths.get("build.xml"))
//                    .map(s - > s.trim())
//                    .filter(s - > s.startsWith(")) 
//                    .forEach(System.out::println);
                Files.lines(Paths.get("manifest.mf"), StandardCharsets.UTF_8).
                        forEach(System.out::println);
            } catch (IOException ex) {
                Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        // CHARACTER STREAMS
        /* 
         All character stream classes are descended from Reader and Writer. 
         As with byte streams, there are character stream classes that 
         specialize in file I/O: FileReader and FileWriter.
         Character streams are often "wrappers" for byte streams. The character 
         stream uses the byte stream to perform the physical I/O, while the 
         character stream handles translation between characters and bytes. 
         FileReader, for example, uses FileInputStream, while FileWriter uses 
         FileOutputStream.
         */
        /*
         Notice that both copyFile and copyFile2 use an int variable to 
         read to and write from. However, in copyFile2, the int variable 
         holds a character value in its last 16 bits; in copyFile, the int 
         variable holds a byte value in its last 8 bits.
         */
        public void copyFile2(String strSourceFile, String strDestFile)
                throws IOException {

            /**
             * Для считывания данных из файла предназначен класс
             * FileInputStream, который является наследником класса InputStream
             * и поэтому реализует все его методы.
             */
            // Instantiating a fileStreams
            FileReader in = null;
            FileWriter out = null;
            try {
                in = new FileReader(strSourceFile);
                out = new FileWriter(strDestFile);
                int c;
                while ((c = in.read()) != -1) {
                    out.write(c);
                }
//                Slightly other way of copying one file to another one
//                while (in.available() > 0) {
//                    int data = in.read();
//                    out.write(data);
//                }
            } finally {
                /* 
                 One needs to close the streams before finishing working with 
                 them. "try" is used here, because file could be being used in 
                 some other thread.
                 */
                try {
                    // Checking for "null", because it somehow could be so, due to
                    // impact of some other thread
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException e) {
                    System.out.println("Failed to close input stream");
                }
                try {
                    if (out != null) {
                        out.close();
                    }
                } catch (IOException e) {
                    System.out.println("Failed to close output stream");
                }
            }

        }

        // Reading from file using "FileReader" class.
        public void fileReader() {

            Reader reader = null;
            try {
                reader = new FileReader(strSourceFile);
                int data = reader.read();
                while (data != -1) {
                    data = reader.read();
                    System.out.println((char) data);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Files_.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Files_.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(Files_.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        /**
         * There are two general-purpose byte-to-character "bridge" streams:
         * InputStreamReader and OutputStreamWriter. Use them to create
         * character streams when there are no prepackaged character stream
         * classes that meet your needs. The sockets lesson in the networking
         * trail shows how to create character streams from the byte streams
         * provided by socket classes.
         */
        // LINE-ORIENTED I/O (Operating with whole lines, not just chars).

        /**
         * Let's modify the CopyCharacters example to use line-oriented I/O. To
         * do this, we have to use two classes we haven't seen before,
         * BufferedReader and PrintWriter. We'll explore these classes in
         * greater depth in Buffered I/O and Formatting. Right now, we're just
         * interested in their support for line-oriented I/O.
         */
        public void copyFile3(String strSourceFile, String strDestFile) {
            // Instantiating a fileStreams
            BufferedReader in = null;
            PrintWriter out = null;
            try {
                try {
                    in = new BufferedReader(new FileReader(strSourceFile));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    out = new PrintWriter(new FileWriter(strDestFile));
                } catch (IOException ex) {
                    Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
                }
                String str;
                try {
                    while ((str = in.readLine()) != null) {
                        /**
                         * Invoking readLine returns a line of text with the
                         * line. CopyLines outputs each line using println,
                         * which appends the line terminator for the current
                         * operating system. This might not be the same line
                         * terminator that was used in the input file.
                         */
                        out.println(str);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
                }
            } finally {
                /* 
                 One needs to close the streams before finishing working with 
                 them. "try" is used here, because file could be being used in 
                 some other thread.
                 */
                try {
                    // Checking for "null", because it somehow could be so, due to
                    // impact of some other thread
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException e) {
                    System.out.println("Failed to close input stream");
                }
                // Compiler said there is no need in try in this case.
                if (out != null) {
                    out.close();
                }
            }

        }

        /**
         * Reading from file using "Scanner". The scanner API breaks input into
         * individual tokens associated with bits of data. Objects of type
         * Scanner are useful for breaking down formatted input into tokens and
         * translating individual tokens according to their data type.
         * <p>
         * http://docs.oracle.com/javase/tutorial/essential/io/scanning.html
         */
        public void readWithScanner(String strSourceFile) {

            /*
             * Scanner is generally great, but it's based on regular expression, 
             * so the performance could become bad in some situations. 
             * I remember I did a test to read a large text file line by line,
             * and it turned out BufferedReader.readLine() is much more effective 
             * than Scanner.nextLine().
             * 
             * source: http://www.adam-bien.com/roller/abien/entry/reading_a_file_into_a2
             */
            File fl = new File(strSourceFile);
            String result = fl.exists()
                    ? "File " + strSourceFile + " exists"
                    : "File " + strSourceFile + " doesn't exists";
            System.out.println(result);
            System.out.println("Its contents follows next :");
            Scanner scnRead = null;
            try {
                scnRead = new Scanner(fl);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Files_.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (scnRead != null) {
                while (scnRead.hasNextLine()) {
                    System.out.println(scnRead.nextLine());
                }
            }
            scnRead.close();    // Should this be put inside try ?
        }

        // BUFFERED READING

        /**
         * Most of the examples we've seen so far use unbuffered I/O. This means
         * each read or write request is handled directly by the underlying OS.
         * This can make a program much less efficient, since each such request
         * often triggers disk access, network activity, or some other operation
         * that is relatively expensive.
         * <p>
         * To reduce this kind of overhead, the Java platform implements
         * buffered I/O streams. Buffered input streams read data from a memory
         * area known as a buffer; the native input API is called only when the
         * buffer is empty. Similarly, buffered output streams write data to a
         * buffer, and the native output API is called only when the buffer is
         * full.
         * <p>
         * A program can convert an unbuffered stream into a buffered stream
         * using the wrapping idiom we've used several times now, where the
         * unbuffered stream object is passed to the constructor for a buffered
         * stream class. Here's how you might modify the constructor invocations
         * in the copyFile2 example to use buffered I/O:
         * <p>
         * inputStream = new BufferedReader(new FileReader("xanadu.txt"));
         * outputStream = new BufferedWriter(new
         * FileWriter("characteroutput.txt"));
         * <p>
         * There are four buffered stream classes used to wrap unbuffered
         * streams: BufferedInputStream and BufferedOutputStream create buffered
         * byte streams, while BufferedReader and BufferedWriter create buffered
         * character streams.
         */
        public void copyFile4(String strSourceFile, String strDestFile)
                throws IOException {
            // Instantiating a fileStreams
            BufferedReader in = null;
            BufferedWriter out = null;
            try {
                in = new BufferedReader(new FileReader(strSourceFile));
                out = new BufferedWriter(new FileWriter(strDestFile));
                String str;
                while ((str = in.readLine()) != null) {
                    /**
                     * Invoking readLine returns a line of text with the line.
                     * CopyLines outputs each line using println, which appends
                     * the line terminator for the current operating system.
                     * This might not be the same line terminator that was used
                     * in the input file.
                     */
                    out.write(str);
                }
            } finally {
                /* 
                 One needs to close the streams before finishing working with 
                 them. "try" is used here, because file could be being used in 
                 some other thread.
                 */
                try {
                    // Checking for "null", because it somehow could be so, due to
                    // impact of some other thread
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException e) {
                    System.out.println("Failed to close input stream");
                }
                // Compiler said there is no need in try in this case.
                if (out != null) {
                    out.close();
                }
            }

        }

        public void readAndPrintFile() {
            String contents = null;
            try {
                contents = new String(Files.readAllBytes(Paths.get("manifest.mf")));
            } catch (IOException ex) {
                Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Contents (Java 7) : " + contents);
        }

        public void readAndPrintFile2() {
            String fileString = null;
            try {
                fileString = new String(Files.readAllBytes(
                        Paths.get("manifest.mf")), StandardCharsets.UTF_8);
            } catch (IOException ex) {
                Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Contents (Java 7 with character encoding ) : "
                    + fileString);
        }

        // Making system out to prunt to a file.
        public void setOutToFile() {
            try {
                PrintStream print = new PrintStream(
                        new FileOutputStream("user/files/fileDestination.txt"));
                System.setOut(print);
                System.out.println("Study Java well.");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public void commonDemo() {

            // Byte streams operating.
            // Byte streams should only be used for the most primitive I/O.
            // Abstract classes.
            InputStream inputStream = null;
            OutputStream outputStream = null;
            InputStreamReader inputStreamReader = null;
            OutputStreamWriter outputStreamWriter = null;
            // Obtains input bytes from a file in a file system.
            FileInputStream fileInputStream = null;
            // Is an output stream for writing data to a File or to a FileDescriptor.
            FileOutputStream fileOutputStream = null;
            FilterOutputStream filterOutputStream = null;
            // Adds to another output stream the ability to print representations.
            // of various data values conveniently.
            PrintStream printStream = null;

            // Prints formatted representations of objects to a text-output stream.
            // Apart from PrintStream, wrotes characters, but not bytes.
            PrintWriter printWriter = null;
            // Wrapper for input streams, uses FileInputStream.
            FileReader fileReader = null;
            // Wrapper for input streams, uses FileOutputStream.
            FileWriter fileWriter = null;   // Wrapper for output streams.
            BufferedReader bufferedReader = null;   // Can read whole lines.
            BufferedWriter bufferedWriter = null;   // Can write whole lines.
            try {
                bufferedReader = new BufferedReader(new FileReader(strSourceFile));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Files_.class.getName()).log(Level.SEVERE, null, ex);
//                System.exit(1);
            }
        }

        private void inputStreamReaderDemo() {
            InputStreamReader inputStreamReader = null;
            try {
                inputStreamReader =
                        new InputStreamReader(new FileInputStream(strSourceFile));
                int i = 0;
                while ((i = inputStreamReader.read()) != -1) {
                    System.out.print((char) i);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void outputStreamWriterDemo() {
            OutputStreamWriter outputStreamWriter = null;
            try {
                outputStreamWriter =
                        new OutputStreamWriter(new FileOutputStream(strDestFile));
                for (int i = 0; i < 10; i++) {
                    outputStreamWriter.write(i);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void fileInputStreamDemo() {
            FileInputStream fileInputStream = null;
            // File might miss, thus put an instantiation to try.
            try {
                fileInputStream = new FileInputStream(strSourceFile);
                int i = 0;
                while ((i = fileInputStream.read()) != -1) {
                    System.out.print((char) i);
                }
                // Same as next
//                while (fileInputStream.available() > 0) {
//                    System.out.print((char)i);
//                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void fileOutputStreamDemo() {
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(strDestFile);
                int i = 0;
                while (i < 10) {
                    try {
                        // Writes binary data, not chars !
                        // File will have a wrong data.
                        fileOutputStream.write(i);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    i++;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private boolean createFile(File newFile) {
            return false;
        }

        public boolean createDirectory(File directory) {
            if (directory != null) {
                if (directory.isFile()) {
                    logger.warning("This is a file, so directory already exists");
                    return false;
                }
                if (directory.isDirectory()) {
                    logger.info("This directory already exists");
                    return false;
                }
            } else {
                logger.info("You tried to create a null directory !");
                return false;
            }
            return directory.mkdir();
        }

        public boolean createDirectory(String directory) {
            if (directory==null) {
                logger.info("You tried to create a null directory !");
                return false;
            }
            File file = new File(directory);
            return createDirectory(file);
        }

    }

    public class Keyboard {

        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        /**
         * Shorter declaration of a "bufferedReader"
         *
         * BufferedReader bufferedReader = new BufferedReader(new
         * InputStreamReader(System.in));
         */
        /*
         * Scanner is generally great, but it's based on regular expression, 
         * so the performance could become bad in some situations. 
         * I remember I did a test to read a large text file line by line,
         * and it turned out BufferedReader.readLine() is much more effective 
         * than Scanner.nextLine().
         * 
         * source: http://www.adam-bien.com/roller/abien/entry/reading_a_file_into_a2
         */
        /**
         * Instantiating scanner, having a standard input stream (System.in)
         * passed into it. "System.in" stands for a keyboard operating.
         */
        Scanner scanner = new Scanner(System.in);

        // https://docs.oracle.com/javase/tutorial/essential/io/cl.html

        // Reading a char from keyboard and print it.
        public void inputKey() {
            int i = 0;
            System.out.print("Input key: ");
            try {
                // Reading a char, that is to be represented as int.
                i = inputStream.read();
            } catch (IOException ex) {
                Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Key is:" + i);
        }

        // Reading a line from keyboard and print it.
        public void inputLine() {
            String name = "";
            try {
                // Reading the line from a keyboard.
                name = bufferedReader.readLine();
            } catch (IOException ex) {
                Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Line is:" + name);
        }

        // Reading the line from a keyboard with Scanner instance.
        public void inputLine2() {
            String line = scanner.nextLine();
            System.out.println("Line is:" + line);
        }

        // Reading the line from a keyboard with Console instance.
        public void inputLine3() {
            String line = "";
            Console сnsl = System.console();
            if (сnsl == null) {
                System.out.println("This OS does not provide a console.");
            } else {
                line = сnsl.readLine();
                System.out.println("Line is:" + line);
            }
        }

        public void inputPassword() throws IOException {

            Console c = System.console();
            if (c == null) {
                System.err.println("No console.");
                System.exit(1);
            }

            String login = c.readLine("Enter your login: ");
            char[] oldPassword = c.readPassword("Enter your old password: ");

            if (verify(login, oldPassword)) {
                boolean noMatch;
                do {
                    char[] newPassword1 = c.readPassword("Enter your new password: ");
                    char[] newPassword2 = c.readPassword("Enter new password again: ");
                    noMatch = !Arrays.equals(newPassword1, newPassword2);
                    if (noMatch) {
                        c.format("Passwords don't match. Try again.%n");
                    } else {
                        change(login, newPassword1);
                        c.format("Password for %s changed.%n", login);
                    }
                    Arrays.fill(newPassword1, ' ');
                    Arrays.fill(newPassword2, ' ');
                } while (noMatch);
            }

            Arrays.fill(oldPassword, ' ');
        }

        // Dummy change method (for inputPassword).
        boolean verify(String login, char[] password) {
            // This method always returns
            // true in this example.
            // Modify this method to verify
            // password according to your rules.
            return true;
        }

        // Dummy change method (for inputPassword).
        void change(String login, char[] password) {
            // Modify this method to change
            // password according to your rules.
        }

        Keyboard() {
            inputKey();
//            try {
//                inputPassword();
//            } catch (IOException ex) {
//                Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }

    }
}
