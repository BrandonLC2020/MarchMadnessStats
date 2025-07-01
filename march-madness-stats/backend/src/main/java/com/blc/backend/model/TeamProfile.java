package com.blc.backend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the complete profile for a single team, including venue, conference,
 * coaches, colors, and player roster. This class is designed to be deserialized
 * from a JSON API response.
 */
public class TeamProfile {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("market")
    private String market;

    @JsonProperty("alias")
    private String alias;

    @JsonProperty("founded")
    private int founded;

    @JsonProperty("mascot")
    private String mascot;

    @JsonProperty("fight_song")
    private String fightSong;

    @JsonProperty("championships_won")
    private int championshipsWon;

    @JsonProperty("conference_titles")
    private int conferenceTitles;

    @JsonProperty("playoff_appearances")
    private int playoffAppearances;

    @JsonProperty("venue")
    private Venue venue;

    @JsonProperty("league")
    private League league;

    @JsonProperty("conference")
    private Conference conference;

    @JsonProperty("division")
    private Division division;

    @JsonProperty("coaches")
    private List<Coach> coaches;

    @JsonProperty("team_colors")
    private List<TeamColor> teamColors;

    @JsonProperty("players")
    private List<Player> players;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMarket() { return market; }
    public void setMarket(String market) { this.market = market; }

    public String getAlias() { return alias; }
    public void setAlias(String alias) { this.alias = alias; }

    public int getFounded() { return founded; }
    public void setFounded(int founded) { this.founded = founded; }

    public String getMascot() { return mascot; }
    public void setMascot(String mascot) { this.mascot = mascot; }

    public String getFightSong() { return fightSong; }
    public void setFightSong(String fightSong) { this.fightSong = fightSong; }

    public int getChampionshipsWon() { return championshipsWon; }
    public void setChampionshipsWon(int championshipsWon) { this.championshipsWon = championshipsWon; }

    public int getConferenceTitles() { return conferenceTitles; }
    public void setConferenceTitles(int conferenceTitles) { this.conferenceTitles = conferenceTitles; }

    public int getPlayoffAppearances() { return playoffAppearances; }
    public void setPlayoffAppearances(int playoffAppearances) { this.playoffAppearances = playoffAppearances; }

    public Venue getVenue() { return venue; }
    public void setVenue(Venue venue) { this.venue = venue; }

    public League getLeague() { return league; }
    public void setLeague(League league) { this.league = league; }

    public Conference getConference() { return conference; }
    public void setConference(Conference conference) { this.conference = conference; }

    public Division getDivision() { return division; }
    public void setDivision(Division division) { this.division = division; }

    public List<Coach> getCoaches() { return coaches; }
    public void setCoaches(List<Coach> coaches) { this.coaches = coaches; }

    public List<TeamColor> getTeamColors() { return teamColors; }
    public void setTeamColors(List<TeamColor> teamColors) { this.teamColors = teamColors; }

    public List<Player> getPlayers() { return players; }
    public void setPlayers(List<Player> players) { this.players = players; }

    public static class Venue {
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

        // Getters and Setters
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

        // Getters and Setters
        public String getLat() { return lat; }
        public void setLat(String lat) { this.lat = lat; }
        public String getLng() { return lng; }
        public void setLng(String lng) { this.lng = lng; }
    }

    public static class League {
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

    public static class Conference {
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

        // Getters and Setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getAlias() { return alias; }
        public void setAlias(String alias) { this.alias = alias; }
    }

    public static class Coach {
        @JsonProperty("id")
        private String id;
        @JsonProperty("full_name")
        private String fullName;
        @JsonProperty("first_name")
        private String firstName;
        @JsonProperty("last_name")
        private String lastName;
        @JsonProperty("position")
        private String position;

        // Getters and Setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public String getFullName() { return fullName; }
        public void setFullName(String fullName) { this.fullName = fullName; }
        public String getFirstName() { return firstName; }
        public void setFirstName(String firstName) { this.firstName = firstName; }
        public String getLastName() { return lastName; }
        public void setLastName(String lastName) { this.lastName = lastName; }
        public String getPosition() { return position; }
        public void setPosition(String position) { this.position = position; }
    }

    public static class TeamColor {
        @JsonProperty("type")
        private String type;
        @JsonProperty("hex_color")
        private String hexColor;
        @JsonProperty("rgb_color")
        private RgbColor rgbColor;

        // Getters and Setters
        public String getType() { return type; }
        public void setType(String type) { this.type = type; }
        public String getHexColor() { return hexColor; }
        public void setHexColor(String hexColor) { this.hexColor = hexColor; }
        public RgbColor getRgbColor() { return rgbColor; }
        public void setRgbColor(RgbColor rgbColor) { this.rgbColor = rgbColor; }
    }

    public static class RgbColor {
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

    public static class Player {
        @JsonProperty("id")
        private String id;
        @JsonProperty("status")
        private String status;
        @JsonProperty("full_name")
        private String fullName;
        @JsonProperty("first_name")
        private String firstName;
        @JsonProperty("last_name")
        private String lastName;
        @JsonProperty("abbr_name")
        private String abbrName;
        @JsonProperty("height")
        private int height;
        @JsonProperty("weight")
        private int weight;
        @JsonProperty("position")
        private String position;
        @JsonProperty("primary_position")
        private String primaryPosition;
        @JsonProperty("jersey_number")
        private String jerseyNumber;
        @JsonProperty("experience")
        private String experience;
        @JsonProperty("birth_place")
        private String birthPlace;
        @JsonProperty("updated")
        private String updated;

        // Getters and Setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        public String getFullName() { return fullName; }
        public void setFullName(String fullName) { this.fullName = fullName; }

        public String getFirstName() { return firstName; }
        public void setFirstName(String firstName) { this.firstName = firstName; }

        public String getLastName() { return lastName; }
        public void setLastName(String lastName) { this.lastName = lastName; }

        public String getAbbrName() { return abbrName; }
        public void setAbbrName(String abbrName) { this.abbrName = abbrName; }

        public int getHeight() { return height; }
        public void setHeight(int height) { this.height = height; }

        public int getWeight() { return weight; }
        public void setWeight(int weight) { this.weight = weight; }

        public String getPosition() { return position; }
        public void setPosition(String position) { this.position = position; }

        public String getPrimaryPosition() { return primaryPosition; }
        public void setPrimaryPosition(String primaryPosition) { this.primaryPosition = primaryPosition; }

        public String getJerseyNumber() { return jerseyNumber; }
        public void setJerseyNumber(String jerseyNumber) { this.jerseyNumber = jerseyNumber; }

        public String getExperience() { return experience; }
        public void setExperience(String experience) { this.experience = experience; }

        public String getBirthPlace() { return birthPlace; }
        public void setBirthPlace(String birthPlace) { this.birthPlace = birthPlace; }

        public String getUpdated() { return updated; }
        public void setUpdated(String updated) { this.updated = updated; }
    }
}