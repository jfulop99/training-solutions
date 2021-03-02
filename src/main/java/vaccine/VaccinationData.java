package vaccine;

import java.util.ArrayList;
import java.util.List;

public class VaccinationData {

    private final Citizen citizen;

    private final List<Vaccination> vaccinations;

    public VaccinationData(Citizen citizen, List<Vaccination> vaccinations) {
        this.citizen = citizen;
        this.vaccinations = vaccinations;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public List<Vaccination> getVaccinations() {
        return new ArrayList<>(vaccinations);
    }
}
