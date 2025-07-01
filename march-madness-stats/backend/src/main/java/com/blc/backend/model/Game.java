package com.blc.backend.model;

import java.time.OffsetDateTime;

import com.blc.backend.model.core.Team;
import com.blc.backend.model.core.Venue;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Game {

    @JsonProperty("id")
    private String id;

    @JsonProperty("scheduled")
    // Use a type that preserves time and timezone info, and let Jackson handle parsing.
    private OffsetDateTime scheduled;

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

    public OffsetDateTime getScheduled() {
        return scheduled;
    }

    public void setScheduled(OffsetDateTime scheduled) {
        this.scheduled = scheduled;
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
