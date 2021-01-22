package lambdaintro;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SocialNetwork {

    List<Member> members;

    public SocialNetwork(List<Member> members) {
        if (members == null || members.isEmpty()) {
            throw new IllegalArgumentException("Invalid member list");
        }
        this.members = new ArrayList<>(members);
    }

    public List<Member> findMembersBy(Predicate<Member> conditon) {

        return members.stream().filter(conditon).collect(Collectors.toList());

    }

    public void applyToSelectedMembers(Predicate<Member> condition, Consumer<Member> operation)  {

        members.stream().filter(condition).collect(Collectors.toList()).forEach(operation);

    }

    public <T> List<T> transformMembers(Function<Member, T> function) {

        List<T> result = new ArrayList<>();

        members.forEach(item-> result.add(function.apply(item)));

        return result;
    }

}
