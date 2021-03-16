package xerettsegi.y2018.majus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class LoungeService {

    private List<AccessRecord> accessRecords = new ArrayList<>();

    private Map<Integer, Integer> movingNumber = new TreeMap<>();

    public void readDataFromFile(BufferedReader reader) throws IOException {

        String line;
        while ((line = reader.readLine()) != null) {
            accessRecords.add(new AccessRecord(line));
        }
    }

    public List<AccessRecord> getAccessRecords() {
        return new ArrayList<>(accessRecords);
    }

    public int getFirstIn() {
        for (AccessRecord item : accessRecords) {
            if (item.isIn()) {
                return item.getPersonId();
            }
        }
        return 0;
    }

    public int getLastOut() {
        AccessRecord result = null;
        for (AccessRecord item : accessRecords) {
            if (!item.isIn()) {
                result = item;
            }
        }
        return result.getPersonId();
    }

    public void writeMovingNumbersToFile() {

        try (BufferedWriter writer = Files.newBufferedWriter(Path.of("athaladas.txt"))) {
            writeLine(writer);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot wrtite file");
        }


    }

    private void fillMovingMap() {
        for (AccessRecord item : accessRecords) {
            movingNumber.merge(item.getPersonId(), 1, Integer::sum);
        }
    }

    private void writeLine(BufferedWriter writer) throws IOException {
        fillMovingMap();
        for (Integer key : movingNumber.keySet()) {
            writer.write(String.format("%d %d%n", key, movingNumber.get(key)));
        }
    }


    public Set<Integer> getLastInList() {
        Set<Integer> result = new TreeSet<>();
        for (Integer key : movingNumber.keySet()) {
            if (movingNumber.get(key) % 2 != 0) {
                result.add(key);
            }
        }
        return result;
    }

    public LocalTime getMaxInTime() {
        LocalTime result = null;
        int maxIn = 0;
        int in = 0;
        for (AccessRecord item : accessRecords) {
            if (item.isIn()) {
                in++;
            } else {
                in--;
            }
            if (in > maxIn) {
                maxIn = in;
                result = item.getTime();
            }
        }
        return result;
    }

    public String getStayingListById(int id) {
        StringBuilder sb = new StringBuilder();
        for (AccessRecord item : accessRecords) {
            if (item.getPersonId() == id) {
                sb.append(item.getTime().toString());
                sb.append(item.isIn() ? "-" : "\n");
            }
        }
        return sb.toString();
    }

    public Result getStayingTimeById(int id) {
        LocalTime inTime = null;
        int result = 0;
        for (AccessRecord item : accessRecords) {
            if (item.getPersonId() == id) {
                if (item.isIn()) {
                    inTime = item.getTime();
                } else {
                    result += Duration.between(inTime, item.getTime()).toMinutes();
                    inTime = null;
                }
            }
        }
        if (inTime != null) {
            result += Duration.between(inTime, LocalTime.of(15, 0)).toMinutes();
            return new Result(result, true);
        } else {
            return new Result(result, false);
        }
    }
}
