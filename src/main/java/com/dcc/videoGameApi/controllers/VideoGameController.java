package com.dcc.videoGameApi.controllers;

import com.dcc.videoGameApi.models.VideoGame;
import com.dcc.videoGameApi.repository.VideoGameRepository;
import com.dcc.videoGameApi.service.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class VideoGameController {

    @Autowired
    private VideoGameService service;

    //Example endpoint to return count of all games on DB. Should return 10000 in Postman
    @GetMapping("/count")
    public long GetCount(){
        return service.GetCountOfGames();
    }

    @GetMapping("/all")
    public List<VideoGame> GetAllGames() { return service.GetAllGames();}

    @GetMapping("/getById/{id}")
    public VideoGame FindGameById(@PathVariable Integer id){
        return service.GetById(id);
    }

    @GetMapping("/getTotalSalesByYear/{year}")

    public Map<String, Double> GetTotalSalesByYear(@PathVariable Integer year){
        return service.GetTotalSalesByYear(year);
    }

    @GetMapping("/getGameSales/{game}")


    public Map<String, Double> GetGameSales(@PathVariable String game){
        return service.GetGameSales(game);
    }

    @GetMapping("/searchGames/{search}")

    public List<VideoGame> SearchGames(@PathVariable String search){
        return service.SearchGames(search);
    }
}
