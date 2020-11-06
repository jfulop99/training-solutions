package week02;

import java.util.ArrayList;
import java.util.List;

public class Office {
    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meetingRoom){
            meetingRooms.add(meetingRoom);
    }

    public void printNames(){
        for (MeetingRoom elem: meetingRooms) {
            System.out.println(elem.getName());
        }
    }

    public void printNamesReverse(){
        for (int i = meetingRooms.size() - 1; i <=0; i--){
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printEvenNames(){
        for (int i = 0; i < meetingRooms.size(); i+=2){
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printAreas(){
        for (MeetingRoom elem: meetingRooms) {
            System.out.println(elem.getName() + " - " + elem.getLength() + " - " + elem.getWidht() + " - " + elem.getArea());
        }
    }

    public void printMeetingRoomsWithName(String name){
        int i = meetingRooms.indexOf(name);
        System.out.println("Length: " + meetingRooms.get(i).getLength() + " - Width: " + meetingRooms.get(i).getWidht() + " - Area: " + meetingRooms.get(i).getArea());
    }

    public void printMeetingRoomsContains(String part){
        String temp;
        for (MeetingRoom elem: meetingRooms) {
            temp = elem.getName().toUpperCase();
            if (temp.contains(part.toUpperCase())){
                System.out.println("Name: " + elem.getName() + " - Length: " + elem.getLength() + " - Width: " + elem.getWidht() + " - Area: " + elem.getArea());
            }
        }
    }

    public void printAreasLargerThan(int area){
        for (MeetingRoom elem: meetingRooms) {
            if (elem.getArea() > area){
                System.out.println("Name: " + elem.getName() + " - Length: " + elem.getLength() + " - Width: " + elem.getWidht() + " - Area: " + elem.getArea());
            }
        }

    }

}
