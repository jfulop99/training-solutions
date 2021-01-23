package lambdacomparator;

import java.text.Collator;
import java.util.*;

public class Clouds {

    public CloudStorage alphabeticallyFirst(List<CloudStorage> cloudStorages) {
        List<CloudStorage> cloudStorageList = new ArrayList<>(cloudStorages);

        Collator collator = Collator.getInstance(new Locale("hu", "HU"));
        cloudStorageList.sort(Comparator.comparing(CloudStorage::getProvider, Comparator.nullsFirst(collator)));

        Collections.shuffle(cloudStorageList);

        cloudStorageList.sort(Comparator.comparing(CloudStorage::getProvider, String::compareToIgnoreCase));
        System.out.println(cloudStorageList);

        return cloudStorageList.get(0);
    }

    public CloudStorage bestPriceForShortestPeriod(List<CloudStorage> cloudStorages) {
        List<CloudStorage> cloudStorageList = new ArrayList<>(cloudStorages);

        cloudStorageList.sort(Comparator.nullsFirst(Comparator.comparing(CloudStorage::getPeriod, Comparator.nullsFirst(Comparator.comparingInt(PayPeriod::getLength))))
                .thenComparingDouble(CloudStorage::getPrice));

        return cloudStorageList.get(0);
    }

    public List<CloudStorage> worstOffers(List<CloudStorage> cloudStorages) {
        List<CloudStorage> cloudStorageList = new ArrayList<>(cloudStorages);

        cloudStorageList.sort(Comparator.reverseOrder());

        return cloudStorageList.subList(0, Math.min(cloudStorageList.size(), 3));
    }
}
