import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class File_IO {
    private static final Logger logger = Logger.getLogger(File_IO.class.getName());

    public static void createFile(String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.close(); // Close the file immediately to create an empty file
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error occurred while creating file: " + fileName, e);
        }
    }

    public static void writeToFile(String fileName, String content) {
        try (FileWriter fileWriter = new FileWriter(fileName, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
            printWriter.println(content);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error occurred while writing to file: " + fileName, e);
        }
    }
}
