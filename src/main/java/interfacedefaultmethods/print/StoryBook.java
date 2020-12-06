package interfacedefaultmethods.print;

import java.util.ArrayList;
import java.util.List;

public class StoryBook implements Printable{
    List<ColoredPage> pages = new ArrayList<>();


    public void addPage(String page, String color) {
        pages.add(new ColoredPage(page,color));
    }


    @Override
    public int getLength() {
        return pages.size();
    }

    @Override
    public String getPage(int page) {
        return pages.get(page).getContent();
    }

    @Override
    public String getColor(int page) {
        return pages.get(page).getColor();
    }
}
