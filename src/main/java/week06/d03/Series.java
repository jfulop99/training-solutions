package week06.d03;

import java.util.List;

public class Series {

    public SeriesTypes calculateSeriesType(List<Integer> series) {
        if (series == null || series.size()<2) {
            throw new IllegalArgumentException("The series is null or too short!");
        }
        SeriesTypes seriesTypes;
        seriesTypes = series.get(0) < series.get(1) ? SeriesTypes.ASCENDING_SERIES : SeriesTypes.DESCENDING_SERIES;
        int counter = 1;
        while (counter < series.size()-1) {
            if ((series.get(counter + 1) - series.get(counter)) * seriesTypes.getFactor() < 0 ) {
                return SeriesTypes.UNSORTED_SERIES;
            }
            counter++;
        }
        return seriesTypes;
    }
}
