package com.dcc.videoGameApi.repository;

import com.dcc.videoGameApi.models.VideoGame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoGameRepository extends JpaRepository<VideoGame, Integer> {
}
