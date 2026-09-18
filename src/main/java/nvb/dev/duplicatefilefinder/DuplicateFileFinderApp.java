package nvb.dev.duplicatefilefinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class DuplicateFileFinderApp {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Argument is empty!");
            return;
        }

        Path path = Path.of(args[0]);

        if (!Files.exists(path) || !Files.isDirectory(path)) {
            System.out.println("Invalid directory!");
            return;
        }

        try {
            System.out.println("Scanning directory: " + path);
            List<Path> files = FileScanner.scan(path);

            Map<Long, List<Path>> groupedFiles = FileSizeGrouper.group(files);
            Map<Long, List<Path>> potentialDuplicates = FileSizeGrouper.filterPotentialDuplicates(groupedFiles);
            if (potentialDuplicates.isEmpty()) {
                System.out.println("No potential duplicates found.");
                return;
            }

            List<Path> candidateFiles = potentialDuplicates.values()
                    .stream()
                    .flatMap(List::stream)
                    .toList();

            Map<String, List<Path>> hashedGroupFiles = FileHashGrouper.group(candidateFiles);
            Map<String, List<Path>> duplicateGroups = FileHashGrouper.filterDuplicateGroups(hashedGroupFiles);
            if (duplicateGroups.isEmpty()) {
                System.out.println("No duplicate files found.");
                return;
            }

            System.out.println("\nDuplicate groups:");
            for (List<Path> duplicateFiles : duplicateGroups.values()) {
                System.out.println(duplicateFiles);
            }

        } catch (IOException e) {
            System.out.println("Failed to scan files: " + e.getMessage());
        }

    }
}
