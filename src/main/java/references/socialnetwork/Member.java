package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private List<Member> connections = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Member> getConnections() {
        return connections;
    }

    public void connectionMember(Member member){
        connections.add(member);
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                " connected='" + connectedNames() + '\'' +
                '}';
    }

    public List<String> connectedNames(){
        List<String> connectedNames = new ArrayList<>();
        for (Member connected:connections){
            connectedNames.add(connected.getName());
        }
        return connectedNames;
    }
}
