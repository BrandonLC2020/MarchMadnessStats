package com.blc.backend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Main class representing the entire Schedule JSON response.
 * This is the root object for deserialization.
 */
public class Schedule {

    @JsonProperty("league")
    private League league;

    @JsonProperty("season")
    private Season season;

    @JsonProperty("games")
    private List<Game> games;

    // Getters and Setters
    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}

/**
 * Represents the league information.
 */
class League {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("alias")
    private String alias;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}

/**
 * Represents the season information.
 */
class Season {
    @JsonProperty("id")
    private String id;

    @JsonProperty("year")
    private int year;

    @JsonProperty("type")
    private String type;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

/**
 * Represents a single game in the schedule.
 */
class Game {
    @JsonProperty("id")
    private String id;

    @JsonProperty("status")
    private String status;

    @JsonProperty("coverage")
    private String coverage;

    @JsonProperty("scheduled")
    private String scheduled;

    @JsonProperty("home_points")
    private Integer homePoints;

    @JsonProperty("away_points")
    private Integer awayPoints;

    @JsonProperty("conference_game")
    private boolean conferenceGame;

    @JsonProperty("time_zones")
    private TimeZones timeZones;

    @JsonProperty("venue")
    private Venue venue;

    @JsonProperty("broadcasts")
    private List<Broadcast> broadcasts;

    @JsonProperty("home")
    private Team home;

    @JsonProperty("away")
    private Team away;

    @JsonProperty("neutral_site")
    private Boolean neutralSite;
    
    @JsonProperty("title")
    private String title;

    @JsonProperty("track_on_court")
    private Boolean trackOnCourt;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getCoverage() { return coverage; }
    public void setCoverage(String coverage) { this.coverage = coverage; }
    public String getScheduled() { return scheduled; }
    public void setScheduled(String scheduled) { this.scheduled = scheduled; }
    public Integer getHomePoints() { return homePoints; }
    public void setHomePoints(Integer homePoints) { this.homePoints = homePoints; }
    public Integer getAwayPoints() { return awayPoints; }
    public void setAwayPoints(Integer awayPoints) { this.awayPoints = awayPoints; }
    public boolean isConferenceGame() { return conferenceGame; }
    public void setConferenceGame(boolean conferenceGame) { this.conferenceGame = conferenceGame; }
    public TimeZones getTimeZones() { return timeZones; }
    public void setTimeZones(TimeZones timeZones) { this.timeZones = timeZones; }
    public Venue getVenue() { return venue; }
    public void setVenue(Venue venue) { this.venue = venue; }
    public List<Broadcast> getBroadcasts() { return broadcasts; }
    public void setBroadcasts(List<Broadcast> broadcasts) { this.broadcasts = broadcasts; }
    public Team getHome() { return home; }
    public void setHome(Team home) { this.home = home; }
    public Team getAway() { return away; }
    public void setAway(Team away) { this.away = away; }
    public Boolean getNeutralSite() { return neutralSite; }
    public void setNeutralSite(Boolean neutralSite) { this.neutralSite = neutralSite; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Boolean getTrackOnCourt() { return trackOnCourt; }
    public void setTrackOnCourt(Boolean trackOnCourt) { this.trackOnCourt = trackOnCourt; }
}

/**
 * Represents the time zones for the game.
 */
class TimeZones {
    @JsonProperty("venue")
    private String venue;

    @JsonProperty("home")
    private String home;

    @JsonProperty("away")
    private String away;

    // Getters and Setters
    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }
    public String getHome() { return home; }
    public void setHome(String home) { this.home = home; }
    public String getAway() { return away; }
    public void setAway(String away) { this.away = away; }
}

/**
 * Represents the venue where the game is played.
 */
class Venue {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("capacity")
    private Integer capacity;

    @JsonProperty("address")
    private String address;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("zip")
    private String zip;

    @JsonProperty("country")
    private String country;

    @JsonProperty("location")
    private Location location;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }
}

/**
 * Represents the geographical location of the venue.
 */
class Location {
    @JsonProperty("lat")
    private String lat;

    @JsonProperty("lng")
    private String lng;

    // Getters and Setters
    public String getLat() { return lat; }
    public void setLat(String lat) { this.lat = lat; }
    public String getLng() { return lng; }
    public void setLng(String lng) { this.lng = lng; }
}

/**
 * Represents a broadcast network.
 */
class Broadcast {
    @JsonProperty("network")
    private String network;

    @JsonProperty("type")
    private String type;

    @JsonProperty("locale")
    private String locale;

    @JsonProperty("channel")
    private String channel;

    // Getters and Setters
    public String getNetwork() { return network; }
    public void setNetwork(String network) { this.network = network; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getLocale() { return locale; }
    public void setLocale(String locale) { this.locale = locale; }
    public String getChannel() { return channel; }
    public void setChannel(String channel) { this.channel = channel; }
}

/**
 * Represents a team (home or away).
 */
class Team {
    @JsonProperty("name")
    private String name;

    @JsonProperty("alias")
    private String alias;

    @JsonProperty("id")
    private String id;

    @JsonProperty("source")
    private Source source;

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAlias() { return alias; }
    public void setAlias(String alias) { this.alias = alias; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public Source getSource() { return source; }
    public void setSource(Source source) { this.source = source; }
}

/**
 * Represents the source of a team in a tournament game.
 */
class Source {
    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("status")
    private String status;

    @JsonProperty("coverage")
    private String coverage;

    @JsonProperty("home_team")
    private String homeTeam;

    @JsonProperty("away_team")
    private String awayTeam;

    @JsonProperty("scheduled")
    private String scheduled;

    @JsonProperty("outcome")
    private String outcome;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getCoverage() { return coverage; }
    public void setCoverage(String coverage) { this.coverage = coverage; }
    public String getHomeTeam() { return homeTeam; }
    public void setHomeTeam(String homeTeam) { this.homeTeam = homeTeam; }
    public String getAwayTeam() { return awayTeam; }
    public void setAwayTeam(String awayTeam) { this.awayTeam = awayTeam; }
    public String getScheduled() { return scheduled; }
    public void setScheduled(String scheduled) { this.scheduled = scheduled; }
    public String getOutcome() { return outcome; }
    public void setOutcome(String outcome) { this.outcome = outcome; }
}

