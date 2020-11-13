package stringmethods.filename;

public class FileNameManipulator {
    public char findLastCharacter(String str) {
        if (isEmpty(str)) {
            throw new IllegalArgumentException("Empty string!");
        }
        return str.charAt(str.length() - 1);
    }

    public String findFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf('.'));
    }

    public boolean identifyFilesByExtension(String ext, String fileName) {
        return (fileName.toUpperCase().indexOf(ext.toUpperCase()) > 0);
    }

    public boolean compareFilesByName(String fileName, String actualFileName) {
        return (fileName.compareTo(actualFileName) == 0);
    }

    public String changeExtensionToLowerCase(String fileName) {
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        if (fileName.indexOf('.') == fileName.length()-1){
            throw new IllegalArgumentException("Invalid argument!");
        }
        if (fileName.indexOf('.') < 0) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        return fileName.substring(0, fileName.indexOf('.')) + fileName.substring(fileName.indexOf('.')).toLowerCase();
    }

    public String replaceStringPart(String fileName, String present, String target) {
        return fileName.replace(present, target);
    }

    private boolean isEmpty(String name) {
        if (name == null || name.length() == 0) {
            return true;
        }
        return false;

    }
}