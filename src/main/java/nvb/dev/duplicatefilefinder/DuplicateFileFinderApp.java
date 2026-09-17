package nvb.dev.duplicatefilefinder;

import java.nio.file.Files;
import java.nio.file.Path;

public class DuplicateFileFinderApp {
    public static void main(String[] args) {

        if (args.length != 0) {
            Path path = Path.of(args[0]);
            if (Files.exists(path) && Files.isDirectory(path)) {
                System.out.println("Scanning directory: " + path);
            } else {
                System.out.println("Invalid directory.");
            }
        } else {
            System.out.println("Argument is empty!");
        }

    }
}
