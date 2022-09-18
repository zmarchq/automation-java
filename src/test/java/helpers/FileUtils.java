package helpers;

public class FileUtils {
    public static String getFileExtension(String fileName) {
        final int extensionPosition = fileName.lastIndexOf('.');
        return fileName.substring(extensionPosition + 1);
    }
}
