
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;

public class FileHandler {

    public static String[] readFile(String filename) {

        try {
            //Read all lines from file
            return Files.readAllLines(Path.of(filename)).toArray(new String[0]);
        }
        catch (NullPointerException | IOException e) {
            System.err.println(e.getMessage());
            return null;
        }
        catch (Exception e) {
            ExceptionHandler.printGeneralException("Error in readFile function in FileHandler class", e);
            return null;
        }
    }

    public static void writeToFile(String filename, String format, List lines) {

        try {
            Files.write(Paths.get(filename), lines);
        }
        catch (IOException e) {
            ExceptionHandler.printStackedError(e);
        }
        catch (Exception e) {
            ExceptionHandler.printGeneralException("Error in writeEmployeeFile function in FileHandler class", e);
        }
    }
}
