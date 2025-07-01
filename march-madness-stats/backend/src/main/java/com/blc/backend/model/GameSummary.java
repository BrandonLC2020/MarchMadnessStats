package com.blc.backend.model;

import java.time.OffsetDateTime;
import java.util.List;

import com.blc.backend.model.core.Season;
import com.blc.backend.model.core.Venue;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GameSummary {
    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("status")
    private String status;

    @JsonProperty("coverage")
    private String coverage;

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

    @JsonProperty("entry_mode")
    private String entryMode;

    @JsonProperty("clock_decimal")
    private String clockDecimal;

    @JsonProperty("season")
    private Season season;

    @JsonProperty("venue")
    private Venue venue;

    @JsonProperty("broadcasts")
    private List<Broadcast> broadcasts;

    @JsonProperty("time_zones")
    private TimeZones timeZones;

    @JsonProperty("home")
    private TeamSummary home;

    @JsonProperty("away")
    private TeamSummary away;

    @JsonProperty("officials")
    private List<Official> officials;
    
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCoverage() {
        return coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage;
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

    public String getEntryMode() {
        return entryMode;
    }

    public void setEntryMode(String entryMode) {
        this.entryMode = entryMode;
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

    public List<Broadcast> getBroadcasts() {
        return broadcasts;
    }

    public void setBroadcasts(List<Broadcast> broadcasts) {
        this.broadcasts = broadcasts;
    }

    public TimeZones getTimeZones() {
        return timeZones;
    }

    public void setTimeZones(TimeZones timeZones) {
        this.timeZones = timeZones;
    }

    public TeamSummary getHome() {
        return home;
    }

    public void setHome(TeamSummary home) {
        this.home = home;
    }

    public TeamSummary getAway() {
        return away;
    }

    public void setAway(TeamSummary away) {
        this.away = away;
    }

    public List<Official> getOfficials() {
        return officials;
    }

    public void setOfficials(List<Official> officials) {
        this.officials = officials;
    }

    public static class Broadcast {
        @JsonProperty("type")
        private String type;
        @JsonProperty("locale")
        private String locale;
        @JsonProperty("network")
        private String network;

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public String getLocale() { return locale; }
        public void setLocale(String locale) { this.locale = locale; }

        public String getNetwork() { return network; }
        public void setNetwork(String network) { this.network = network; }
    }

    public static class TimeZones {
        @JsonProperty("venue")
        private String venue;
        @JsonProperty("home")
        private String home;
        @JsonProperty("away")
        private String away;

        public String getVenue() { return venue; }
        public void setVenue(String venue) { this.venue = venue; }

        public String getHome() { return home; }
        public void setHome(String home) { this.home = home; }

        public String getAway() { return away; }
        public void setAway(String away) { this.away = away; }
    }

    public static class Official {
        @JsonProperty("id")
        private String id;

        @JsonProperty("full_name")
        private String fullName;

        @JsonProperty("assignment")
        private String assignment;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getAssignment() {
            return assignment;
        }

        public void setAssignment(String assignment) {
            this.assignment = assignment;
        }
    }
}