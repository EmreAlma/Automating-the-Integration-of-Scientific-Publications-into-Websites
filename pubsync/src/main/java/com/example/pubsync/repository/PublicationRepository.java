package com.example.pubsync.repository;

import com.example.pubsync.entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PublicationRepository extends JpaRepository<Publication, UUID> {

    /*@Query("FROM Publication WHERE year = ?1")
    List<Publication> findPublicationsByYear(String year);*/
}
