package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


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

    public List<String> getPostsByAuthorAge(Integer age) {
        return posts.stream()
                .filter(post -> contributors.stream()
                        .anyMatch(person -> person.getId().equals(post.getAuthorId()) && Objects.equals(person.getAge(), age)))
                .map(BlogPost::getId)
                .collect(Collectors.toList());
    }

}