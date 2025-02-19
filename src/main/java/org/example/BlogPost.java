package org.example;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

// The BlogPost class represents a post in a blog.
@Getter
@ToString
@EqualsAndHashCode
@Builder
@Jacksonized
public class BlogPost {
    // Post ID, Author ID, and the content of the post
    private final String id;
    private final String authorId;
    private final String postContent;

    // Constructor with validation for ID and Author ID
    private BlogPost(String id, String authorId, String postContent) {
        if (id == null) throw new IllegalArgumentException("ID cannot be null");
        if (authorId == null) throw new IllegalArgumentException("Author ID cannot be null");

        this.id = id;
        this.authorId = authorId;
        this.postContent = postContent;
    }
}