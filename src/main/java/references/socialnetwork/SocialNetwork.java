package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {
    private List<Member> members = new ArrayList<>();

    public void addMember(String name){
        members.add(new Member(name));
    }

    public Member findByName(String name){
        int index = 0;
        for (int i = 0; i < members.size(); i++) {
            if (name.equals(members.get(i).getName())){
                index = i;
            }
        }
        return members.get(index);
    }

    public void connect(String name, String otherName){
        Member memberOfName;
        Member memberOfOthername;

        memberOfName = findByName(name);
        memberOfOthername = findByName(otherName);
        memberOfName.connectionMember(memberOfOthername);
    }

    @Override
    public String toString() {
        return "SocialNetwork{" +
                "members=" + members +
                '}';
    }

    public List<String> bidirectionalConnections() {
        List<String> bidirectionalConnected = new ArrayList<>();
       for (Member member:members) {
           for (Member connected:member.getConnections()) {
               if (connected.getConnections().contains(member)){
                   bidirectionalConnected.add(member.getName() + " - " + connected.getName());
               }
           }
       }
        return bidirectionalConnected;
   }
}
