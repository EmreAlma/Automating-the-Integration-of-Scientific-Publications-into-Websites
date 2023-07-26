package com.example.pubsync.repository;

import com.example.pubsync.entity.Publications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PublicationsRepository extends JpaRepository<Publications, UUID> {

    @Query("FROM Publications WHERE year = ?1")
    List<Publications> findPublicationsByYear(String year);
}
