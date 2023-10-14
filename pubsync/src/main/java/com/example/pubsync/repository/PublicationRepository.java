package com.example.pubsync.repository;

import com.example.pubsync.entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PublicationRepository extends JpaRepository<Publication, UUID> {}