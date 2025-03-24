package com.blc.backend.model;

import java.util.List;

public class TeamSummary {
    private String name;
    private String alias;
    private String market;
    private String id;
    private int points;
    private int rank;
    private boolean bonus;
    private int remainingTimeouts;
    private List<Scoring> scoring;
    private Statistics statistics;
    private List<Coach> coaches;
    private List<PlayerSummary> players;

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

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public boolean isBonus() {
        return bonus;
    }

    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }

    public int getRemainingTimeouts() {
        return remainingTimeouts;
    }

    public void setRemainingTimeouts(int remainingTimeouts) {
        this.remainingTimeouts = remainingTimeouts;
    }

    public List<Scoring> getScoring() {
        return scoring;
    }

    public void setScoring(List<Scoring> scoring) {
        this.scoring = scoring;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public List<PlayerSummary> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerSummary> players) {
        this.players = players;
    }
}
