package com.example.mangalibraryapp.service.impl;

import com.example.mangalibraryapp.entity.Manga;
import com.example.mangalibraryapp.repository.MangaRepository;
import com.example.mangalibraryapp.service.MangaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MangaServiceImpl implements MangaService {

    private MangaRepository mangaRepository;

    public MangaServiceImpl(MangaRepository mangaRepository) {
        super();
        this.mangaRepository = mangaRepository;
    }

    @Override
    public List<Manga> getAllManga() {
        return mangaRepository.findAll();
    }

    @Override
    public Manga saveManga(Manga manga) {
        return mangaRepository.save(manga);
    }

    @Override
    public Manga getMangaById(Long id) {
        return mangaRepository.findById(id).get();
    }

    @Override
    public Manga updateManga(Manga manga) {
        return mangaRepository.save(manga);
    }

    @Override
    public void deleteMangaById(Long id) {
        mangaRepository.deleteById(id);
    }
}
