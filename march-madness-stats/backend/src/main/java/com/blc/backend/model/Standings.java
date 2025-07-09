package com.blc.backend.model;

import java.util.List;

import com.blc.backend.model.core.Conference;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Main class representing the entire Standings JSON response.
 * This is the root object for deserialization.
 */
public class Standings {

    @JsonProperty("league")
    private League league;

    @JsonProperty("season")
    private Season season;

    @JsonProperty("conferences")
    private List<Conference> conferences;

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

    public List<Conference> getConferences() {
        return conferences;
    }

    public void setConferences(List<Conference> conferences) {
        this.conferences = conferences;
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
 * Represents a conference containing a list of teams.
 */
class Conference {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("alias")
    private String alias;

    @JsonProperty("teams")
    private List<Team> teams;

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

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}

/**
 * Represents a single team's standing data.
 */
class Team {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("market")
    private String market;

    @JsonProperty("alias")
    private String alias;

    @JsonProperty("wins")
    private int wins;

    @JsonProperty("losses")
    private int losses;

    @JsonProperty("win_pct")
    private double winPct;

    @JsonProperty("points_for")
    private double pointsFor;

    @JsonProperty("points_against")
    private double pointsAgainst;

    @JsonProperty("point_diff")
    private double pointDiff;

    @JsonProperty("conf_points_for")
    private int confPointsFor;

    @JsonProperty("conf_points_against")
    private int confPointsAgainst;

    @JsonProperty("clinched")
    private String clinched;

    @JsonProperty("post_season_ineligible")
    private boolean postSeasonIneligible;
    
    @JsonProperty("conference_rank")
    private int conferenceRank;
    
    @JsonProperty("subdivision_rank")
    private int subdivisionRank;

    @JsonProperty("strength_of_schedule_rank")
    private Integer strengthOfScheduleRank;
    
    @JsonProperty("subdivision")
    private String subdivision;

    @JsonProperty("streak")
    private Streak streak;

    @JsonProperty("games_behind")
    private GamesBehind gamesBehind;

    @JsonProperty("records")
    private List<Record> records;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getMarket() { return market; }
    public void setMarket(String market) { this.market = market; }
    public String getAlias() { return alias; }
    public void setAlias(String alias) { this.alias = alias; }
    public int getWins() { return wins; }
    public void setWins(int wins) { this.wins = wins; }
    public int getLosses() { return losses; }
    public void setLosses(int losses) { this.losses = losses; }
    public double getWinPct() { return winPct; }
    public void setWinPct(double winPct) { this.winPct = winPct; }
    public double getPointsFor() { return pointsFor; }
    public void setPointsFor(double pointsFor) { this.pointsFor = pointsFor; }
    public double getPointsAgainst() { return pointsAgainst; }
    public void setPointsAgainst(double pointsAgainst) { this.pointsAgainst = pointsAgainst; }
    public double getPointDiff() { return pointDiff; }
    public void setPointDiff(double pointDiff) { this.pointDiff = pointDiff; }
    public int getConfPointsFor() { return confPointsFor; }
    public void setConfPointsFor(int confPointsFor) { this.confPointsFor = confPointsFor; }
    public int getConfPointsAgainst() { return confPointsAgainst; }
    public void setConfPointsAgainst(int confPointsAgainst) { this.confPointsAgainst = confPointsAgainst; }
    public String getClinched() { return clinched; }
    public void setClinched(String clinched) { this.clinched = clinched; }
    public boolean isPostSeasonIneligible() { return postSeasonIneligible; }
    public void setPostSeasonIneligible(boolean postSeasonIneligible) { this.postSeasonIneligible = postSeasonIneligible; }
    public int getConferenceRank() { return conferenceRank; }
    public void setConferenceRank(int conferenceRank) { this.conferenceRank = conferenceRank; }
    public int getSubdivisionRank() { return subdivisionRank; }
    public void setSubdivisionRank(int subdivisionRank) { this.subdivisionRank = subdivisionRank; }
    public Integer getStrengthOfScheduleRank() { return strengthOfScheduleRank; }
    public void setStrengthOfScheduleRank(Integer strengthOfScheduleRank) { this.strengthOfScheduleRank = strengthOfScheduleRank; }
    public String getSubdivision() { return subdivision; }
    public void setSubdivision(String subdivision) { this.subdivision = subdivision; }
    public Streak getStreak() { return streak; }
    public void setStreak(Streak streak) { this.streak = streak; }
    public GamesBehind getGamesBehind() { return gamesBehind; }
    public void setGamesBehind(GamesBehind gamesBehind) { this.gamesBehind = gamesBehind; }
    public List<Record> getRecords() { return records; }
    public void setRecords(List<Record> records) { this.records = records; }
}

/**
 * Represents a team's current winning or losing streak.
 */
class Streak {
    @JsonProperty("kind")
    private String kind;

    @JsonProperty("length")
    private int length;

    // Getters and Setters
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}

/**
 * Represents how many games a team is behind the leader.
 */
class GamesBehind {
    @JsonProperty("conference")
    private Double conference;

    // Getters and Setters
    public Double getConference() {
        return conference;
    }

    public void setConference(Double conference) {
        this.conference = conference;
    }
}

/**
 * Represents a team's record in a specific category (e.g., home, away, conference).
 */
class Record {
    @JsonProperty("record_type")
    private String recordType;

    @JsonProperty("wins")
    private int wins;

    @JsonProperty("losses")
    private int losses;

    @JsonProperty("win_pct")
    private double winPct;

    // Getters and Setters
    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
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

    public double getWinPct() {
        return winPct;
    }

    public void setWinPct(double winPct) {
        this.winPct = winPct;
    }
}
