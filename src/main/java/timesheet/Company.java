package timesheet;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Company {


    private final List<Employee> employees;

    private final List<Project> projects;

    private final List<TimeSheetItem> timeSheetItems;

    public Company(InputStream employeesFile, InputStream projectFile) {

        if (employeesFile == null || projectFile == null) {
            throw new IllegalArgumentException("File cannot be null");
        }

        employees = new ArrayList<>();
        projects = new ArrayList<>();
        timeSheetItems = new ArrayList<>();

        readDataFile(employeesFile, DataType.EMPLOYEE);

        readDataFile(projectFile, DataType.PROJECT);
    }


    private void readDataFile(InputStream file, DataType dataType) {
        try ( BufferedReader reader = new BufferedReader (new InputStreamReader(file, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                parseLine(line, dataType);
            }
        } catch (NullPointerException npe) {
            throw new IllegalStateException("Cannot find file", npe);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    private void parseLine(String line, DataType dataType) {
        if (dataType == DataType.PROJECT) {
            projects.add(new Project(line));
        }
        if (dataType == DataType.EMPLOYEE) {
            String[] name = line.split(" ");
            employees.add(new Employee(name[0],name[1]));
        }
    }


    public void addTimeSheetItem(Employee employee, Project project, LocalDateTime startDate, LocalDateTime endDate) {

        try {
            timeSheetItems.add(new TimeSheetItem(employee, project, startDate, endDate));
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Something went wrong", e);
        }
    }


    public List<ReportLine> calculateProjectByNameYearMonth(String fullName, int year, int month) {

        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Cannot be blank");
        }
        if (year < 1000 || year > 3000) {
            throw new IllegalArgumentException("Must be between 1000 - 3000");
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Must be between 1 - 12");
        }

        List<TimeSheetItem> filtered;

        filtered = filterByNameYearMonth(fullName, year, month);

//        filtered = timeSheetItems.stream().filter(timeSheetItem -> timeSheetItem.getEmployee().getName().equals(fullName) &&
//                                  year == timeSheetItem.getBeginDate().getYear() &&
//                                  month == timeSheetItem.getBeginDate().getMonthValue()).collect(Collectors.toList());

        if (filtered.isEmpty()) {
            throw new IllegalArgumentException("Does not match the search criteria");
        }

        List<ReportLine> report;
        report = fillReportWithProject(filtered);

        return report;
    }


    private List<TimeSheetItem> filterByNameYearMonth(String fullName, int year, int month) {
        List<TimeSheetItem> filteredList = new ArrayList<>();
        for (TimeSheetItem item:timeSheetItems) {
            if (item.getEmployee().getName().equals(fullName) && item.getBeginDate().getYear() == year && item.getBeginDate().getMonthValue() == month) {
                filteredList.add(item);
            }
        }
        return filteredList;
    }


    private List<ReportLine> fillReportWithProject(List<TimeSheetItem> filteredList) {

        List<ReportLine> report = new ArrayList<>();

        for (Project item: projects) {
            long timePerProject = calculateTimePerProject(item, filteredList);
            report.add(new ReportLine(item, timePerProject));
        }

        return report;
    }


    private long calculateTimePerProject(Project project, List<TimeSheetItem> filteredList) {

        long time = 0;

        for (TimeSheetItem item:filteredList ) {
            if (project.getName().equals(item.getProject().getName())) {
                time += item.hoursBetweenDates();
            }
        }

        return time;
    }


    public void printToFile(String fullName, int year, int month, Path path) {

        try (BufferedWriter writer = Files.newBufferedWriter(path)){

            writeReportToFile(fullName, year, month, writer);

        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException("Something went wrong", iae);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        } catch (NullPointerException npe) {
            throw new IllegalStateException("Cannot find file", npe);
        }


    }

    private void writeReportToFile(String fullName, int year, int month, BufferedWriter writer) throws IOException {

        List<ReportLine> reportLines = calculateProjectByNameYearMonth(fullName, year, month);

        long fullTime = 0;
        StringBuilder sb = new StringBuilder();
        for (ReportLine line:reportLines) {
            if (line.getTime() > 0) {
                sb.append(line.toString());
                fullTime += line.getTime();
            }
        }
        writer.write(String.format("%s\t%d-%02d\t%d\n", fullName, year, month, fullTime));
        writer.write(sb.toString());
    }


    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }


    public List<Project> getProjects() {
        return new ArrayList<>(projects);
    }
}
