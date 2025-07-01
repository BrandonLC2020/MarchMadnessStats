package com.blc.backend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the complete hierarchy of a sports league, including divisions,
 * conferences, and teams.
 * This class is designed to be deserialized from a JSON API response.
 */
public class LeagueHierarchy {

    @JsonProperty("league")
    private LeagueInfo league;

    @JsonProperty("divisions")
    private List<Division> divisions;

    // Getters and Setters
    public LeagueInfo getLeague() { return league; }
    public void setLeague(LeagueInfo league) { this.league = league; }

    public List<Division> getDivisions() { return divisions; }
    public void setDivisions(List<Division> divisions) { this.divisions = divisions; }

    public static class LeagueInfo {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("alias")
        private String alias;

        // Getters and Setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getAlias() { return alias; }
        public void setAlias(String alias) { this.alias = alias; }
    }

    public static class Division {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("alias")
        private String alias;
        @JsonProperty("conferences")
        private List<Conference> conferences;

        // Getters and Setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getAlias() { return alias; }
        public void setAlias(String alias) { this.alias = alias; }

        public List<Conference> getConferences() { return conferences; }
        public void setConferences(List<Conference> conferences) { this.conferences = conferences; }
    }

    public static class Conference {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("alias")
        private String alias;
        @JsonProperty("teams")
        private List<Team> teams;

        // Getters and Setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getAlias() { return alias; }
        public void setAlias(String alias) { this.alias = alias; }

        public List<Team> getTeams() { return teams; }
        public void setTeams(List<Team> teams) { this.teams = teams; }
    }

    public static class Team {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("market")
        private String market;
        @JsonProperty("alias")
        private String alias;
        @JsonProperty("founded")
        private Integer founded;
        @JsonProperty("mascot")
        private String mascot;
        @JsonProperty("fight_song")
        private String fightSong;
        @JsonProperty("championships_won")
        private Integer championshipsWon;
        @JsonProperty("conference_titles")
        private Integer conferenceTitles;
        @JsonProperty("playoff_appearances")
        private Integer playoffAppearances;
        @JsonProperty("venue")
        private Venue venue;
        @JsonProperty("team_colors")
        private List<TeamColor> teamColors;
        @JsonProperty("subdivision")
        private String subdivision;

        // Getters and Setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getMarket() { return market; }
        public void setMarket(String market) { this.market = market; }

        public String getAlias() { return alias; }
        public void setAlias(String alias) { this.alias = alias; }

        public Integer getFounded() { return founded; }
        public void setFounded(Integer founded) { this.founded = founded; }

        public String getMascot() { return mascot; }
        public void setMascot(String mascot) { this.mascot = mascot; }

        public String getFightSong() { return fightSong; }
        public void setFightSong(String fightSong) { this.fightSong = fightSong; }

        public Integer getChampionshipsWon() { return championshipsWon; }
        public void setChampionshipsWon(Integer championshipsWon) { this.championshipsWon = championshipsWon; }

        public Integer getConferenceTitles() { return conferenceTitles; }
        public void setConferenceTitles(Integer conferenceTitles) { this.conferenceTitles = conferenceTitles; }

        public Integer getPlayoffAppearances() { return playoffAppearances; }
        public void setPlayoffAppearances(Integer playoffAppearances) { this.playoffAppearances = playoffAppearances; }

        public Venue getVenue() { return venue; }
        public void setVenue(Venue venue) { this.venue = venue; }

        public List<TeamColor> getTeamColors() { return teamColors; }
        public void setTeamColors(List<TeamColor> teamColors) { this.teamColors = teamColors; }

        public String getSubdivision() { return subdivision; }
        public void setSubdivision(String subdivision) { this.subdivision = subdivision; }
    }

    public static class Venue {
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

    public static class Location {
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

    public static class TeamColor {
        @JsonProperty("type")
        private String type;
        @JsonProperty("hex_color")
        private String hexColor;
        @JsonProperty("rgb_color")
        private RGBColor rgbColor;

        // Getters and Setters
        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public String getHexColor() { return hexColor; }
        public void setHexColor(String hexColor) { this.hexColor = hexColor; }

        public RGBColor getRgbColor() { return rgbColor; }
        public void setRgbColor(RGBColor rgbColor) { this.rgbColor = rgbColor; }
    }

    public static class RGBColor {
        @JsonProperty("red")
        private int red;
        @JsonProperty("green")
        private int green;
        @JsonProperty("blue")
        private int blue;

        // Getters and Setters
        public int getRed() { return red; }
        public void setRed(int red) { this.red = red; }

        public int getGreen() { return green; }
        public void setGreen(int green) { this.green = green; }

        public int getBlue() { return blue; }
        public void setBlue(int blue) { this.blue = blue; }
    }
}