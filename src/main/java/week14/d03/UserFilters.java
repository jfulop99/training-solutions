package week14.d03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserFilters{

    private List<Predicate<User>> filters;

    public UserFilter createFilter(List<Predicate<User>> predicates) {
        // TODO
        return new UserFilter() {
            @Override
            public List<User> filter(List<User> users) {
                return users.stream().filter(predicates.stream().reduce(a -> true, Predicate::and)).collect(Collectors.toList());
            }
        };
    }

}
