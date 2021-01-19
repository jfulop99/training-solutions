package lambdaintro;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OfficeDocumentReader {

    public List<File> listOfficeDocuments(File path) {

        List<File> officeFiles = new ArrayList<>();

        officeFiles.addAll(Arrays.asList(Objects.requireNonNull(path.listFiles((file) -> file.isFile() && file.getName().toUpperCase().matches("^.*\\.(DOCX|XLSX|PPTX)$")))));

//        officeFiles.addAll(Arrays.asList(path.listFiles((file) -> file.isFile() && file.getName().toUpperCase().matches("^.*\\.(DOCX|XLSX|PPTX)$"))));

        officeFiles.forEach((a) -> System.out.println(a.getName()));

        return officeFiles;
    }

}
