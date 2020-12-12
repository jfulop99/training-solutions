package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item is null");
        }
        catalogItems.add(item);
    }

    public double averagePageNumberOver(int pages) {
        if (pages <= 0) {
            throw new IllegalArgumentException("Page number must be positive");
        }
        double sum = 0.0;
        int counter = 0;
        for (CatalogItem item:catalogItems) {
            int numberOfPages = item.numberOfPagesAtOneItem();
            if (numberOfPages > pages) {
                sum += numberOfPages;
                counter++;
            }
        }
        if (counter == 0) {
            throw new IllegalArgumentException("No page");
        }
        return sum / counter;
    }

    public void deleteItemByRegistrationNumber(String registrationNumber) {
        for (CatalogItem item : catalogItems ) {
            if (registrationNumber.equals(item.getRegistrationNumber())) {
                catalogItems.remove(item);
                return;
            }
        }
    }

    public int getAllPageNumber() {
        int sum = 0;
        List<CatalogItem> printedItems = getPrintedLibraryItems();
        for (CatalogItem item : printedItems) {
            sum += item.numberOfPagesAtOneItem();
        }
        return sum;
    }

    public int getFullLength() {
        int sum = 0;
        List<CatalogItem> audioItems = getAudioLibraryItems();
        for (CatalogItem item : audioItems ) {
            sum += item.fullLengthAtOneItem();
        }
        return sum;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> result = new ArrayList<>();
        for (CatalogItem item : catalogItems ) {
            if (item.hasAudioFeature()) {
                result.add(item);
            }
        }
        return result;
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> result = new ArrayList<>();
        for (CatalogItem item : catalogItems ) {
            if (item.hasPrintedFeature()) {
                result.add(item);
            }
        }
        return result;
    }

    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        List<CatalogItem> result = new ArrayList<>();
        for (CatalogItem catalogItem: catalogItems ) {
              if (checkSearchCriteria(catalogItem, searchCriteria)) {
                  result.add(catalogItem);
              }
        }
        return result;
    }

    private boolean checkSearchCriteria(CatalogItem item, SearchCriteria searchCriteria) {
        boolean isFoundContributor;
        boolean isFoundTitle;
        String contributor = searchCriteria.getContributor();
        String title = searchCriteria.getTitle();
        isFoundContributor = (contributor == null || item.getContributors().contains(contributor));
        isFoundTitle = (title == null )|| (item.getTitles().contains(title));
        return isFoundContributor && isFoundTitle;
    }
}
