package lambdaintro;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OfficeDocumentReader {

    public List<File> listOfficeDocuments(File path) {

        List<File> fileList = new ArrayList<>(Arrays.asList(Objects.requireNonNull(path.listFiles((file) -> file.isFile() && file.getName().toUpperCase().matches("^.*\\.(DOCX|XLSX|PPTX)$")))));

//      List<File> fileList = new ArrayList<>(Arrays.asList(path.listFiles((file) -> file.isFile() && file.getName().toUpperCase().matches("^.*\\.(DOCX|XLSX|PPTX)$"))));

        fileList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));


        return fileList;
    }

}
