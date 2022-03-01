package com.drumond.workshopmongo.config;

import com.drumond.workshopmongo.domain.Post;
import com.drumond.workshopmongo.domain.User;
import com.drumond.workshopmongo.dto.AuthorDTO;
import com.drumond.workshopmongo.dto.CommentDTO;
import com.drumond.workshopmongo.repository.PostRepository;
import com.drumond.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

/**
 * Class that provides the first system data when it starts.
 */
@Configuration
public class Instantiation implements CommandLineRunner {
    /**
     * Dependency Injection to access CRUD methods for users
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Dependency Injection to access CRUD methods for posts
     */
    @Autowired
    private PostRepository postRepository;

    /**
     * Callback used to run the bean.
     * Override method to instantiate 3 users everytime that the application is started.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User mary = new User("Mary Brown", "mary@email.com");
        User alex = new User("Alex Green", "alex@email.com");
        User bob = new User("Bob Grey", "bob@email.com");

        userRepository.saveAll(Arrays.asList(mary, alex, bob));

        Post post1 = new Post(simpleDateFormat.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(mary));
        Post post2 = new Post(simpleDateFormat.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(mary));

        CommentDTO comment1 = new CommentDTO("Boa viagem mano!", simpleDateFormat.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO comment2 = new CommentDTO("Aproveite", simpleDateFormat.parse("22/03/2018"), new AuthorDTO(bob));
        CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia!", simpleDateFormat.parse("23/03/2018"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(comment1, comment2));
        post2.getComments().addAll(List.of(comment3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        mary.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(mary);
    }
}