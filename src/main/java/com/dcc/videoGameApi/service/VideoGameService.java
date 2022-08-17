package com.dcc.videoGameApi.service;

import com.dcc.videoGameApi.models.VideoGame;
import com.dcc.videoGameApi.repository.VideoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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
    public Map<String, Double> GetTotalSalesByYear(Integer year){
        // Number of games sold per console since year (Year is Integer value)
        List<VideoGame> gameSample = videoGameRepository.findAll().stream().filter(g -> g.getYear() >= year).toList();
        // Filter games for all that start at inputted year
        List<String> consoleList = gameSample.stream().map(g -> g.getPlatform()).toList();
        List<String> uniqueConsoles = consoleList.stream().distinct().collect(Collectors.toList());
        Map<String, Double> finalMap = new HashMap<String, Double>();
        for(String console : uniqueConsoles){
            Double totalSales = gameSample.stream().filter(g -> g.getPlatform().equals(console)).mapToDouble(g -> g.getGlobalsales()).sum();
            finalMap.put(console, totalSales);
        }
        return finalMap;
    }

    public Map<String, Double> GetGameSales(String game){
        //Must provide exact game name match (separate from search functionality)
        Map<String, Double> consoleSales = new HashMap<String, Double>();
        List<VideoGame> matchingGames = videoGameRepository.findAll().stream().filter(g-> g.getName().equals(game)).toList();
        List<String> gameConsoles = matchingGames.stream().map(g -> g.getPlatform()).distinct().collect(Collectors.toList());
        for (String console: gameConsoles) {
            Double sales = matchingGames.stream().filter(g->g.getPlatform().equals(console)).mapToDouble(g -> g.getGlobalsales()).sum();
            consoleSales.put(console, sales);
        }

        return consoleSales;
    }

    public List<VideoGame> SearchGames(String search){

        List<VideoGame> searchResults = videoGameRepository.findAll().stream().filter(g-> g.getName().toLowerCase().contains(search.toLowerCase())).toList();
        return searchResults;
    }

}
