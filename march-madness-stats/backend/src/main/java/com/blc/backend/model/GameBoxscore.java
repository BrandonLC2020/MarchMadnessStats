package com.blc.backend.model;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the complete box score for a single game, including team and player statistics.
 * This class and its nested classes are designed to be deserialized from a JSON API response.
 */
public class GameBoxscore {

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("status")
    private String status;

    @JsonProperty("coverage")
    private String coverage;

    @JsonProperty("neutral_site")
    private boolean neutralSite;

    @JsonProperty("scheduled")
    private OffsetDateTime scheduled;

    @JsonProperty("conference_game")
    private boolean conferenceGame;

    @JsonProperty("attendance")
    private int attendance;

    @JsonProperty("lead_changes")
    private int leadChanges;

    @JsonProperty("times_tied")
    private int timesTied;

    @JsonProperty("clock")
    private String clock;

    @JsonProperty("half")
    private int half;

    @JsonProperty("track_on_court")
    private boolean trackOnCourt;

    @JsonProperty("entry_mode")
    private String entryMode;

    @JsonProperty("clock_decimal")
    private String clockDecimal;

    @JsonProperty("broadcasts")
    private List<Broadcast> broadcasts;

    @JsonProperty("time_zones")
    private TimeZones timeZones;

    @JsonProperty("season")
    private SeasonInfo season;

    @JsonProperty("home")
    private TeamBoxscore home;

    @JsonProperty("away")
    private TeamBoxscore away;

    // Getters and Setters

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCoverage() { return coverage; }
    public void setCoverage(String coverage) { this.coverage = coverage; }

    public boolean isNeutralSite() { return neutralSite; }
    public void setNeutralSite(boolean neutralSite) { this.neutralSite = neutralSite; }

    public OffsetDateTime getScheduled() { return scheduled; }
    public void setScheduled(OffsetDateTime scheduled) { this.scheduled = scheduled; }

    public boolean isConferenceGame() { return conferenceGame; }
    public void setConferenceGame(boolean conferenceGame) { this.conferenceGame = conferenceGame; }

    public int getAttendance() { return attendance; }
    public void setAttendance(int attendance) { this.attendance = attendance; }

    public int getLeadChanges() { return leadChanges; }
    public void setLeadChanges(int leadChanges) { this.leadChanges = leadChanges; }

    public int getTimesTied() { return timesTied; }
    public void setTimesTied(int timesTied) { this.timesTied = timesTied; }

    public String getClock() { return clock; }
    public void setClock(String clock) { this.clock = clock; }

    public int getHalf() { return half; }
    public void setHalf(int half) { this.half = half; }

    public boolean isTrackOnCourt() { return trackOnCourt; }
    public void setTrackOnCourt(boolean trackOnCourt) { this.trackOnCourt = trackOnCourt; }

    public String getEntryMode() { return entryMode; }
    public void setEntryMode(String entryMode) { this.entryMode = entryMode; }

    public String getClockDecimal() { return clockDecimal; }
    public void setClockDecimal(String clockDecimal) { this.clockDecimal = clockDecimal; }

    public List<Broadcast> getBroadcasts() { return broadcasts; }
    public void setBroadcasts(List<Broadcast> broadcasts) { this.broadcasts = broadcasts; }

    public TimeZones getTimeZones() { return timeZones; }
    public void setTimeZones(TimeZones timeZones) { this.timeZones = timeZones; }

    public SeasonInfo getSeason() { return season; }
    public void setSeason(SeasonInfo season) { this.season = season; }

    public TeamBoxscore getHome() { return home; }
    public void setHome(TeamBoxscore home) { this.home = home; }

    public TeamBoxscore getAway() { return away; }
    public void setAway(TeamBoxscore away) { this.away = away; }

    public static class Broadcast {
        @JsonProperty("type")
        private String type;
        @JsonProperty("locale")
        private String locale;
        @JsonProperty("network")
        private String network;

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public String getLocale() { return locale; }
        public void setLocale(String locale) { this.locale = locale; }

        public String getNetwork() { return network; }
        public void setNetwork(String network) { this.network = network; }
    }

    public static class TimeZones {
        @JsonProperty("venue")
        private String venue;
        @JsonProperty("home")
        private String home;
        @JsonProperty("away")
        private String away;

        public String getVenue() { return venue; }
        public void setVenue(String venue) { this.venue = venue; }

        public String getHome() { return home; }
        public void setHome(String home) { this.home = home; }

        public String getAway() { return away; }
        public void setAway(String away) { this.away = away; }
    }

    public static class SeasonInfo {
        @JsonProperty("id")
        private String id;
        @JsonProperty("year")
        private int year;
        @JsonProperty("type")
        private String type;
        @JsonProperty("name")
        private String name;

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public int getYear() { return year; }
        public void setYear(int year) { this.year = year; }

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }

    public static class TeamBoxscore {
        @JsonProperty("name")
        private String name;
        @JsonProperty("alias")
        private String alias;
        @JsonProperty("market")
        private String market;
        @JsonProperty("id")
        private String id;
        @JsonProperty("points")
        private int points;
        @JsonProperty("rank")
        private int rank;
        @JsonProperty("remaining_timeouts")
        private int remainingTimeouts;
        @JsonProperty("scoring")
        private List<ScoringPeriod> scoring;
        @JsonProperty("leaders")
        private Leaders leaders;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getAlias() { return alias; }
        public void setAlias(String alias) { this.alias = alias; }

        public String getMarket() { return market; }
        public void setMarket(String market) { this.market = market; }

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public int getPoints() { return points; }
        public void setPoints(int points) { this.points = points; }

        public int getRank() { return rank; }
        public void setRank(int rank) { this.rank = rank; }

        public int getRemainingTimeouts() { return remainingTimeouts; }
        public void setRemainingTimeouts(int remainingTimeouts) { this.remainingTimeouts = remainingTimeouts; }

        public List<ScoringPeriod> getScoring() { return scoring; }
        public void setScoring(List<ScoringPeriod> scoring) { this.scoring = scoring; }

        public Leaders getLeaders() { return leaders; }
        public void setLeaders(Leaders leaders) { this.leaders = leaders; }
    }

    public static class ScoringPeriod {
        @JsonProperty("type")
        private String type;
        @JsonProperty("number")
        private int number;
        @JsonProperty("sequence")
        private int sequence;
        @JsonProperty("points")
        private int points;

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public int getNumber() { return number; }
        public void setNumber(int number) { this.number = number; }

        public int getSequence() { return sequence; }
        public void setSequence(int sequence) { this.sequence = sequence; }

        public int getPoints() { return points; }
        public void setPoints(int points) { this.points = points; }
    }

    public static class Leaders {
        @JsonProperty("points")
        private List<PlayerLeader> points;
        @JsonProperty("rebounds")
        private List<PlayerLeader> rebounds;
        @JsonProperty("assists")
        private List<PlayerLeader> assists;

        public List<PlayerLeader> getPoints() { return points; }
        public void setPoints(List<PlayerLeader> points) { this.points = points; }

        public List<PlayerLeader> getRebounds() { return rebounds; }
        public void setRebounds(List<PlayerLeader> rebounds) { this.rebounds = rebounds; }

        public List<PlayerLeader> getAssists() { return assists; }
        public void setAssists(List<PlayerLeader> assists) { this.assists = assists; }
    }

    public static class PlayerLeader {
        @JsonProperty("full_name")
        private String fullName;
        @JsonProperty("jersey_number")
        private String jerseyNumber;
        @JsonProperty("id")
        private String id;
        @JsonProperty("position")
        private String position;
        @JsonProperty("primary_position")
        private String primaryPosition;
        @JsonProperty("statistics")
        private PlayerLeaderStatistics statistics;

        public String getFullName() { return fullName; }
        public void setFullName(String fullName) { this.fullName = fullName; }

        public String getJerseyNumber() { return jerseyNumber; }
        public void setJerseyNumber(String jerseyNumber) { this.jerseyNumber = jerseyNumber; }

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public String getPosition() { return position; }
        public void setPosition(String position) { this.position = position; }

        public String getPrimaryPosition() { return primaryPosition; }
        public void setPrimaryPosition(String primaryPosition) { this.primaryPosition = primaryPosition; }

        public PlayerLeaderStatistics getStatistics() { return statistics; }
        public void setStatistics(PlayerLeaderStatistics statistics) { this.statistics = statistics; }
    }

    public static class PlayerLeaderStatistics {
        @JsonProperty("minutes")
        private String minutes;
        @JsonProperty("field_goals_made")
        private int fieldGoalsMade;
        @JsonProperty("field_goals_att")
        private int fieldGoalsAtt;
        @JsonProperty("field_goals_pct")
        private double fieldGoalsPct;
        @JsonProperty("three_points_made")
        private int threePointsMade;
        @JsonProperty("three_points_att")
        private int threePointsAtt;
        @JsonProperty("three_points_pct")
        private double threePointsPct;
        @JsonProperty("two_points_made")
        private int twoPointsMade;
        @JsonProperty("two_points_att")
        private int twoPointsAtt;
        @JsonProperty("two_points_pct")
        private double twoPointsPct;
        @JsonProperty("blocked_att")
        private int blockedAtt;
        @JsonProperty("free_throws_made")
        private int freeThrowsMade;
        @JsonProperty("free_throws_att")
        private int freeThrowsAtt;
        @JsonProperty("free_throws_pct")
        private double freeThrowsPct;
        @JsonProperty("offensive_rebounds")
        private int offensiveRebounds;
        @JsonProperty("defensive_rebounds")
        private int defensiveRebounds;
        @JsonProperty("rebounds")
        private int rebounds;
        @JsonProperty("assists")
        private int assists;
        @JsonProperty("turnovers")
        private int turnovers;
        @JsonProperty("steals")
        private int steals;
        @JsonProperty("blocks")
        private int blocks;
        @JsonProperty("assists_turnover_ratio")
        private double assistsTurnoverRatio;
        @JsonProperty("personal_fouls")
        private int personalFouls;
        @JsonProperty("tech_fouls")
        private int techFouls;
        @JsonProperty("flagrant_fouls")
        private int flagrantFouls;
        @JsonProperty("pls_min")
        private int plsMin;
        @JsonProperty("points")
        private int points;
        @JsonProperty("double_double")
        private boolean doubleDouble;
        @JsonProperty("triple_double")
        private boolean tripleDouble;
        @JsonProperty("effective_fg_pct")
        private double effectiveFgPct;
        @JsonProperty("efficiency")
        private int efficiency;
        @JsonProperty("efficiency_game_score")
        private double efficiencyGameScore;
        @JsonProperty("fouls_drawn")
        private int foulsDrawn;
        @JsonProperty("offensive_fouls")
        private int offensiveFouls;
        @JsonProperty("points_in_paint")
        private int pointsInPaint;
        @JsonProperty("points_in_paint_att")
        private int pointsInPaintAtt;
        @JsonProperty("points_in_paint_made")
        private int pointsInPaintMade;
        @JsonProperty("points_in_paint_pct")
        private double pointsInPaintPct;
        @JsonProperty("points_off_turnovers")
        private int pointsOffTurnovers;
        @JsonProperty("true_shooting_att")
        private double trueShootingAtt;
        @JsonProperty("true_shooting_pct")
        private double trueShootingPct;
        @JsonProperty("coach_ejections")
        private int coachEjections;
        @JsonProperty("coach_tech_fouls")
        private int coachTechFouls;
        @JsonProperty("second_chance_pts")
        private int secondChancePts;
        @JsonProperty("second_chance_pct")
        private double secondChancePct;

        public String getMinutes() { return minutes; }
        public void setMinutes(String minutes) { this.minutes = minutes; }

        public int getFieldGoalsMade() { return fieldGoalsMade; }
        public void setFieldGoalsMade(int fieldGoalsMade) { this.fieldGoalsMade = fieldGoalsMade; }

        public int getFieldGoalsAtt() { return fieldGoalsAtt; }
        public void setFieldGoalsAtt(int fieldGoalsAtt) { this.fieldGoalsAtt = fieldGoalsAtt; }

        public double getFieldGoalsPct() { return fieldGoalsPct; }
        public void setFieldGoalsPct(double fieldGoalsPct) { this.fieldGoalsPct = fieldGoalsPct; }

        public int getThreePointsMade() { return threePointsMade; }
        public void setThreePointsMade(int threePointsMade) { this.threePointsMade = threePointsMade; }

        public int getThreePointsAtt() { return threePointsAtt; }
        public void setThreePointsAtt(int threePointsAtt) { this.threePointsAtt = threePointsAtt; }

        public double getThreePointsPct() { return threePointsPct; }
        public void setThreePointsPct(double threePointsPct) { this.threePointsPct = threePointsPct; }

        public int getTwoPointsMade() { return twoPointsMade; }
        public void setTwoPointsMade(int twoPointsMade) { this.twoPointsMade = twoPointsMade; }

        public int getTwoPointsAtt() { return twoPointsAtt; }
        public void setTwoPointsAtt(int twoPointsAtt) { this.twoPointsAtt = twoPointsAtt; }

        public double getTwoPointsPct() { return twoPointsPct; }
        public void setTwoPointsPct(double twoPointsPct) { this.twoPointsPct = twoPointsPct; }

        public int getBlockedAtt() { return blockedAtt; }
        public void setBlockedAtt(int blockedAtt) { this.blockedAtt = blockedAtt; }

        public int getFreeThrowsMade() { return freeThrowsMade; }
        public void setFreeThrowsMade(int freeThrowsMade) { this.freeThrowsMade = freeThrowsMade; }

        public int getFreeThrowsAtt() { return freeThrowsAtt; }
        public void setFreeThrowsAtt(int freeThrowsAtt) { this.freeThrowsAtt = freeThrowsAtt; }

        public double getFreeThrowsPct() { return freeThrowsPct; }
        public void setFreeThrowsPct(double freeThrowsPct) { this.freeThrowsPct = freeThrowsPct; }

        public int getOffensiveRebounds() { return offensiveRebounds; }
        public void setOffensiveRebounds(int offensiveRebounds) { this.offensiveRebounds = offensiveRebounds; }

        public int getDefensiveRebounds() { return defensiveRebounds; }
        public void setDefensiveRebounds(int defensiveRebounds) { this.defensiveRebounds = defensiveRebounds; }

        public int getRebounds() { return rebounds; }
        public void setRebounds(int rebounds) { this.rebounds = rebounds; }

        public int getAssists() { return assists; }
        public void setAssists(int assists) { this.assists = assists; }

        public int getTurnovers() { return turnovers; }
        public void setTurnovers(int turnovers) { this.turnovers = turnovers; }

        public int getSteals() { return steals; }
        public void setSteals(int steals) { this.steals = steals; }

        public int getBlocks() { return blocks; }
        public void setBlocks(int blocks) { this.blocks = blocks; }

        public double getAssistsTurnoverRatio() { return assistsTurnoverRatio; }
        public void setAssistsTurnoverRatio(double assistsTurnoverRatio) { this.assistsTurnoverRatio = assistsTurnoverRatio; }

        public int getPersonalFouls() { return personalFouls; }
        public void setPersonalFouls(int personalFouls) { this.personalFouls = personalFouls; }

        public int getTechFouls() { return techFouls; }
        public void setTechFouls(int techFouls) { this.techFouls = techFouls; }

        public int getFlagrantFouls() { return flagrantFouls; }
        public void setFlagrantFouls(int flagrantFouls) { this.flagrantFouls = flagrantFouls; }

        public int getPlsMin() { return plsMin; }
        public void setPlsMin(int plsMin) { this.plsMin = plsMin; }

        public int getPoints() { return points; }
        public void setPoints(int points) { this.points = points; }

        public boolean isDoubleDouble() { return doubleDouble; }
        public void setDoubleDouble(boolean doubleDouble) { this.doubleDouble = doubleDouble; }

        public boolean isTripleDouble() { return tripleDouble; }
        public void setTripleDouble(boolean tripleDouble) { this.tripleDouble = tripleDouble; }

        public double getEffectiveFgPct() { return effectiveFgPct; }
        public void setEffectiveFgPct(double effectiveFgPct) { this.effectiveFgPct = effectiveFgPct; }

        public int getEfficiency() { return efficiency; }
        public void setEfficiency(int efficiency) { this.efficiency = efficiency; }

        public double getEfficiencyGameScore() { return efficiencyGameScore; }
        public void setEfficiencyGameScore(double efficiencyGameScore) { this.efficiencyGameScore = efficiencyGameScore; }

        public int getFoulsDrawn() { return foulsDrawn; }
        public void setFoulsDrawn(int foulsDrawn) { this.foulsDrawn = foulsDrawn; }

        public int getOffensiveFouls() { return offensiveFouls; }
        public void setOffensiveFouls(int offensiveFouls) { this.offensiveFouls = offensiveFouls; }

        public int getPointsInPaint() { return pointsInPaint; }
        public void setPointsInPaint(int pointsInPaint) { this.pointsInPaint = pointsInPaint; }

        public int getPointsInPaintAtt() { return pointsInPaintAtt; }
        public void setPointsInPaintAtt(int pointsInPaintAtt) { this.pointsInPaintAtt = pointsInPaintAtt; }

        public int getPointsInPaintMade() { return pointsInPaintMade; }
        public void setPointsInPaintMade(int pointsInPaintMade) { this.pointsInPaintMade = pointsInPaintMade; }

        public double getPointsInPaintPct() { return pointsInPaintPct; }
        public void setPointsInPaintPct(double pointsInPaintPct) { this.pointsInPaintPct = pointsInPaintPct; }

        public int getPointsOffTurnovers() { return pointsOffTurnovers; }
        public void setPointsOffTurnovers(int pointsOffTurnovers) { this.pointsOffTurnovers = pointsOffTurnovers; }

        public double getTrueShootingAtt() { return trueShootingAtt; }
        public void setTrueShootingAtt(double trueShootingAtt) { this.trueShootingAtt = trueShootingAtt; }

        public double getTrueShootingPct() { return trueShootingPct; }
        public void setTrueShootingPct(double trueShootingPct) { this.trueShootingPct = trueShootingPct; }

        public int getCoachEjections() { return coachEjections; }
        public void setCoachEjections(int coachEjections) { this.coachEjections = coachEjections; }

        public int getCoachTechFouls() { return coachTechFouls; }
        public void setCoachTechFouls(int coachTechFouls) { this.coachTechFouls = coachTechFouls; }

        public int getSecondChancePts() { return secondChancePts; }
        public void setSecondChancePts(int secondChancePts) { this.secondChancePts = secondChancePts; }

        public double getSecondChancePct() { return secondChancePct; }
        public void setSecondChancePct(double secondChancePct) { this.secondChancePct = secondChancePct; }
    }
}