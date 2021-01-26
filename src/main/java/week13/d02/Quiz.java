package week13.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quiz {

    private char[] goodAnswers;
    private Map<String, List<Character>> resultMap = new HashMap<>();

    public char[] getGoodAnswers() {
        return goodAnswers;
    }

    public Map<String, List<Character>> getResultMap() {
        return new HashMap<>(resultMap);
    }

    public void loadFromFile(BufferedReader reader){
        try (reader){
            storeGoodAnswers(reader);
            readLines(reader);
        }catch(IOException ioe){
            throw new IllegalArgumentException("Can not read file", ioe);
        }
    }

    private void readLines(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine())!=null){
            processLine(line);
        }
    }

    private void storeGoodAnswers(BufferedReader reader) throws IOException {
        goodAnswers = reader.readLine().toCharArray();
    }

    private void processLine(String line) {
        String[] data = line.split(" ");
        if (!resultMap.containsKey(data[0])){
            resultMap.put(data[0],new ArrayList<>());
        }
        resultMap.get(data[0]).add(data[1].charAt(0));
    }

    public boolean isGoodAnswer(String code, int index){
        Character answer = resultMap.get(code).get(index);
        return answer.equals(goodAnswers[index]);
    }

    public String mostSkippedCode(){
        String code = "";
        int maxNumberOfSkipped = 0;
        for(Map.Entry<String,List<Character>> entry: resultMap.entrySet()){
            int numberOfSkipper = getXCount(entry);
            if(maxNumberOfSkipped<numberOfSkipper){
                code = entry.getKey();
                maxNumberOfSkipped = numberOfSkipper;
            }
        }
        return code;
    }

    private int getXCount(Map.Entry<String, List<Character>> entry) {
        int numberOfSkipped = 0;
        for (Character c: entry.getValue()) {
            if(c == 'X'){
                numberOfSkipped++;
            }
        }
        return numberOfSkipped;
    }

    public String getWinner(){
        String code = "";
        int maxPoint = 0;
        for(Map.Entry<String,List<Character>> entry: resultMap.entrySet()){
            int points = getPointCount(entry);
            if(maxPoint<points){
                code = entry.getKey();
                maxPoint = points;
            }
        }
        return code;
    }

    private int getPointCount(Map.Entry<String, List<Character>> entry) {
        int points = 0;
        for (int i = 0; i < entry.getValue().size(); i++) {
            if(isGoodAnswer(entry.getKey(),i)) {
                points += i + 1;
            }
            if (entry.getValue().get(i) != 'X') {
                points -= 2;
            }
        }
        return points;
    }


    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.loadFromFile(new BufferedReader(new InputStreamReader(Quiz.class.getResourceAsStream("results.txt"))));

        System.out.println(quiz.isGoodAnswer("AB123",0));
        System.out.println(quiz.mostSkippedCode());
        System.out.println(quiz.getWinner());
    }
}
