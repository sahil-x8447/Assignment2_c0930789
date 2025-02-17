import org.example.BlogPost;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Test class for the BlogPost class
class BlogPostTest {

    // Test to ensure a valid BlogPost is created
    @Test
    void testValidBlogPostCreation() {
        BlogPost post = BlogPost.builder()
                .id("post")
                .authorId("author20")
                .postContent("This is a test post.")
                .build();

        assertNotNull(post); // Ensure the object is created
        assertEquals("post", post.getId()); // Ensure the ID is correct
    }

    // Test to check if exception is thrown when ID is null
    @Test
    void testNullIdThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BlogPost.builder()
                    .id(null)
                    .authorId("author20")
                    .postContent("This is a test post.")
                    .build();
        });
        assertEquals("ID cannot be null", exception.getMessage()); // Verify the exception message
    }

    // Test to check if exception is thrown when author ID is null
    @Test
    void testNullAuthorIdThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BlogPost.builder()
                    .id("post")
                    .authorId(null)
                    .postContent("This is a test post.")
                    .build();
        });
        assertEquals("Author ID cannot be null", exception.getMessage()); // Verify the exception message
    }
}