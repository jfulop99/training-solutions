package localvariables;

public class DistanceMain {
    public static void main(String[] args) {
        Distance distance = new Distance(193.456, false);
        System.out.println("A távolság = " + distance.getDistanceInKm() + (distance.isExact()?" km és pontos.":" km és nem pontos."));
        int egeszResz = (int) distance.getDistanceInKm();
        System.out.println("A távolság egészrésze = " + egeszResz + " km.");
    }

}
