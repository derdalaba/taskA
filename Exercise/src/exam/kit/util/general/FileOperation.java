package exam.kit.util.general;

import exam.kit.exceptions.InvalidArgumentException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Class offering static methods for file operations.
 * @author uepiy
 */

public final class FileOperation {
    private FileOperation() {
    }

    /**
     * Reads all lines from a file and returns them as a list of strings.
     * Wrapper for Files.readAllLines.
     * @param fileName name/path of the file to read from
     * @return list of strings representing the lines of the file
     * @throws InvalidArgumentException if the file cannot be read/opened/does not exist
     */
    public static List<String> readLinesFromFile(String fileName) throws InvalidArgumentException {

        try {
            return Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new InvalidArgumentException(e.getMessage());
        }
    }
}
