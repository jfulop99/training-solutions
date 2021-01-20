package lambdaintro;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {

    List<Member> members;

    public SocialNetwork(List<Member> members) {
        if (members == null || members.isEmpty()) {
            throw new IllegalArgumentException("Invalid member list");
        }
        this.members = new ArrayList<>(members);
    }

    public List<Member> findMembersBy() {


        return  null;
    }

    public void applyToSelectedMembers() {

    }

    public List transformMembers() {

        List result = new ArrayList();



        return result;
    }

}
