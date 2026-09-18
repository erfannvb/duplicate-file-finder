package nvb.dev.duplicatefilefinder;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileHashGrouper {

    public static Map<String, List<Path>> group(List<Path> files) {
        return files
                .stream()
                .collect(Collectors.groupingBy(FileHasher::hash));
    }

    public static Map<String, List<Path>> filterDuplicateGroups(Map<String, List<Path>> groupedFiles) {
        Map<String, List<Path>> filteredMap = new HashMap<>();
        for (Map.Entry<String, List<Path>> entry : groupedFiles.entrySet()) {
            if (entry.getValue().size() > 1)
                filteredMap.put(entry.getKey(), entry.getValue());
        }
        return filteredMap;
    }

}
