package com.blc.backend.model;

import java.util.List;

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

    // Nested Venue class
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

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getZip() {
            return zip;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        // Nested Location class
        public static class Location {

            @JsonProperty("lat")
            private String lat;

            @JsonProperty("lng")
            private String lng;

            // Getters and setters
            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLng() {
                return lng;
            }

            public void setLng(String lng) {
                this.lng = lng;
            }
        }
    }

    // Nested Conference class
    public static class Conference {

        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String name;

        @JsonProperty("alias")
        private String alias;

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

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }
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

