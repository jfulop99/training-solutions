package immutable.satellite;

import java.util.ArrayList;
import java.util.List;

public class SpaceAgency {

    private List<Satellite> satellites = new ArrayList<>();

    public void registerSatellite(Satellite satellite) {
        if (satellite != null) {
            satellites.add(satellite);
        }
        else {
            throw new NullPointerException("Parameter must not be null!");
        }
    }

    public Satellite findSatelliteByRegisterIdent(String name) {
        if (!isEmpty(name)) {
            for (Satellite satellite:satellites) {
                if (satellite.getName().equals(name)) {
                    return satellite;
                }
            }
            throw new IllegalArgumentException("Satellite with the given registration cannot be found!"+name);
        }
        return null;
    }

    private boolean isEmpty(String name) {
        return (name == null || name.trim().length() == 0);
    }

    @Override
    public String toString() {
        return satellites.toString();
    }
}
