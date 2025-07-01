package com.blc.backend.model;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the schedule of games for a specific date and league.
 * This class is designed to be deserialized from a JSON API response.
 */
public class DailySchedule {

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("league")
    private LeagueInfo league;

    @JsonProperty("games")
    private List<GameInfo> games;

    // Getters and Setters

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public LeagueInfo getLeague() { return league; }
    public void setLeague(LeagueInfo league) { this.league = league; }

    public List<GameInfo> getGames() { return games; }
    public void setGames(List<GameInfo> games) { this.games = games; }

    public static class LeagueInfo {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("alias")
        private String alias;

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getAlias() { return alias; }
        public void setAlias(String alias) { this.alias = alias; }
    }

    public static class GameInfo {
        @JsonProperty("id")
        private String id;
        @JsonProperty("status")
        private String status;
        @JsonProperty("coverage")
        private String coverage;
        @JsonProperty("scheduled")
        private OffsetDateTime scheduled;
        @JsonProperty("home_points")
        private int homePoints;
        @JsonProperty("away_points")
        private int awayPoints;
        @JsonProperty("conference_game")
        private boolean conferenceGame;
        @JsonProperty("track_on_court")
        private boolean trackOnCourt;
        @JsonProperty("time_zones")
        private TimeZones timeZones;
        @JsonProperty("venue")
        private VenueInfo venue;
        @JsonProperty("broadcasts")
        private List<Broadcast> broadcasts;
        @JsonProperty("home")
        private TeamInfo home;
        @JsonProperty("away")
        private TeamInfo away;

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        public String getCoverage() { return coverage; }
        public void setCoverage(String coverage) { this.coverage = coverage; }

        public OffsetDateTime getScheduled() { return scheduled; }
        public void setScheduled(OffsetDateTime scheduled) { this.scheduled = scheduled; }

        public int getHomePoints() { return homePoints; }
        public void setHomePoints(int homePoints) { this.homePoints = homePoints; }

        public int getAwayPoints() { return awayPoints; }
        public void setAwayPoints(int awayPoints) { this.awayPoints = awayPoints; }

        public boolean isConferenceGame() { return conferenceGame; }
        public void setConferenceGame(boolean conferenceGame) { this.conferenceGame = conferenceGame; }

        public boolean isTrackOnCourt() { return trackOnCourt; }
        public void setTrackOnCourt(boolean trackOnCourt) { this.trackOnCourt = trackOnCourt; }

        public TimeZones getTimeZones() { return timeZones; }
        public void setTimeZones(TimeZones timeZones) { this.timeZones = timeZones; }

        public VenueInfo getVenue() { return venue; }
        public void setVenue(VenueInfo venue) { this.venue = venue; }

        public List<Broadcast> getBroadcasts() { return broadcasts; }
        public void setBroadcasts(List<Broadcast> broadcasts) { this.broadcasts = broadcasts; }

        public TeamInfo getHome() { return home; }
        public void setHome(TeamInfo home) { this.home = home; }

        public TeamInfo getAway() { return away; }
        public void setAway(TeamInfo away) { this.away = away; }
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

    public static class VenueInfo {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("capacity")
        private int capacity;
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

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public int getCapacity() { return capacity; }
        public void setCapacity(int capacity) { this.capacity = capacity; }

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

    public static class Location {
        @JsonProperty("lat")
        private String lat;
        @JsonProperty("lng")
        private String lng;

        public String getLat() { return lat; }
        public void setLat(String lat) { this.lat = lat; }

        public String getLng() { return lng; }
        public void setLng(String lng) { this.lng = lng; }
    }

    public static class Broadcast {
        @JsonProperty("network")
        private String network;
        @JsonProperty("type")
        private String type;
        @JsonProperty("locale")
        private String locale;
        @JsonProperty("channel")
        private String channel;

        public String getNetwork() { return network; }
        public void setNetwork(String network) { this.network = network; }

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public String getLocale() { return locale; }
        public void setLocale(String locale) { this.locale = locale; }

        public String getChannel() { return channel; }
        public void setChannel(String channel) { this.channel = channel; }
    }

    public static class TeamInfo {
        @JsonProperty("name")
        private String name;
        @JsonProperty("alias")
        private String alias;
        @JsonProperty("id")
        private String id;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getAlias() { return alias; }
        public void setAlias(String alias) { this.alias = alias; }

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
    }
}