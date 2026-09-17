package nvb.dev.duplicatefilefinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileSizeGrouper {

    public static Map<Long, List<Path>> group(List<Path> files) throws IOException {
        Map<Long, List<Path>> result = new HashMap<>();

        for (Path file : files) {
            long fileSize = Files.size(file);
            result.computeIfAbsent(fileSize, k -> new ArrayList<>()).add(file);
        }

        return result;
    }

}
