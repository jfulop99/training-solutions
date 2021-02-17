package xerettsegi.y2019.oktober;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Travel {

    private final int stopId;

    private final LocalDateTime startTime;

    private final String ticketId;

    private final TicketType ticketType;

    private final String valid;

    private final static DateTimeFormatter TRAVEL_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd-HHmm");

    public Travel(int stopId, LocalDateTime startTime, String ticketId, TicketType ticketType, String valid) {
        this.stopId = stopId;
        this.startTime = startTime;
        this.ticketId = ticketId;
        this.ticketType = ticketType;
        this.valid = valid;
    }

    public Travel(String line) {
        String[] parts = line.split(" ");
        this.stopId = Integer.parseInt(parts[0]);
        this.startTime = LocalDateTime.parse(parts[1], TRAVEL_TIME_FORMAT);
        this.ticketId = parts[2];
        this.ticketType = TicketType.valueOf(parts[3]);
        this.valid = parts[4];
    }

    public int getStopId() {
        return stopId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getTicketId() {
        return ticketId;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public String getValid() {
        return valid;
    }

    public boolean isValid() {

        if (valid.length() < 6) {
            if (Integer.parseInt(valid) > 0) {
                return true;
            } else {
                return false;
            }
        }

        if (startTime.toLocalDate().compareTo(LocalDate.parse(valid, DateTimeFormatter.ofPattern("yyyyMMdd"))) <= 0) {
            return true;
        }
        return false;
    }

    public boolean isWarning() {

        if (valid.length() < 6) {
            return false;
        }

        LocalDate start = startTime.toLocalDate();

        LocalDate validDate = LocalDate.parse(valid, DateTimeFormatter.ofPattern("yyyyMMdd"));


        if (ChronoUnit.DAYS.between(start, validDate) <= 3) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "stopId=" + stopId +
                ", startTime=" + startTime +
                ", ticketId='" + ticketId + '\'' +
                ", ticketType=" + ticketType +
                ", valid='" + valid + '\'' +
                '}';
    }
}
