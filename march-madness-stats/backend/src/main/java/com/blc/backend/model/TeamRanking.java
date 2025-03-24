package com.blc.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamRanking {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String teamName;

    @JsonProperty("market")
    private String market;

    @JsonProperty("rank")
    private int rank;

    @JsonProperty("wins")
    private int wins;

    @JsonProperty("losses")
    private int losses;

    @JsonProperty("prev_rank")
    private int prevRank;

    @JsonProperty("points")
    private int points;

    @JsonProperty("fp_votes")
    private int fpVotes;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String name) {
        this.teamName = name;
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

    public int getPrevRank() {
        return prevRank;
    }

    public void setPrevRank(int prevRank) {
        this.prevRank = prevRank;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getFpVotes() {
        return fpVotes;
    }

    public void setFpVotes(int fpVotes) {
        this.fpVotes = fpVotes;
    }
}
