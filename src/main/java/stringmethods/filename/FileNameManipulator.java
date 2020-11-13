package stringmethods.filename;

public class FileNameManipulator {
    public char findLastCharacter(String str) {
        if (isEmpty(str)) {
            throw new IllegalArgumentException("Empty string!");
        }
        return str.charAt(str.trim().length() - 1);
    }

    public String findFileExtension(String fileName) {
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("Invalid file name!");
        }
        if (fileName.indexOf('.') == fileName.trim().length()-1){
            throw new IllegalArgumentException("Invalid file name!");
        }
        if (fileName.trim().indexOf('.') < 0) {
            throw new IllegalArgumentException("Invalid file name!");
        }
        if (fileName.trim().indexOf('.') == 0){
            throw new IllegalArgumentException("Invalid file name!");
        }
        return fileName.substring(fileName.lastIndexOf('.'));
    }

    public boolean identifyFilesByExtension(String ext, String fileName) {
        if(isEmpty(ext)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        else {
            if(isEmpty(fileName)) {
                throw new IllegalArgumentException("Invalid argument!");
            }
            else {
                if (fileName.indexOf('.') == fileName.trim().length()-1){
                    throw new IllegalArgumentException("Invalid argument!");
                }
                if (fileName.trim().indexOf('.') < 0) {
                    throw new IllegalArgumentException("Invalid argument!");
                }
                if (fileName.trim().indexOf('.') == 0){
                    throw new IllegalArgumentException("Invalid argument!");
                }
                return (fileName.toUpperCase().indexOf(ext.toUpperCase()) > 0);
            }
        }

    }

    public boolean compareFilesByName(String fileName, String actualFileName) {
        if (isEmpty(fileName)){
            throw new IllegalArgumentException("Invalid argument!");
        }
        else {
            if (isEmpty(actualFileName)) {
                throw new IllegalArgumentException("Invalid argument!");
            }
            else {
                return (fileName.toLowerCase().compareTo(actualFileName.toLowerCase()) == 0);
            }
        }

    }

    public String changeExtensionToLowerCase(String fileName) {
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("Empty string!");
        }
        if (fileName.indexOf('.') == fileName.trim().length()-1){
            throw new IllegalArgumentException("Invalid argument!");
        }
        if (fileName.trim().indexOf('.') < 0) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        if (fileName.trim().indexOf('.') == 0) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        return fileName.trim().substring(0, fileName.trim().indexOf('.')) + fileName.trim().substring(fileName.indexOf('.')).toLowerCase();
    }

    public String replaceStringPart(String fileName, String present, String target) {
        if (isEmpty(fileName)){
            throw new IllegalArgumentException("Empty string!");
        }
        else {
                return fileName.replace(present, target);
            }
    }

    private boolean isEmpty(String name) {
        if (name == null || name.trim().length() == 0) {
            return true;
        }
        return false;

    }
}