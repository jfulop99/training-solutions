package ioprintwriter.talentshow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ResultCalculator {

    private List<Production> productions;
    private List<Vote> votes;

    public ResultCalculator() {
        productions = new ArrayList<>();
        votes = new ArrayList<>();
    }

    public void readTalents(Path file) {

        try (BufferedReader reader = Files.newBufferedReader(file)){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                productions.add(new Production(Integer.parseInt(parts[0]), parts[1]));
                votes.add(new Vote(Integer.parseInt(parts[0]), 0));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }
    }

    public void calculateVotes(Path file) {
        try (BufferedReader reader = Files.newBufferedReader(file)){
            String line;
            while ((line = reader.readLine()) != null) {
                votes.get(Integer.parseInt(line)-1).incNum();
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }
    }

    public void writeResultToFile(Path file) {
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(file))){
            int maxVote = 0;
            int winnerId = 0;
            for (Production production:productions) {
                writer.print(production.getId());
                writer.print(" " + production.getName() + " ");
                int vote = votes.get(production.getId() - 1).getNumber();
                writer.println(vote);
                if (vote > maxVote) {
                    maxVote = vote;
                    winnerId = production.getId();
                }
            }
            writer.println("Winner: " + productions.get(winnerId - 1).getName());
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file", e);
        }
    }

    public List<Production> getProductions() {
        return productions;
    }

    public List<Vote> getVotes() {
        return votes;
    }
}
