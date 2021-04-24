package gyaxi.orokles.airport;

public class Passenger extends Person {

    private String seat;

    public Passenger(String name, int age, String seat) {
        super(name, age, PersonType.PASSENGER);
        this.seat = seat;
    }

    public String getSeat() {
        return seat;
    }

    public void changeSeat() {
        String seatLetter = seat.substring(seat.length() - 1);
        switch (seatLetter) {
            case "A":
                seat = seat.replace("A", "C");
                break;
            case "C":
                seat = seat.replace("C", "A");
                break;
            case "D":
                seat = seat.replace("D", "F");
                break;
            case "F":
                seat = seat.replace("F", "D");
                break;
        }
    }
}
