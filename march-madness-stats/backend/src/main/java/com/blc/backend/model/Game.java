package com.blc.backend.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Game {

    @JsonProperty("id")
    private String id;

    @JsonProperty("scheduled")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDate scheduledDate;

    @JsonProperty("home_points")
    private int homePoints;

    @JsonProperty("away_points")
    private int awayPoints;

    @JsonProperty("conference_game")
    private boolean conferenceGame;

    @JsonProperty("venue")
    private Venue venue;

    @JsonProperty("home")
    private Team home;

    @JsonProperty("away")
    private Team away;

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getScheduled() {
        return scheduledDate;
    }

    public LocalDate getScheduledDate() {
        return scheduledDate;
    }
    
    public void setScheduled(String scheduled) {
        // Convert the string to a LocalDate object (only the date part)
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        this.scheduledDate = LocalDate.parse(scheduled.substring(0, 10), formatter);
    }

    public void setScheduledDate(String scheduled) {
        // Convert the string to a LocalDate object (only the date part)
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        this.scheduledDate = LocalDate.parse(scheduled.substring(0, 10), formatter);
    }

    public int getHomePoints() {
        return homePoints;
    }

    public void setHomePoints(int homePoints) {
        this.homePoints = homePoints;
    }

    public int getAwayPoints() {
        return awayPoints;
    }

    public void setAwayPoints(int awayPoints) {
        this.awayPoints = awayPoints;
    }

    public boolean isConferenceGame() {
        return conferenceGame;
    }

    public void setConferenceGame(boolean conferenceGame) {
        this.conferenceGame = conferenceGame;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }
}
