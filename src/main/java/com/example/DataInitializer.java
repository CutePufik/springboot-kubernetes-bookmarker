package com.example;

import com.example.domain.Bookmark;
import com.example.repository.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final BookmarkRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        List<Bookmark> bookmarks = List.of(
                new Bookmark(null, "Spring Boot Documentation", "https://spring.io/projects/spring-boot", Instant.now()),
                new Bookmark(null, "Baeldung - Spring Tutorials", "https://www.baeldung.com/spring-tutorial", Instant.now().minusSeconds(3600)),
                new Bookmark(null, "Java 21 Features", "https://openjdk.org/projects/jdk/21/", Instant.now().minusSeconds(7200)),
                new Bookmark(null, "Microservices Patterns", "https://microservices.io/patterns/index.html", Instant.now().minusSeconds(10800)),
                new Bookmark(null, "Docker Documentation", "https://docs.docker.com/", Instant.now().minusSeconds(14400)),
                new Bookmark(null, "Kubernetes Tutorial", "https://kubernetes.io/docs/tutorials/", Instant.now().minusSeconds(18000)),
                new Bookmark(null, "PostgreSQL Guide", "https://www.postgresql.org/docs/", Instant.now().minusSeconds(21600)),
                new Bookmark(null, "GitHub Actions", "https://docs.github.com/en/actions", Instant.now().minusSeconds(25200)),
                new Bookmark(null, "Spring Data JPA", "https://spring.io/projects/spring-data-jpa", Instant.now().minusSeconds(28800)),
                new Bookmark(null, "REST API Design", "https://restfulapi.net/", Instant.now().minusSeconds(32400)),
                new Bookmark(null, "Maven Repository", "https://mvnrepository.com/", Instant.now().minusSeconds(36000)),
                new Bookmark(null, "Gradle Build Tool", "https://gradle.org/", Instant.now().minusSeconds(39600)),
                new Bookmark(null, "IntelliJ IDEA Guide", "https://www.jetbrains.com/idea/", Instant.now().minusSeconds(43200)),
                new Bookmark(null, "Git Cheat Sheet", "https://education.github.com/git-cheat-sheet-education.pdf", Instant.now().minusSeconds(46800)),
                new Bookmark(null, "Hibernate ORM", "https://hibernate.org/orm/", Instant.now().minusSeconds(50400)),
                new Bookmark(null, "Thymeleaf Documentation", "https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html", Instant.now().minusSeconds(54000)),
                new Bookmark(null, "Lombok Project", "https://projectlombok.org/", Instant.now().minusSeconds(57600)),
                new Bookmark(null, "JUnit 5 Guide", "https://junit.org/junit5/docs/current/user-guide/", Instant.now().minusSeconds(61200)),
                new Bookmark(null, "Mockito Framework", "https://site.mockito.org/", Instant.now().minusSeconds(64800)),
                new Bookmark(null, "AssertJ Assertions", "https://assertj.github.io/doc/", Instant.now().minusSeconds(68400))
        );

        repository.saveAll(bookmarks);
    }
}