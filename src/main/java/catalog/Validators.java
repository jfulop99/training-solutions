package catalog;

import java.util.List;

public class Validators {

    protected static boolean isBlank(String str) {
        return str == null || str.isBlank();
    }

    protected static boolean isEmpty(List<String> list) {
        return list == null || list.isEmpty();
    }

    private Validators() {
    }
}
