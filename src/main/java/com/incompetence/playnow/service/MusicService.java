package com.incompetence.playnow.service;

import com.incompetence.playnow.entity.Music;
import com.incompetence.playnow.repositories.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
// Cria construtor via anotação
@RequiredArgsConstructor
public class MusicService {

    private final MusicRepository musicRepository;

    public Music save(Music music) {
        return musicRepository.save(music);
    }

    public Optional<Music> update(Music music, Long id) {
        return musicRepository.findById(id).map(existingMusic -> {
            existingMusic.setTitle(music.getTitle());
            existingMusic.setArtist(music.getArtist());
            existingMusic.setAlbum(music.getAlbum());
            existingMusic.setGenre(music.getGenre());
            existingMusic.setDurationSeconds(music.getDurationSeconds());
            return musicRepository.save(existingMusic);
        });
    }

    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    public List<Music> findByTitle(String title) {
        return musicRepository.findByTitleContainingIgnoreCase(title);
    }

    public boolean deleteById(Long id) {
        if (musicRepository.existsById(id)) {
            musicRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
