package nvb.dev.duplicatefilefinder;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class FileHasher {

    public static String hash(Path file) {
        byte[] buffer = new byte[8192];
        int bytesRead;

        try (InputStream inputStream = Files.newInputStream(file)) {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                messageDigest.update(buffer, 0, bytesRead);
            }
            byte[] hashBytes = messageDigest.digest();
            return HexFormat.of().formatHex(hashBytes);
        } catch (IOException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
