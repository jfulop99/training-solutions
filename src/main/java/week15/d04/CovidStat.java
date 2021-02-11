package week15.d04;

public class CovidStat {

    private int year;
    private int week;
    private int cases;

    public CovidStat(String yearAndWeek, String cases) {
        String[] parts = yearAndWeek.split("-");
        this.year = Integer.parseInt(parts[0]);
        this.week = Integer.parseInt(parts[1]);
        this.cases = Integer.parseInt(cases);
    }


    public int getYear() {
        return year;
    }

    public int getWeek() {
        return week;
    }

    public int getCases() {
        return cases;
    }

    @Override
    public String toString() {
        return "CovidStat{" +
                "year=" + year +
                ", week=" + week +
                ", cases=" + cases +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CovidStat covidStat = (CovidStat) o;

        if (year != covidStat.year) return false;
        if (week != covidStat.week) return false;
        return cases == covidStat.cases;
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + week;
        result = 31 * result + cases;
        return result;
    }
}
