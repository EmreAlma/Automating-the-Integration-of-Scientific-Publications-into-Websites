package com.example.pubsync.repository;

import com.example.pubsync.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public class AuthorsRepository {
    @Repository
    public interface AuthorRepository extends JpaRepository<Authors, UUID> {
    }
}
