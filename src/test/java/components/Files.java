package components;

public class Files {
    public static String getFileExtension(String fileName) {
        final int extensionPosition = fileName.lastIndexOf('.');
        return fileName.substring(extensionPosition + 1);
    }
}
