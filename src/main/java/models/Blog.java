import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

// The Blog class represents a blog containing posts and contributors.
@Getter
@ToString
@EqualsAndHashCode
public class Blog {
    // List of BlogPost objects representing the posts in the blog
    private final List<BlogPost> posts;

    // List of Person objects representing the contributors to the blog
    private final List<Person> contributors;

    // Constructor to initialize the Blog with posts and contributors
    public Blog(List<BlogPost> posts, List<Person> contributors) {
        this.posts = posts;
        this.contributors = contributors;
    }
}
