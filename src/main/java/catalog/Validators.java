package catalog;

import java.util.List;

public class Validators {

    protected static boolean isBlank(String str) {
        return str == null || str.isBlank();
    }

    protected static boolean isEmpty(List<Object> list) {
        return list == null || list.isEmpty();
    }

    private Validators() {
    }
}
