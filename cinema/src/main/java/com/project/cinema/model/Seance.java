package com.project.cinema.model;

import java.sql.Date;
import java.sql.Time;

public class Seance {
    private int seanceId;
    private String seanceTime;
    private String seanceDate;
    private int seancePrice;
    private int roomId;
    private int movieId;

    public int getSeanceId() {
        return seanceId;
    }

    public void setSeanceId(int seanceId) {
        this.seanceId = seanceId;
    }

    public String getSeanceTime() {
        return seanceTime;
    }

    public void setSeanceTime(String seanceTime) {
        this.seanceTime = seanceTime;
    }

    public String getSeanceDate() {
        return seanceDate;
    }

    public void setSeanceDate(String seanceDate) {
        this.seanceDate = seanceDate;
    }

    public int getSeancePrice() {
        return seancePrice;
    }

    public void setSeancePrice(int seancePrice) {
        this.seancePrice = seancePrice;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}