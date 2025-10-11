package com.incompetence.playnow.repositories;

import com.incompetence.playnow.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MusicRepository extends JpaRepository<Music, Long> {
    List<Music> findByTitleContainingIgnoreCase(String title);
}
