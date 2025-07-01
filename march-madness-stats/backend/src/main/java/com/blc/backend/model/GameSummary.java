package com.blc.backend.model;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameSummary {
    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("neutral_site")
    private boolean neutralSite;

    @JsonProperty("scheduled")
    private OffsetDateTime scheduled;

    @JsonProperty("conference_game")
    private boolean conferenceGame;

    @JsonProperty("attendance")
    private int attendance;

    @JsonProperty("lead_changes")
    private int leadChanges;

    @JsonProperty("times_tied")
    private int timesTied;

    @JsonProperty("clock")
    private String clock;

    @JsonProperty("half")
    private int half;

    @JsonProperty("track_on_court")
    private boolean trackOnCourt;

    @JsonProperty("clock_decimal")
    private String clockDecimal;

    @JsonProperty("season")
    private Season season;

    @JsonProperty("venue")
    private Venue venue;

    @JsonProperty("home")
    private Team home;

    @JsonProperty("away")
    private Team away;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isNeutralSite() {
        return neutralSite;
    }

    public void setNeutralSite(boolean neutralSite) {
        this.neutralSite = neutralSite;
    }

    public OffsetDateTime getScheduled() {
        return scheduled;
    }

    public void setScheduled(OffsetDateTime scheduled) {
        this.scheduled = scheduled;
    }

    public boolean isConferenceGame() {
        return conferenceGame;
    }

    public void setConferenceGame(boolean conferenceGame) {
        this.conferenceGame = conferenceGame;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getLeadChanges() {
        return leadChanges;
    }

    public void setLeadChanges(int leadChanges) {
        this.leadChanges = leadChanges;
    }

    public int getTimesTied() {
        return timesTied;
    }

    public void setTimesTied(int timesTied) {
        this.timesTied = timesTied;
    }

    public String getClock() {
        return clock;
    }

    public void setClock(String clock) {
        this.clock = clock;
    }

    public int getHalf() {
        return half;
    }

    public void setHalf(int half) {
        this.half = half;
    }

    public boolean isTrackOnCourt() {
        return trackOnCourt;
    }

    public void setTrackOnCourt(boolean trackOnCourt) {
        this.trackOnCourt = trackOnCourt;
    }

    public String getClockDecimal() {
        return clockDecimal;
    }

    public void setClockDecimal(String clockDecimal) {
        this.clockDecimal = clockDecimal;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
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