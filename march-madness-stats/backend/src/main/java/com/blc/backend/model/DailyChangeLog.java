package com.blc.backend.model;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a daily log of changes for a league, including updates to
 * teams, players, schedules, results, and standings.
 * This class is designed to be deserialized from a JSON API response.
 */
public class DailyChangeLog {

    @JsonProperty("league")
    private LeagueInfo league;

    @JsonProperty("start_time")
    private OffsetDateTime startTime;

    @JsonProperty("end_time")
    private OffsetDateTime endTime;

    @JsonProperty("teams")
    private List<TeamChange> teams;

    @JsonProperty("players")
    private List<PlayerChange> players;

    @JsonProperty("schedule")
    private List<ScheduleChange> schedule;

    @JsonProperty("results")
    private List<ResultChange> results;

    @JsonProperty("standings")
    private List<StandingChange> standings;

    // Getters and Setters

    public LeagueInfo getLeague() { return league; }
    public void setLeague(LeagueInfo league) { this.league = league; }

    public OffsetDateTime getStartTime() { return startTime; }
    public void setStartTime(OffsetDateTime startTime) { this.startTime = startTime; }

    public OffsetDateTime getEndTime() { return endTime; }
    public void setEndTime(OffsetDateTime endTime) { this.endTime = endTime; }

    public List<TeamChange> getTeams() { return teams; }
    public void setTeams(List<TeamChange> teams) { this.teams = teams; }

    public List<PlayerChange> getPlayers() { return players; }
    public void setPlayers(List<PlayerChange> players) { this.players = players; }

    public List<ScheduleChange> getSchedule() { return schedule; }
    public void setSchedule(List<ScheduleChange> schedule) { this.schedule = schedule; }

    public List<ResultChange> getResults() { return results; }
    public void setResults(List<ResultChange> results) { this.results = results; }

    public List<StandingChange> getStandings() { return standings; }
    public void setStandings(List<StandingChange> standings) { this.standings = standings; }

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

    public static class TeamChange {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("market")
        private String market;
        @JsonProperty("last_modified")
        private OffsetDateTime lastModified;

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getMarket() { return market; }
        public void setMarket(String market) { this.market = market; }

        public OffsetDateTime getLastModified() { return lastModified; }
        public void setLastModified(OffsetDateTime lastModified) { this.lastModified = lastModified; }
    }

    public static class PlayerChange {
        @JsonProperty("id")
        private String id;
        @JsonProperty("full_name")
        private String fullName;
        @JsonProperty("last_modified")
        private OffsetDateTime lastModified;

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public String getFullName() { return fullName; }
        public void setFullName(String fullName) { this.fullName = fullName; }

        public OffsetDateTime getLastModified() { return lastModified; }
        public void setLastModified(OffsetDateTime lastModified) { this.lastModified = lastModified; }
    }

    public static class ScheduleChange {
        @JsonProperty("id")
        private String id;
        @JsonProperty("season_id")
        private String seasonId;
        @JsonProperty("last_modified")
        private OffsetDateTime lastModified;

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public String getSeasonId() { return seasonId; }
        public void setSeasonId(String seasonId) { this.seasonId = seasonId; }

        public OffsetDateTime getLastModified() { return lastModified; }
        public void setLastModified(OffsetDateTime lastModified) { this.lastModified = lastModified; }
    }

    public static class ResultChange {
        @JsonProperty("id")
        private String id;
        @JsonProperty("season_id")
        private String seasonId;
        @JsonProperty("last_modified")
        private OffsetDateTime lastModified;

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public String getSeasonId() { return seasonId; }
        public void setSeasonId(String seasonId) { this.seasonId = seasonId; }

        public OffsetDateTime getLastModified() { return lastModified; }
        public void setLastModified(OffsetDateTime lastModified) { this.lastModified = lastModified; }
    }

    public static class StandingChange {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("market")
        private String market;
        @JsonProperty("last_modified")
        private OffsetDateTime lastModified;

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getMarket() { return market; }
        public void setMarket(String market) { this.market = market; }

        public OffsetDateTime getLastModified() { return lastModified; }
        public void setLastModified(OffsetDateTime lastModified) { this.lastModified = lastModified; }
    }
}