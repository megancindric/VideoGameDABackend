package com.dcc.videoGameApi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;


@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name="videogames")
@NamedQuery(name="VideoGame.findAll", query="SELECT v FROM VideoGame v")
public class VideoGame implements Serializable {

    public VideoGame() {
    }

    public VideoGame(int id, int game_rank, String name, String platform, Integer year, String genre, String publisher, double northamericansales, double europesales, double japansales, double othersales, double globalsales) {
        this.id = id;
        this.game_rank = game_rank;
        this.name = name;
        this.platform = platform;
        this.year = year;
        this.genre = genre;
        this.publisher = publisher;
        this.northamericansales = northamericansales;
        this.europesales = europesales;
        this.japansales = japansales;
        this.othersales = othersales;
        this.globalsales = globalsales;
    }

    @Id
    private int id;
    private int game_rank;
    private String name;
    private String platform;
    private Integer year;
    private String genre;
    private String publisher;
    private double northamericansales;
    private double europesales;
    private double japansales;
    private double othersales;
    private double globalsales;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGame_rank() {
        return game_rank;
    }

    public void setGame_rank(int game_rank) {
        this.game_rank = game_rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getNorthamericansales() {
        return northamericansales;
    }

    public void setNorthamericansales(double northamericansales) {
        this.northamericansales = northamericansales;
    }

    public double getEuropesales() {
        return europesales;
    }

    public void setEuropesales(double europesales) {
        this.europesales = europesales;
    }

    public double getJapansales() {
        return japansales;
    }

    public void setJapansales(double japansales) {
        this.japansales = japansales;
    }

    public double getOthersales() {
        return othersales;
    }

    public void setOthersales(double othersales) {
        this.othersales = othersales;
    }

    public double getGlobalsales() {
        return globalsales;
    }

    public void setGlobalsales(double globalsales) {
        this.globalsales = globalsales;
    }
}
