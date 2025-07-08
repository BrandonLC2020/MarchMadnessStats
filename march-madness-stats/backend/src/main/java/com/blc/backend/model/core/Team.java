package com.blc.backend.model.core;

import java.util.List;

import com.blc.backend.model.core.Conference;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Team {

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

    @JsonProperty("conference")
    private Conference conference;

    @JsonProperty("team_colors")
    private List<TeamColor> teamColors;

    // Getters and setters

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

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getFounded() {
        return founded;
    }

    public void setFounded(int founded) {
        this.founded = founded;
    }

    public String getMascot() {
        return mascot;
    }

    public void setMascot(String mascot) {
        this.mascot = mascot;
    }

    public String getFightSong() {
        return fightSong;
    }

    public void setFightSong(String fightSong) {
        this.fightSong = fightSong;
    }

    public int getChampionshipsWon() {
        return championshipsWon;
    }

    public void setChampionshipsWon(int championshipsWon) {
        this.championshipsWon = championshipsWon;
    }

    public int getConferenceTitles() {
        return conferenceTitles;
    }

    public void setConferenceTitles(int conferenceTitles) {
        this.conferenceTitles = conferenceTitles;
    }

    public int getPlayoffAppearances() {
        return playoffAppearances;
    }

    public void setPlayoffAppearances(int playoffAppearances) {
        this.playoffAppearances = playoffAppearances;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    public List<TeamColor> getTeamColors() {
        return teamColors;
    }

    public void setTeamColors(List<TeamColor> teamColors) {
        this.teamColors = teamColors;
    }

    // Nested TeamColor class
    public static class TeamColor {

        @JsonProperty("type")
        private String type;

        @JsonProperty("hex_color")
        private String hexColor;

        @JsonProperty("rgb_color")
        private RGBColor rgbColor;

        // Getters and setters
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getHexColor() {
            return hexColor;
        }

        public void setHexColor(String hexColor) {
            this.hexColor = hexColor;
        }

        public RGBColor getRgbColor() {
            return rgbColor;
        }

        public void setRgbColor(RGBColor rgbColor) {
            this.rgbColor = rgbColor;
        }

        // Nested RGBColor class
        public static class RGBColor {

            @JsonProperty("red")
            private int red;

            @JsonProperty("green")
            private int green;

            @JsonProperty("blue")
            private int blue;

            // Getters and setters
            public int getRed() {
                return red;
            }

            public void setRed(int red) {
                this.red = red;
            }

            public int getGreen() {
                return green;
            }

            public void setGreen(int green) {
                this.green = green;
            }

            public int getBlue() {
                return blue;
            }

            public void setBlue(int blue) {
                this.blue = blue;
            }
        }
    }
}

