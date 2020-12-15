package ioreader.states;

public class State {

    String name;
    String capital;

    public State(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }

    public String getStateName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }
}
