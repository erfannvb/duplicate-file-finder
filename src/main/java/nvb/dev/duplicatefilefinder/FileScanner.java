package nvb.dev.duplicatefilefinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class FileScanner {

    public static List<Path> scan(Path directory) {
        try (Stream<Path> pathStream = Files.walk(directory)) {
            return pathStream
                    .filter(Files::isRegularFile)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
