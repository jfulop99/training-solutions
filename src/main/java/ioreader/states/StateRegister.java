package ioreader.states;

import week08.d02.Country;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StateRegister {

    List<State> states;

    public StateRegister() {
        this.states = new ArrayList<>();
    }

    public void readStatesFromFile(String filename) {

        Path path = Path.of(filename);

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("-");
                states.add(new State(parts[0], parts[1]));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file!", e);
        }
    }
    public String findCapitalByStateName(String stateName) {
        for (State state: states) {
            if (state.getStateName().equals(stateName)) {
                return state.getCapital();
            }
        }
        throw new IllegalArgumentException("No state with this name!");
    }

    public List<State> getStates() {
        return new ArrayList<>(states);
    }
}
