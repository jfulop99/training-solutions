package week15.d03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostFinder {

    private List<Post> posts;

    public PostFinder(List<Post> posts) {
        this.posts = new ArrayList<>(posts);
    }


    public List<Post> findPosts(String user) {

        return posts.stream()
                .filter(post -> post.getContent() != null)
                .filter(post -> post.getTitle() != null)
                .filter(post -> post.getDeletedAt() == null || post.getDeletedAt().isAfter(LocalDate.now()))
                .filter(post -> LocalDate.now().isAfter(post.getPublishedAt()) || post.getOwner().equals(user))
                .collect(Collectors.toList());

    }


    public static void main(String[] args) {

        List<Post> testData = List.of(
                new Post("My First Post", LocalDate.of(2018, 1, 6), LocalDate.of(2019, 6, 19), "Tartalom", "Pista"),
                new Post("My Article", LocalDate.of(2019, 3, 18), null, "Tartalom", "Pista"),
                new Post("I like Java", LocalDate.of(2020, 2, 20), null, "Tartalom", "Pista")
        );
        PostFinder postFinder = new PostFinder(testData);

        System.out.println(postFinder.findPosts("Béla"));
    }

}
