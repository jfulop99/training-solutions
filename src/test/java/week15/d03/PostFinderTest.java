package week15.d03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PostFinderTest {

    @Test
    void findPosts() {

        List<Post> testData = List.of(
                new Post("My First Post", LocalDate.of(2018, 1, 6), LocalDate.of(2019, 6, 19), "Tartalom", "Pista"),
                new Post("My Article", LocalDate.of(2019, 3, 18), null, "Tartalom", "Pista"),
                new Post("I like Java", LocalDate.of(2020, 2, 20), null, "Tartalom", "Pista"),
                new Post("I like Java 2.", LocalDate.of(2021, 2, 20), null, "Tartalom", "Pista")
        );
        PostFinder postFinder = new PostFinder(testData);

        assertEquals(3, postFinder.findPosts("Pista").size());
        assertEquals(2, postFinder.findPosts("Béla").size());
    }
}