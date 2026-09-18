package nvb.dev.duplicatefilefinder;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileHashGrouper {

    public static Map<String, List<Path>> group(List<Path> files) {
        return files
                .stream()
                .collect(Collectors.groupingBy(FileHasher::hash));
    }

}
