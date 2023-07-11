package com.example.pubsync.repository;

import com.example.pubsync.entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorRepository extends JpaRepository<Authors, UUID> {
}
