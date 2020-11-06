package week02;

import java.util.ArrayList;
import java.util.List;

public class Office {
    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meetingRoom){
            meetingRooms.add(meetingRoom);
    }

    public void printNames(){
        for (MeetingRoom meetingRoom: meetingRooms) {
            System.out.println(meetingRoom.getName());
        }
    }

    public void printNamesReverse(){
        for (int i = meetingRooms.size() - 1; i >=0; i--){
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printEvenNames(){
        for (int i = 1; i < meetingRooms.size(); i+=2){
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printAreas(){
        for (MeetingRoom meetingRoom: meetingRooms) {
            System.out.println(meetingRoom.getName() + " - " + meetingRoom.getLength() + " - " + meetingRoom.getWidht() + " - " + meetingRoom.getArea());
        }
    }

    public void printMeetingRoomsWithName(String name){
        int i = meetingRooms.indexOf(name);
        for (MeetingRoom meetingRoom:meetingRooms) {
            if (name.equals(meetingRoom.getName())){
                System.out.println("Length: " + meetingRoom.getLength() + " - Width: " + meetingRoom.getWidht() + " - Area: " + meetingRoom.getArea());
            }
        }

    }

    public void printMeetingRoomsContains(String part){
        String temp;
        for (MeetingRoom meetingRoom: meetingRooms) {
            if (meetingRoom.getName().toUpperCase().indexOf(part.toUpperCase()) >= 0){
//                System.out.print("Name: " + meetingRoom.getName()); // Ha kell az összes előfordulás szükség lehet a névre is
                System.out.println(" - Length: " + meetingRoom.getLength() + " - Width: " + meetingRoom.getWidht() + " - Area: " + meetingRoom.getArea());
                return; // mert csak az első előfordulást kéri a leírás
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
