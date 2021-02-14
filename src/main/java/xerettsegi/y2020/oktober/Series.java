package xerettsegi.y2020.oktober;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.time.temporal.ChronoUnit.MINUTES;

public class Series {

    private List<Episode> episodeList;

    public Series(BufferedReader reader) throws IOException {

        episodeList = new ArrayList<>();

        String line;
        int counter = 0;
        String[] parts = new String[5];
        while ((line = reader.readLine()) != null) {
            parts[counter++] = line;
            if (counter == 5) {
                episodeList.add(new Episode(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4])));
                counter = 0;
            }
        }
    }

    public List<Episode> getEpisodeList() {
        return new ArrayList<>(episodeList);
    }

    public void printNumberOfList() {
        int numberOfPlayedEpisode = (int) episodeList.stream().filter(a -> !a.getDate().equals("NI")).count();
        System.out.println("A listában " + numberOfPlayedEpisode + " db vetítési dátummal rendelkező epizód van.");
    }

    public void printSeenPercent() {
        long numberOfSeenEpisode = episodeList.stream().filter(a -> a.getWatched() == 1).count();
        double percent = Math.round((double) numberOfSeenEpisode / episodeList.size() * 10000) / 100D;
        System.out.println("A listában lévő epizódok " + percent + "%-át látta.");
    }

    public void printTotalTime() {
        int duration = 0;
        for (Episode episode : episodeList) {
            if (episode.getWatched() == 1) {
                duration += episode.getDuration();
            }
        }
        Duration time = Duration.of(duration, MINUTES);
        System.out.println("Sorozatnézéssel " + time.toDaysPart() + " napot " + time.toHoursPart() + " órát és " + time.toMinutesPart() + " percet töltött el.");
    }

    public void printNotWatchedEpisodesToDate() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Adjon meg egy dátumot (YYYY.MM.DD)! Dátum = ");
        String date = scanner.nextLine();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy.MM.dd");

        LocalDate searchDate = LocalDate.parse(date, format);
        for (Episode episode : episodeList) {
            if (!episode.getDate().equals("NI")) {
                LocalDate episodeDate = LocalDate.parse(episode.getDate(), format);
                if (episodeDate.isBefore(searchDate) && episode.getWatched() == 0) {
                    System.out.println(episode);
                }
            }
        }

    }

    private String hetNapja(int year, int month, int day) {
        String[] napok = {"h", "k", "sze", "cs", "p", "szo", "v"};
        int[] honapok = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        if (month < 3) {
            year--;
        }
        return napok[(year + year / 4 - year / 100 + year / 400 + honapok[month - 1] + day) % 7];
    }

    public void whichDay() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        Set<String> result = new LinkedHashSet<>();
        String[] napok = {"h", "k", "sze", "cs", "p", "szo", "v"};
        System.out.print("Adjon meg egy napot: (h,k,sze,cs,p,szo,v)! Nap = ");
        String nap = scanner.nextLine();
        for (Episode episode : episodeList) {

            String episodeDate = episode.getDate();
            if (!episodeDate.equals("NI")) {
                LocalDate date = LocalDate.parse(episodeDate, format);
                String day = napok[date.getDayOfWeek().getValue() - 1];
//                String day = LocalDate.parse(episode.getDate(), format).getDayOfWeek().getDisplayName(TextStyle.SHORT, new Locale("hu", "HU")).toLowerCase();
                if (nap.equals(day)) {
                    result.add(episode.getTitle());
//                    System.out.println(LocalDate.parse(episode.getDate(), format).getDayOfWeek().getDisplayName(TextStyle.SHORT, new Locale("hu", "HU")));
                }
            }
        }
        if (result.isEmpty()) {
            System.out.println("Az adott napon nem kerül adásba sorozat.");
        } else {
            result.forEach(System.out::println);
        }
    }

    public void summaWrite() {
        Map<String, List<Episode>> result = new LinkedHashMap<>();
        for (Episode episode : episodeList) {
            result.computeIfAbsent(episode.getTitle(), e -> new ArrayList<>()).add(episode);
        }
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of("temp/summa.txt"))) {
            for (String key : result.keySet()) {
                List<Episode> episodes = result.get(key);
                int numberOfEpisodes = episodes.size();
                int totalPlayTime = 0;
                String title = episodes.get(0).getTitle();
                for (Episode episode : episodes) {
                    totalPlayTime += episode.getDuration();
                }
                writer.write(title + " " + totalPlayTime + " " + numberOfEpisodes + "\n");
            }

        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file", e);
        }
    }


    public static void main(String[] args) {

        Series series;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Series.class.getResourceAsStream("/erettsegi/2020/oktober/4_sorozatok/lista.txt")))) {

            series = new Series(reader);

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }

        //series.getEpisodeList().forEach(System.out::println);
        series.printNumberOfList();
        series.printSeenPercent();
        series.printTotalTime();
        series.printNotWatchedEpisodesToDate();
        series.whichDay();
        series.summaWrite();

    }

}
