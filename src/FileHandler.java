
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.io.*;
import java.nio.*;
public class FileHandler {

    public static String[] readFile(String filename) {

        try {
            //Read all lines from file

            return Files.readAllLines(Path.of(filename)).toArray(new String[0]);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
        catch (Exception e) {
            System.out.println("Error in readFile function of FileHandler class"
                    + System.lineSeparator()
                    + Arrays.toString(e.getStackTrace()));
            return null;
        }
    }
}
