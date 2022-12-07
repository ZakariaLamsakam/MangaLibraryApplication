package com.example.mangalibraryapp.repository;

import com.example.mangalibraryapp.entity.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MangaRepository extends JpaRepository<Manga, Long> {

    @Query("SELECT u FROM Manga u WHERE u.name = ?1")
    Manga findByName(String email);

    @Query("SELECT u FROM Manga u WHERE u.id = ?1")
    Optional<Manga> findById(Long id);
}
