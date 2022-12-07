package com.example.mangalibraryapp.controller;

import com.example.mangalibraryapp.entity.Manga;
import com.example.mangalibraryapp.repository.MangaRepository;
import com.example.mangalibraryapp.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class MangaController {

    @Autowired
    private MangaService service;

    public MangaController(MangaService service) {
        super();
        this.service = service;
    }

    @GetMapping("/library")
    public String viewMangaList(Model model){
        List<Manga> listManga = service.getAllManga();
        model.addAttribute("listManga", listManga);
        return "library";
    }

    @GetMapping("/library/new")
    public String addManga(Model model){
        Manga manga = new Manga();
        model.addAttribute("manga",manga);
        return "manga_add_form";
    }

    @GetMapping("/library/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model){
        model.addAttribute("manga",service.getMangaById(id));
        return "manga_edit_form";
    }

    @PostMapping("/library")
    public String saveMange(@ModelAttribute("Manga") Manga manga){
        service.saveManga(manga);
        return "redirect:library";
    }

    @PostMapping("/library/{id}")
    public String updateUser(@PathVariable long id,
                             @ModelAttribute("manga") Manga manga, Model model){

        //get student from databse from id
        Manga existingManga = service.getMangaById(id);
        existingManga.setId(id);
        existingManga.setName(manga.getName());
        existingManga.setGenre(manga.getGenre());
        existingManga.setVolume(manga.getVolume());
        existingManga.setMangaka(manga.getMangaka());
        existingManga.setUsername(manga.getUsername());

        //save updated student object
        service.updateManga(existingManga);
        return "redirect:/library";
    }

    @GetMapping("/library/{id}")
    public String deleteStudent(@PathVariable Long id){
        service.deleteMangaById(id);
        return "redirect:/library";
    }



}
