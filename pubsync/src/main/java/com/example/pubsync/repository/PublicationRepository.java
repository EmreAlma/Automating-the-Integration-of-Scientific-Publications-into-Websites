package com.example.pubsync.repository;

import com.example.pubsync.entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

/**
 * Repository interface for handling database operations related to Publication entities.
 * Extends JpaRepository for standard CRUD operations and includes custom queries specific to publications.
 */
public interface PublicationRepository extends JpaRepository<Publication, UUID> {

    /**
     * Retrieves a distinct list of publication years in descending order.
     * Useful for organizing publications by year.
     * @return A list of distinct publication years.
     */
    @Query("SELECT DISTINCT p.year FROM Publication p ORDER BY p.year DESC")
    List<Integer> findDistinctPublicationYears();

    /**
     * Finds all publications from a specific year.
     * @param year The year for which publications are to be retrieved.
     * @return A list of publications from the specified year.
     */
    @Query("SELECT p FROM Publication p WHERE p.year = ?1")
    List<Publication> findAllByYear(String year);
}