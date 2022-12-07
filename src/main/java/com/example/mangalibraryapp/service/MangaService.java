package com.example.mangalibraryapp.service;

import com.example.mangalibraryapp.entity.Manga;

import java.util.List;

public interface MangaService {

    List<Manga> getAllManga();

    Manga saveManga(Manga manga);

    Manga getMangaById(Long id);

    Manga updateManga(Manga manga);

    void deleteMangaById(Long id);
}
