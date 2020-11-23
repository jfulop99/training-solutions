package methodargvars.examstats;

public class ExamStats {

    private int maxPoints;

    public ExamStats(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getNumberOfTopGrades(int limitInPercent, int... results) {
        if (results == null || results.length == 0) {
            throw new IllegalArgumentException("Number of results must not be empty!");
        }
        int numberOfTopGrades = 0;
        for (int point: results) {
            if ( ((double)point / maxPoints) * 100.0 > limitInPercent) {
                numberOfTopGrades++;
            }
        }
        return numberOfTopGrades;
    }

    public boolean hasAnyFailed(int limitInPercent, int... results) {
        if (results == null || results.length == 0) {
            throw new IllegalArgumentException("Number of results must not be empty!");
        }
        for (int point: results) {
            if ( ((double)point / maxPoints) * 100.0 < limitInPercent) {
                return true;
            }
        }
        return false;
    }
}
