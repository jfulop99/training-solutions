package week14.d03;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserFilters {

    public UserFilter createFilter(List<Predicate<User>> predicates) {
        // TODO
        return users -> users.stream().filter(predicates.stream().reduce(a -> true, Predicate::and)).collect(Collectors.toList());
    }

    public UserFilter createFilter2(List<Predicate<User>> predicates) {
        return users -> {
            final Iterator<User> userIter = users.iterator();
            while (userIter.hasNext()) {
                User user = userIter.next();
                boolean shouldRemove = false;
                for (Predicate<User> predicate : predicates) {
                    if (!predicate.test(user)) {
                        shouldRemove = true;
                    }
                }
                if (shouldRemove) {
                    userIter.remove();
                }
            }
            return users;
        };
    }
}
