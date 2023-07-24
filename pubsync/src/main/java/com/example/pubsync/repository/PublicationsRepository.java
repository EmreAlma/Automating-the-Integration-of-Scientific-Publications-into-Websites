package com.example.pubsync.repository;

import com.example.pubsync.entity.Publications;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublicationsRepository extends JpaRepository<Publications, UUID> {
}
