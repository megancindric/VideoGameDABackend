package com.dcc.videoGameApi.service;

import com.dcc.videoGameApi.models.VideoGame;
import com.dcc.videoGameApi.repository.VideoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class VideoGameService {

    @Autowired
    private VideoGameRepository videoGameRepository;

    public long GetCountOfGames(){
        return videoGameRepository.count();
    }

    public List<VideoGame> GetAllGames() {

        return videoGameRepository.findAll().stream().toList();
    }
    public VideoGame GetById(Integer id){
        return videoGameRepository.findById(id).orElse(null);
    }
    public String GetInvestmentByYear(Integer year){
        // Number of games sold per console since year (Year is Integer value)
        List<VideoGame> game_sample = videoGameRepository.findAll().stream().filter(g -> g.getYear() >= year).toList();
        // Filter games for all that start at inputted year
        List<String> console_list = game_sample.stream().map(g -> g.getPlatform()).sorted().toList();
        //Mapping to just console names, list of strings
        int highest_count = 0;
        int current_count = 0;
        String highest_console = "";
        String last_game = "";
        for (String game: console_list){
            if (game.equals(last_game)){
                current_count++;

            } else if (current_count> highest_count){
                highest_console = game;
                highest_count = current_count;
            }
            last_game = game;
        }
        // Get mode (most frequent value, may need to get count)
        //Loop through console li
        // Return name of highest count
        // There is more efficient method involving Collectors
        // Creating a hashmap of console, and corresponding frequency
        return highest_console;
    }


}
