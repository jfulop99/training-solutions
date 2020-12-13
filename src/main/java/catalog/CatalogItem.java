package catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatalogItem {

    private final String registrationNumber;
    private final int price;
    private final List<Feature> features = new ArrayList<>();

    public CatalogItem(String registrationNumber, int price, Feature... feature) {
        checkParameters(registrationNumber, price, feature);
        this.registrationNumber = registrationNumber;
        this.price = price;
        this.features.addAll(Arrays.asList(feature));
    }

    public int fullLengthAtOneItem() {
        int sum = 0;
        for (Feature item:features) {
            if (item instanceof AudioFeatures) {
                sum += ((AudioFeatures) item).getLength();
            }
        }
        return sum;
    }

    public List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        for (Feature item:features) {
            titles.add(item.getTitle());
        }
        return titles;
    }

    public boolean hasAudioFeature() {
        for (Feature item : features) {
            if (item instanceof AudioFeatures) {
                return true;
            }
        }
        return false;
    }

    public int numberOfPagesAtOneItem() {
        int sum = 0;
        for (Feature item:features) {
            if (item instanceof PrintedFeatures) {
                sum += ((PrintedFeatures) item).getNumberOfPages();
            }
        }
        return sum;
    }

    public boolean hasPrintedFeature() {
        for (Feature item : features) {
            if (item instanceof PrintedFeatures) {
                return true;
            }
        }
        return false;
    }

    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>();
        for (Feature item:features) {
            contributors.addAll(item.getContributors());
        }
        return contributors;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getPrice() {
        return price;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    private void checkParameters(String registrationNumber, int price, Feature... feature) {
        if (Validators.isBlank(registrationNumber)) {
            throw new IllegalArgumentException("Invalid registration number");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Invalid price");
        }
        if (feature.length == 0) {
            throw new IllegalArgumentException("There is no feature");
        }
        else {
            for (Feature item:feature) {
                if (item == null) {
                    throw new IllegalArgumentException("Feature is null");
                }
            }
        }
    }
}
