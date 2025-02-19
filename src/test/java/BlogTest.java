import org.example.Blog;
import org.example.BlogPost;
import org.example.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BlogTest {

    // Test for empty posts and contributors
    @Test
    void testEmptyInput() {
        Blog blog = new Blog(List.of(), List.of());

        List<String> posts = blog.getPostsByAuthorAge(23);

        assertTrue(posts.isEmpty(), "Expected empty list for empty input.");
    }

    // Test for missing author IDs (author ID does not match any contributor's ID)
    @Test
    void testMissingAuthorId() {
        Person sahil = Person.builder()
                .id("1")
                .firstName("Sahil")
                .lastName("Sharma")
                .age(23)
                .gender("Male")
                .build();

        BlogPost post = BlogPost.builder()
                .id("post1")
                .authorId("2") // Non-matching author ID
                .postContent("This is a test post.")
                .build();

        Blog blog = new Blog(List.of(post), List.of(sahil));

        List<String> posts = blog.getPostsByAuthorAge(23);

        assertTrue(posts.isEmpty(), "Expected empty list when author ID is missing.");
    }

    // Test for invalid data (age mismatch)
    @Test
    void testInvalidAgeData() {
        Person sahil = Person.builder()
                .id("1")
                .firstName("Sahil")
                .lastName("Sharma")
                .age(23)
                .gender("Male")
                .build();

        BlogPost post = BlogPost.builder()
                .id("post1")
                .authorId("1")
                .postContent("This is a test post.")
                .build();

        Blog blog = new Blog(List.of(post), List.of(sahil));

        List<String> posts = blog.getPostsByAuthorAge(25); // Age mismatch

        assertTrue(posts.isEmpty(), "Expected empty list for non-matching age.");
    }

    // Test for valid association between author and blog post
    @Test
    void testValidAssociation() {
        Person sahil = Person.builder()
                .id("1")
                .firstName("Sahil")
                .lastName("Sharma")
                .age(23)
                .gender("Male")
                .build();

        BlogPost post = BlogPost.builder()
                .id("post1")
                .authorId("1") // Matching author ID
                .postContent("This is a test post.")
                .build();

        Blog blog = new Blog(List.of(post), List.of(sahil));

        List<String> posts = blog.getPostsByAuthorAge(23); // Correct age

        assertEquals(1, posts.size(), "Expected one post with matching author age.");
        assertTrue(posts.contains("post1"), "Expected post ID to be included in the result.");
    }

    // Test for multiple posts by the same author with matching age
    @Test
    void testMultiplePostsBySameAuthor() {
        Person sahil = Person.builder()
                .id("1")
                .firstName("Sahil")
                .lastName("Sharma")
                .age(23)
                .gender("Male")
                .build();

        BlogPost post1 = BlogPost.builder()
                .id("post1")
                .authorId("1") // Matching author ID
                .postContent("This is a test post.")
                .build();

        BlogPost post2 = BlogPost.builder()
                .id("post2")
                .authorId("1") // Matching author ID
                .postContent("This is another test post.")
                .build();

        Blog blog = new Blog(List.of(post1, post2), List.of(sahil));

        List<String> posts = blog.getPostsByAuthorAge(23); // Correct age

        assertEquals(2, posts.size(), "Expected two posts by the same author with matching age.");
        assertTrue(posts.contains("post1"), "Expected post1 to be included.");
        assertTrue(posts.contains("post2"), "Expected post2 to be included.");
    }

    // Test for no matching posts with contributors having different ages
    @Test
    void testNoMatchingPostsForAge() {
        Person sahil = Person.builder()
                .id("1")
                .firstName("Sahil")
                .lastName("Sharma")
                .age(23)
                .gender("Male")
                .build();

        Person johnCena = Person.builder()
                .id("2")
                .firstName("John")
                .lastName("Cena")
                .age(39)
                .gender("Male")
                .build();

        BlogPost post1 = BlogPost.builder()
                .id("post1")
                .authorId("1")
                .postContent("This is a test post.")
                .build();

        BlogPost post2 = BlogPost.builder()
                .id("post2")
                .authorId("2")
                .postContent("This is another test post.")
                .build();

        Blog blog = new Blog(List.of(post1, post2), List.of(sahil, johnCena));

        List<String> posts = blog.getPostsByAuthorAge(40); // No matching age

        assertTrue(posts.isEmpty(), "Expected empty list for no matching age.");
    }
}
