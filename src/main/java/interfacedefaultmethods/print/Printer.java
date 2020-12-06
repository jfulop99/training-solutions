package interfacedefaultmethods.print;

public class Printer {

    public String print(Printable printable) {
        String print = "";
        for (int i = 0; i < printable.getLength(); i++) {
            String color = printable.getColor(i);
            print = print + (color == Printable.BLACK ? "" : "[" + color + "]");
            print = print + printable.getPage(i) + "\n";
        }
        return print;
    }
}
