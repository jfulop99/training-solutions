package lambdaoptional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class SocialNetwork {

    private List<Member> memberList;

    public SocialNetwork(List<Member> memberList) {
        this.memberList = new ArrayList<>(memberList);
    }

    public Optional<Member> findFirst(Predicate<Member> condotion) {

        return memberList.stream().findFirst().filter(condotion);

    }

    public Optional<Double> averageNumberOfSkills() {

        if (memberList.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of( ((double) memberList.stream().mapToInt(member -> member.getSkills().size()).sum()) / memberList.size());
    }

}
