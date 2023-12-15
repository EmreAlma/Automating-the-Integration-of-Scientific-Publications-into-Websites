package com.example.pubsync.repository;

import com.example.pubsync.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for performing CRUD operations on Author entities.
 * Extends JpaRepository to leverage Spring Data's built-in methods for data access.
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
