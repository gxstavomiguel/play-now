package com.incompetence.playnow.controller;

import com.incompetence.playnow.entity.Music;
import com.incompetence.playnow.service.MusicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/music")
public class MusicController {

    private final MusicService musicService;

    @PostMapping
    public ResponseEntity<Music> save(@Valid @RequestBody Music music) {
        Music newMusic = musicService.save(music);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMusic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Music> update(@PathVariable Long id, @Valid @RequestBody Music music) {
        return musicService.update(music, id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Music>> findAll() {
        List<Music> musicList = musicService.findAll();
        return ResponseEntity.ok(musicList); // Retorna [] se vazio
    }

    @GetMapping("/search")
    public ResponseEntity<List<Music>> findByTitle(@RequestParam Optional<String> title) {
        List<Music> musicList = title.map(musicService::findByTitle)
                .orElseGet(musicService::findAll);
        return ResponseEntity.ok(musicList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        boolean deleted = musicService.deleteById(id);
        return deleted ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
