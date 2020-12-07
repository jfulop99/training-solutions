package exceptions.faults;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FaultList {




    public List<String> processLines(List<String> lines) {

        if (lines == null) {
            throw new IllegalArgumentException("lines is null");
        }
        List<String> reportList = new ArrayList<>();
        for (String line:lines) {
            String[] splittedLine = line.split(",");
            ProcessingResult result = lineParser(splittedLine);
            if (result.getCode() > 1) {
                reportList.add(Integer.parseInt(splittedLine[0]) + "," + result.getCode());
            }
        }
        return reportList;
    }

    private ProcessingResult lineParser(String[] splittedLine) {
            if (splittedLine.length != 3) {
                return ProcessingResult.WORD_COUNT_ERROR;
            }

            try {
                Integer.parseInt(splittedLine[0]);
            }catch (NumberFormatException nfe) {
                return ProcessingResult.COMMENT;
            }

            boolean isValidValue = isValidValue(splittedLine[1]);
            boolean isValidDate = isValidDate(splittedLine[2]);

            if (!(isValidDate || isValidValue)) {
                return ProcessingResult.VALUE_AND_DATE_ERROR;
            }

            if (!isValidDate) {
                return ProcessingResult.DATE_ERROR;
            }

            if (!isValidValue) {
                return ProcessingResult.VALUE_ERROR;
            }
            return ProcessingResult.NO_ERROR;
    }

    private boolean isValidValue(String value) {
        try {
            Double.parseDouble(value);
        }catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private boolean isValidDate(String dateStr) {
        try {
            DateFormat date = new SimpleDateFormat("yyyy.MM.yy.");
            date.parse(dateStr);
        }catch (ParseException e) {
            return false;
        }
        return true;
    }
}
