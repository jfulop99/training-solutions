package objectclass;

import java.util.ArrayList;
import java.util.List;

public class SimpleBag {

    private List<Object> items;
    private int cursorPosition = -1;

    public SimpleBag() {
        items = new ArrayList<>();
    }

    public void putItem(Object item) {
        items.add(item);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    public void beforeFirst() {
        cursorPosition = -1;
    }

    public boolean hasNext() {
        return cursorPosition < size() - 1 ? true : false;
    }

    public Object next() {
        return items.get(++cursorPosition);
    }

    public boolean contains(Object item) {
//        for (Object part:items) {
//            if (item.equals(part)) {
//                return true;
//            }
//        }
//        return false;
        return items.contains(item);
    }

    public int getCursor() {
        return cursorPosition;
    }
}
