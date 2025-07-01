package com.blc.backend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Main class representing the entire RPI Rankings JSON response.
 * This is the root object for deserialization.
 */
public class RPIRankings {

    @JsonProperty("season")
    private Season season;

    @JsonProperty("rankings")
    private List<Ranking> rankings;

    // Getters and Setters
    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public List<Ranking> getRankings() {
        return rankings;
    }

    public void setRankings(List<Ranking> rankings) {
        this.rankings = rankings;
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
 * Represents a single team's ranking data.
 */
class Ranking {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("market")
    private String market;

    @JsonProperty("rank")
    private int rank;

    @JsonProperty("prev_rank")
    private int prevRank;

    @JsonProperty("wins")
    private int wins;

    @JsonProperty("losses")
    private int losses;

    @JsonProperty("home_wins")
    private int homeWins;

    @JsonProperty("home_losses")
    private int homeLosses;

    @JsonProperty("away_wins")
    private int awayWins;

    @JsonProperty("away_losses")
    private int awayLosses;

    @JsonProperty("neut_wins")
    private int neutWins;

    @JsonProperty("neut_losses")
    private int neutLosses;

    @JsonProperty("opp_wins")
    private int oppWins;

    @JsonProperty("opp_losses")
    private int oppLosses;

    @JsonProperty("owp")
    private double owp;

    @JsonProperty("oowp")
    private double oowp;

    @JsonProperty("awp")
    private double awp;

    @JsonProperty("sos")
    private double sos;

    @JsonProperty("rpi")
    private double rpi;

    @JsonProperty("opponents")
    private List<Opponent> opponents;

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

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getPrevRank() {
        return prevRank;
    }

    public void setPrevRank(int prevRank) {
        this.prevRank = prevRank;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getHomeWins() {
        return homeWins;
    }

    public void setHomeWins(int homeWins) {
        this.homeWins = homeWins;
    }

    public int getHomeLosses() {
        return homeLosses;
    }

    public void setHomeLosses(int homeLosses) {
        this.homeLosses = homeLosses;
    }

    public int getAwayWins() {
        return awayWins;
    }

    public void setAwayWins(int awayWins) {
        this.awayWins = awayWins;
    }

    public int getAwayLosses() {
        return awayLosses;
    }

    public void setAwayLosses(int awayLosses) {
        this.awayLosses = awayLosses;
    }

    public int getNeutWins() {
        return neutWins;
    }

    public void setNeutWins(int neutWins) {
        this.neutWins = neutWins;
    }

    public int getNeutLosses() {
        return neutLosses;
    }

    public void setNeutLosses(int neutLosses) {
        this.neutLosses = neutLosses;
    }

    public int getOppWins() {
        return oppWins;
    }

    public void setOppWins(int oppWins) {
        this.oppWins = oppWins;
    }

    public int getOppLosses() {
        return oppLosses;
    }

    public void setOppLosses(int oppLosses) {
        this.oppLosses = oppLosses;
    }

    public double getOwp() {
        return owp;
    }

    public void setOwp(double owp) {
        this.owp = owp;
    }

    public double getOowp() {
        return oowp;
    }

    public void setOowp(double oowp) {
        this.oowp = oowp;
    }

    public double getAwp() {
        return awp;
    }

    public void setAwp(double awp) {
        this.awp = awp;
    }

    public double getSos() {
        return sos;
    }

    public void setSos(double sos) {
        this.sos = sos;
    }

    public double getRpi() {
        return rpi;
    }

    public void setRpi(double rpi) {
        this.rpi = rpi;
    }

    public List<Opponent> getOpponents() {
        return opponents;
    }

    public void setOpponents(List<Opponent> opponents) {
        this.opponents = opponents;
    }
}

/**
 * Represents the record against opponents in a certain rank bracket.
 */
class Opponent {
    @JsonProperty("rank")
    private String rank;

    @JsonProperty("wins")
    private int wins;

    @JsonProperty("losses")
    private int losses;

    // Getters and Setters
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }
}

