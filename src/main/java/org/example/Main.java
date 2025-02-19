package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Load JSON files from resources
            ClassLoader classLoader = Main.class.getClassLoader();
            InputStream personStream = classLoader.getResourceAsStream("person.json");
            InputStream blogPostStream = classLoader.getResourceAsStream("blogPosts.json");

            if (personStream == null || blogPostStream == null) {
                throw new IOException("One or more JSON files not found in resources folder.");
            }

            // Deserialize JSON files
            List<Person> persons = objectMapper.readValue(personStream, new TypeReference<List<Person>>() {});
            List<BlogPost> blogPosts = objectMapper.readValue(blogPostStream, new TypeReference<List<BlogPost>>() {});

            // Create Blog instance
            Blog blog = new Blog(blogPosts, persons);

            // Example usage of getPostsByAuthorAge
            Integer ageToSearch = 23;
            List<String> postsByAge = blog.getPostsByAuthorAge(ageToSearch);

            // Print results
            System.out.println("Posts by authors aged " + ageToSearch + ": " + postsByAge);
            System.out.println("Total Blog Posts: " + blogPosts.size());
            System.out.println("Total Contributors: " + persons.size());

        } catch (IOException e) {
            System.err.println("Error reading JSON files: " + e.getMessage());
        }
    }
}
