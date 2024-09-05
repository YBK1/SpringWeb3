package com.example.batchweb3j.domain.document.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.batchweb3j.domain.document.model.Document;

import lombok.RequiredArgsConstructor;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
