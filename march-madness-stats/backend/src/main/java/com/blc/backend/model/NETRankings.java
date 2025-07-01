package com.blc.backend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Main class representing the entire NET Rankings JSON response.
 * This is the root object for deserialization.
 */
public class NETRankings {

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

    @JsonProperty("net_rank")
    private int netRank;

    @JsonProperty("prev_net_rank")
    private int prevNetRank;

    @JsonProperty("avg_opp_net_rank")
    private int avgOppNetRank;

    @JsonProperty("avg_opp_net")
    private int avgOppNet;

    @JsonProperty("wins")
    private int wins;

    @JsonProperty("losses")
    private int losses;

    @JsonProperty("conf_wins")
    private int confWins;

    @JsonProperty("conf_losses")
    private int confLosses;

    @JsonProperty("non_conf_wins")
    private int nonConfWins;

    @JsonProperty("non_conf_losses")
    private int nonConfLosses;

    @JsonProperty("road_wins")
    private int roadWins;

    @JsonProperty("road_losses")
    private int roadLosses;

    @JsonProperty("net_sos")
    private int netSos;

    @JsonProperty("net_non_conf_sos")
    private int netNonConfSos;

    @JsonProperty("quad_1_wins")
    private int quad1Wins;

    @JsonProperty("quad_1_losses")
    private int quad1Losses;

    @JsonProperty("quad_2_wins")
    private int quad2Wins;

    @JsonProperty("quad_2_losses")
    private int quad2Losses;

    @JsonProperty("quad_3_wins")
    private int quad3Wins;

    @JsonProperty("quad_3_losses")
    private int quad3Losses;

    @JsonProperty("quad_4_wins")
    private int quad4Wins;

    @JsonProperty("quad_4_losses")
    private int quad4Losses;

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

    public int getNetRank() {
        return netRank;
    }

    public void setNetRank(int netRank) {
        this.netRank = netRank;
    }

    public int getPrevNetRank() {
        return prevNetRank;
    }

    public void setPrevNetRank(int prevNetRank) {
        this.prevNetRank = prevNetRank;
    }

    public int getAvgOppNetRank() {
        return avgOppNetRank;
    }

    public void setAvgOppNetRank(int avgOppNetRank) {
        this.avgOppNetRank = avgOppNetRank;
    }

    public int getAvgOppNet() {
        return avgOppNet;
    }

    public void setAvgOppNet(int avgOppNet) {
        this.avgOppNet = avgOppNet;
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

    public int getConfWins() {
        return confWins;
    }

    public void setConfWins(int confWins) {
        this.confWins = confWins;
    }

    public int getConfLosses() {
        return confLosses;
    }

    public void setConfLosses(int confLosses) {
        this.confLosses = confLosses;
    }

    public int getNonConfWins() {
        return nonConfWins;
    }

    public void setNonConfWins(int nonConfWins) {
        this.nonConfWins = nonConfWins;
    }

    public int getNonConfLosses() {
        return nonConfLosses;
    }

    public void setNonConfLosses(int nonConfLosses) {
        this.nonConfLosses = nonConfLosses;
    }

    public int getRoadWins() {
        return roadWins;
    }

    public void setRoadWins(int roadWins) {
        this.roadWins = roadWins;
    }

    public int getRoadLosses() {
        return roadLosses;
    }

    public void setRoadLosses(int roadLosses) {
        this.roadLosses = roadLosses;
    }

    public int getNetSos() {
        return netSos;
    }

    public void setNetSos(int netSos) {
        this.netSos = netSos;
    }

    public int getNetNonConfSos() {
        return netNonConfSos;
    }

    public void setNetNonConfSos(int netNonConfSos) {
        this.netNonConfSos = netNonConfSos;
    }

    public int getQuad1Wins() {
        return quad1Wins;
    }

    public void setQuad1Wins(int quad1Wins) {
        this.quad1Wins = quad1Wins;
    }

    public int getQuad1Losses() {
        return quad1Losses;
    }

    public void setQuad1Losses(int quad1Losses) {
        this.quad1Losses = quad1Losses;
    }

    public int getQuad2Wins() {
        return quad2Wins;
    }

    public void setQuad2Wins(int quad2Wins) {
        this.quad2Wins = quad2Wins;
    }

    public int getQuad2Losses() {
        return quad2Losses;
    }

    public void setQuad2Losses(int quad2Losses) {
        this.quad2Losses = quad2Losses;
    }

    public int getQuad3Wins() {
        return quad3Wins;
    }

    public void setQuad3Wins(int quad3Wins) {
        this.quad3Wins = quad3Wins;
    }

    public int getQuad3Losses() {
        return quad3Losses;
    }

    public void setQuad3Losses(int quad3Losses) {
        this.quad3Losses = quad3Losses;
    }

    public int getQuad4Wins() {
        return quad4Wins;
    }

    public void setQuad4Wins(int quad4Wins) {
        this.quad4Wins = quad4Wins;
    }

    public int getQuad4Losses() {
        return quad4Losses;
    }

    public void setQuad4Losses(int quad4Losses) {
        this.quad4Losses = quad4Losses;
    }
}

