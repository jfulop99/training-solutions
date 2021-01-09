package activity;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Track {

    public static final String TAGNAME_TRKPT = "trkpt";
    private List<TrackPoint> trackPoints = new ArrayList<>();


    public List<TrackPoint> getTrackPoints() {
        return new ArrayList<>(trackPoints);
    }

    public void addTrackPoint(TrackPoint trackPoint) {
        if (trackPoint == null) {
            throw new IllegalArgumentException("Trackpoint is null");
        }
        trackPoints.add(trackPoint);
    }

    public double getDistance() {
        double distance = 0.0;
        TrackPoint prevTrackPoint =trackPoints.get(0);
        for (TrackPoint trackPoint:trackPoints) {
            distance += trackPoint.getDistanceFrom(prevTrackPoint);
            prevTrackPoint = trackPoint;
        }
        return distance;
    }

    public double getFullElevation() {
        double fullElevation = 0.0;
        TrackPoint prevTrackPoint =trackPoints.get(0);
        for (TrackPoint trackPoint:trackPoints) {
            double elevation = trackPoint.getElevation();
            double prevElevation = prevTrackPoint.getElevation();
            if (elevation > prevElevation) {
                fullElevation += (elevation - prevElevation);
            }
            prevTrackPoint = trackPoint;
        }
        return fullElevation;
    }

    public double getFullDecrease() {
        double fullDecrease = 0.0;
        TrackPoint prevTrackPoint =trackPoints.get(0);
        for (TrackPoint trackPoint:trackPoints) {
            double prevLevel = prevTrackPoint.getElevation();
            double level = trackPoint.getElevation();
            if (level < prevLevel) {
                fullDecrease += prevLevel - level;
            }
            prevTrackPoint = trackPoint;
        }
        return fullDecrease;
    }

    public Coordinate findMinimumCoordinate() {

        double minLong = 180D;
        double minLat = 90D;

        for (TrackPoint trackPoint:trackPoints) {
            double latitude = trackPoint.getCoordinate().getLatitude();
            double longitude = trackPoint.getCoordinate().getLongitude();
            if (latitude < minLat) {
                minLat = latitude;
            }
            if (longitude < minLong) {
                minLong = longitude;
            }
        }

        return new Coordinate(minLat, minLong);
    }

    public Coordinate findMaximumCoordinate() {

        double maxLong = -180D;
        double maxLat = -90D;

        for (TrackPoint trackPoint:trackPoints) {
            double latitude = trackPoint.getCoordinate().getLatitude();
            double longitude = trackPoint.getCoordinate().getLongitude();
            if (latitude > maxLat) {
                maxLat = latitude;
            }
            if (longitude > maxLong) {
                maxLong = longitude;
            }
        }

        return new Coordinate(maxLat, maxLong);
    }

    public double getRectangleArea() {
        Coordinate topRightCorner = findMaximumCoordinate();
        Coordinate bottomLeftCorner = findMinimumCoordinate();

        double a = Math.abs(topRightCorner.getLatitude()) + Math.abs(bottomLeftCorner.getLatitude());
        double b = Math.abs(topRightCorner.getLongitude()) + Math.abs(bottomLeftCorner.getLongitude());

        return a * b;
    }

    public void loadFromGpx(InputStream inputStream) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
            String line ;
            Coordinate point = null;
            while ((line = reader.readLine()) != null) {
                if (line.trim().startsWith("<trkpt")) {
                    point = parseCoordinate(line);
                }
                else if (line.trim().startsWith("<ele>")) {
                    trackPoints.add(parseElevation(line, point));
                }
            }

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }

    }

    private TrackPoint parseElevation(String line, Coordinate coordinate) {

        double elevation ;
        String[] parts = line.split("[<>]");
        elevation = Double.parseDouble(parts[2]);
        return new TrackPoint(coordinate,elevation);
    }

    private Coordinate parseCoordinate(String line) {
        String[] parts = line.split("\"");
        double latitude = Double.parseDouble(parts[1]);
        double longitude = Double.parseDouble(parts[3]);
        return new Coordinate(latitude, longitude);
    }

    public void loadFromGpxXmlParser(InputStream inputStream) {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newDefaultInstance();
        Document document;
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(inputStream);
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException("Parser configuration error", e);
        } catch (SAXException e) {
            throw new IllegalStateException("SAX", e);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }

        NodeList nodeList = document.getElementsByTagName(TAGNAME_TRKPT);
        int length = nodeList.getLength();

        for (int i = 0; i < length; i++) {
            String lat = nodeList.item(i).getAttributes().getNamedItem("lat").getTextContent();
            String lon = nodeList.item(i).getAttributes().getNamedItem("lon").getTextContent();
            NodeList childNodes = nodeList.item(i).getChildNodes();
            double ele = parseChild(childNodes);
            trackPoints.add(new TrackPoint(new Coordinate(Double.parseDouble(lat), Double.parseDouble(lon)), ele));
        }
    }

    private double parseChild(NodeList childNodes) {
        double ele = 0.0;
        for (int j = 0; j < childNodes.getLength(); j++) {
            if (childNodes.item(j).getNodeName().equals("ele")) {
                ele = Double.parseDouble(childNodes.item(j).getFirstChild().getNodeValue());
            }
        }
        return ele;
    }

    public static void main(String[] args) {
        Track track = new Track();
        track.loadFromGpxXmlParser(Track.class.getResourceAsStream("/track.gpx"));
        for (TrackPoint point: track.getTrackPoints()) {
            System.out.println(String.format("%-9s %-9s %-5s", point.getCoordinate().getLatitude(), point.getCoordinate().getLongitude(), point.getElevation()));
        }
    }
}
