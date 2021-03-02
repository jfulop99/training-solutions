package vaccine;

import java.time.LocalDateTime;

public class Vaccination {

    private final long citizenId;

    private final LocalDateTime vaccinationDate;

    private final String status;

    private final String note;

    private final VaccineType vaccineType;

    public Vaccination(long citizenId, LocalDateTime vaccinationDate, String status, String note, VaccineType vaccineType) {
        this.citizenId = citizenId;
        this.vaccinationDate = vaccinationDate;
        this.status = status;
        this.note = note;
        this.vaccineType = vaccineType;
    }

    public long getCitizenId() {
        return citizenId;
    }

    public LocalDateTime getVaccinationDate() {
        return vaccinationDate;
    }

    public String getStatus() {
        return status;
    }

    public String getNote() {
        return note;
    }

    public VaccineType getVaccineType() {
        return vaccineType;
    }
}
