package nvb.dev.duplicatefilefinder;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DuplicateFileFinderApp {
    public static void main(String[] args) {

        if (args.length != 0) {
            Path path = Path.of(args[0]);
            if (Files.exists(path) && Files.isDirectory(path)) {
                List<Path> fileList = FileScanner.scan(path);
                if (!fileList.isEmpty()) {
                    for (Path file : fileList) {
                        System.out.println(file);
                    }
                }
            } else {
                System.out.println("Invalid directory.");
            }
        } else {
            System.out.println("Argument is empty!");
        }

    }
}
