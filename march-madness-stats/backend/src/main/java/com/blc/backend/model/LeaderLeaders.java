package com.blc.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Main class representing the entire Leaders JSON response.
 * This is the root object for deserialization.
 */
public class LeaderLeaders {

    @JsonProperty("season")
    private Season season;

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("alias")
    private String alias;

    @JsonProperty("type")
    private String type;

    @JsonProperty("categories")
    private List<Category> categories;

    // Getters and Setters
    public Season getSeason() { return season; }
    public void setSeason(Season season) { this.season = season; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAlias() { return alias; }
    public void setAlias(String alias) { this.alias = alias; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public List<Category> getCategories() { return categories; }
    public void setCategories(List<Category> categories) { this.categories = categories; }
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
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}

/**
 * Represents a statistical category (e.g., minutes, points).
 */
class Category {
    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("ranks")
    private List<Rank> ranks;

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public List<Rank> getRanks() { return ranks; }
    public void setRanks(List<Rank> ranks) { this.ranks = ranks; }
}

/**
 * Represents a player's rank within a category.
 */
class Rank {
    @JsonProperty("rank")
    private int rank;

    @JsonProperty("tied")
    private boolean tied;

    @JsonProperty("score")
    private double score;

    @JsonProperty("player")
    private Player player;

    @JsonProperty("teams")
    private List<Team> teams;

    @JsonProperty("total")
    private TotalStats total;

    @JsonProperty("average")
    private AverageStats average;

    // Getters and Setters
    public int getRank() { return rank; }
    public void setRank(int rank) { this.rank = rank; }
    public boolean isTied() { return tied; }
    public void setTied(boolean tied) { this.tied = tied; }
    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }
    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }
    public List<Team> getTeams() { return teams; }
    public void setTeams(List<Team> teams) { this.teams = teams; }
    public TotalStats getTotal() { return total; }
    public void setTotal(TotalStats total) { this.total = total; }
    public AverageStats getAverage() { return average; }
    public void setAverage(AverageStats average) { this.average = average; }
}

/**
 * Represents player information.
 */
class Player {
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

    @JsonProperty("primary_position")
    private String primaryPosition;

    @JsonProperty("jersey_number")
    private String jerseyNumber;
    
    @JsonProperty("name_suffix")
    private String nameSuffix;


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
    public String getPrimaryPosition() { return primaryPosition; }
    public void setPrimaryPosition(String primaryPosition) { this.primaryPosition = primaryPosition; }
    public String getJerseyNumber() { return jerseyNumber; }
    public void setJerseyNumber(String jerseyNumber) { this.jerseyNumber = jerseyNumber; }
    public String getNameSuffix() { return nameSuffix; }
    public void setNameSuffix(String nameSuffix) { this.nameSuffix = nameSuffix; }
}

/**
 * Represents team information.
 */
class Team {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("market")
    private String market;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getMarket() { return market; }
    public void setMarket(String market) { this.market = market; }
}

/**
 * Represents the total statistics for a player.
 */
class TotalStats {
    @JsonProperty("games_played")
    private int gamesPlayed;
    @JsonProperty("games_started")
    private int gamesStarted;
    @JsonProperty("minutes")
    private int minutes;
    @JsonProperty("field_goals_made")
    private int fieldGoalsMade;
    @JsonProperty("field_goals_att")
    private int fieldGoalsAtt;
    @JsonProperty("field_goals_pct")
    private double fieldGoalsPct;
    @JsonProperty("two_points_made")
    private int twoPointsMade;
    @JsonProperty("two_points_att")
    private int twoPointsAtt;
    @JsonProperty("two_points_pct")
    private double twoPointsPct;
    @JsonProperty("three_points_made")
    private int threePointsMade;
    @JsonProperty("three_points_att")
    private int threePointsAtt;
    @JsonProperty("three_points_pct")
    private double threePointsPct;
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
    @JsonProperty("assists_turnover_ratio")
    private double assistsTurnoverRatio;
    @JsonProperty("steals")
    private int steals;
    @JsonProperty("blocks")
    private int blocks;
    @JsonProperty("personal_fouls")
    private int personalFouls;
    @JsonProperty("tech_fouls")
    private int techFouls;
    @JsonProperty("points")
    private int points;
    @JsonProperty("flagrant_fouls")
    private int flagrantFouls;
    @JsonProperty("ejections")
    private int ejections;
    @JsonProperty("foulouts")
    private int foulouts;
    @JsonProperty("true_shooting_att")
    private double trueShootingAtt;
    @JsonProperty("true_shooting_pct")
    private double trueShootingPct;
    @JsonProperty("efficiency")
    private int efficiency;
    @JsonProperty("field_goals_at_rim_made")
    private int fieldGoalsAtRimMade;
    @JsonProperty("field_goals_at_rim_att")
    private int fieldGoalsAtRimAtt;
    @JsonProperty("field_goals_at_midrange_made")
    private int fieldGoalsAtMidrangeMade;
    @JsonProperty("field_goals_at_midrange_att")
    private int fieldGoalsAtMidrangeAtt;

    // Getters and Setters
    public int getGamesPlayed() { return gamesPlayed; }
    public void setGamesPlayed(int gamesPlayed) { this.gamesPlayed = gamesPlayed; }
    public int getGamesStarted() { return gamesStarted; }
    public void setGamesStarted(int gamesStarted) { this.gamesStarted = gamesStarted; }
    public int getMinutes() { return minutes; }
    public void setMinutes(int minutes) { this.minutes = minutes; }
    public int getFieldGoalsMade() { return fieldGoalsMade; }
    public void setFieldGoalsMade(int fieldGoalsMade) { this.fieldGoalsMade = fieldGoalsMade; }
    public int getFieldGoalsAtt() { return fieldGoalsAtt; }
    public void setFieldGoalsAtt(int fieldGoalsAtt) { this.fieldGoalsAtt = fieldGoalsAtt; }
    public double getFieldGoalsPct() { return fieldGoalsPct; }
    public void setFieldGoalsPct(double fieldGoalsPct) { this.fieldGoalsPct = fieldGoalsPct; }
    public int getTwoPointsMade() { return twoPointsMade; }
    public void setTwoPointsMade(int twoPointsMade) { this.twoPointsMade = twoPointsMade; }
    public int getTwoPointsAtt() { return twoPointsAtt; }
    public void setTwoPointsAtt(int twoPointsAtt) { this.twoPointsAtt = twoPointsAtt; }
    public double getTwoPointsPct() { return twoPointsPct; }
    public void setTwoPointsPct(double twoPointsPct) { this.twoPointsPct = twoPointsPct; }
    public int getThreePointsMade() { return threePointsMade; }
    public void setThreePointsMade(int threePointsMade) { this.threePointsMade = threePointsMade; }
    public int getThreePointsAtt() { return threePointsAtt; }
    public void setThreePointsAtt(int threePointsAtt) { this.threePointsAtt = threePointsAtt; }
    public double getThreePointsPct() { return threePointsPct; }
    public void setThreePointsPct(double threePointsPct) { this.threePointsPct = threePointsPct; }
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
    public double getAssistsTurnoverRatio() { return assistsTurnoverRatio; }
    public void setAssistsTurnoverRatio(double assistsTurnoverRatio) { this.assistsTurnoverRatio = assistsTurnoverRatio; }
    public int getSteals() { return steals; }
    public void setSteals(int steals) { this.steals = steals; }
    public int getBlocks() { return blocks; }
    public void setBlocks(int blocks) { this.blocks = blocks; }
    public int getPersonalFouls() { return personalFouls; }
    public void setPersonalFouls(int personalFouls) { this.personalFouls = personalFouls; }
    public int getTechFouls() { return techFouls; }
    public void setTechFouls(int techFouls) { this.techFouls = techFouls; }
    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }
    public int getFlagrantFouls() { return flagrantFouls; }
    public void setFlagrantFouls(int flagrantFouls) { this.flagrantFouls = flagrantFouls; }
    public int getEjections() { return ejections; }
    public void setEjections(int ejections) { this.ejections = ejections; }
    public int getFoulouts() { return foulouts; }
    public void setFoulouts(int foulouts) { this.foulouts = foulouts; }
    public double getTrueShootingAtt() { return trueShootingAtt; }
    public void setTrueShootingAtt(double trueShootingAtt) { this.trueShootingAtt = trueShootingAtt; }
    public double getTrueShootingPct() { return trueShootingPct; }
    public void setTrueShootingPct(double trueShootingPct) { this.trueShootingPct = trueShootingPct; }
    public int getEfficiency() { return efficiency; }
    public void setEfficiency(int efficiency) { this.efficiency = efficiency; }
    public int getFieldGoalsAtRimMade() { return fieldGoalsAtRimMade; }
    public void setFieldGoalsAtRimMade(int fieldGoalsAtRimMade) { this.fieldGoalsAtRimMade = fieldGoalsAtRimMade; }
    public int getFieldGoalsAtRimAtt() { return fieldGoalsAtRimAtt; }
    public void setFieldGoalsAtRimAtt(int fieldGoalsAtRimAtt) { this.fieldGoalsAtRimAtt = fieldGoalsAtRimAtt; }
    public int getFieldGoalsAtMidrangeMade() { return fieldGoalsAtMidrangeMade; }
    public void setFieldGoalsAtMidrangeMade(int fieldGoalsAtMidrangeMade) { this.fieldGoalsAtMidrangeMade = fieldGoalsAtMidrangeMade; }
    public int getFieldGoalsAtMidrangeAtt() { return fieldGoalsAtMidrangeAtt; }
    public void setFieldGoalsAtMidrangeAtt(int fieldGoalsAtMidrangeAtt) { this.fieldGoalsAtMidrangeAtt = fieldGoalsAtMidrangeAtt; }
}

/**
 * Represents the average statistics for a player.
 */
class AverageStats {
    @JsonProperty("minutes")
    private double minutes;
    @JsonProperty("points")
    private double points;
    @JsonProperty("off_rebounds")
    private double offRebounds;
    @JsonProperty("def_rebounds")
    private double defRebounds;
    @JsonProperty("rebounds")
    private double rebounds;
    @JsonProperty("assists")
    private double assists;
    @JsonProperty("steals")
    private double steals;
    @JsonProperty("blocks")
    private double blocks;
    @JsonProperty("turnovers")
    private double turnovers;
    @JsonProperty("personal_fouls")
    private double personalFouls;
    @JsonProperty("flagrant_fouls")
    private double flagrantFouls;
    @JsonProperty("blocked_att")
    private double blockedAtt;
    @JsonProperty("field_goals_made")
    private double fieldGoalsMade;
    @JsonProperty("field_goals_att")
    private double fieldGoalsAtt;
    @JsonProperty("three_points_made")
    private double threePointsMade;
    @JsonProperty("three_points_att")
    private double threePointsAtt;
    @JsonProperty("free_throws_made")
    private double freeThrowsMade;
    @JsonProperty("free_throws_att")
    private double freeThrowsAtt;
    @JsonProperty("two_points_made")
    private double twoPointsMade;
    @JsonProperty("two_points_att")
    private double twoPointsAtt;
    @JsonProperty("efficiency")
    private double efficiency;
    @JsonProperty("true_shooting_att")
    private double trueShootingAtt;

    // Getters and Setters
    public double getMinutes() { return minutes; }
    public void setMinutes(double minutes) { this.minutes = minutes; }
    public double getPoints() { return points; }
    public void setPoints(double points) { this.points = points; }
    public double getOffRebounds() { return offRebounds; }
    public void setOffRebounds(double offRebounds) { this.offRebounds = offRebounds; }
    public double getDefRebounds() { return defRebounds; }
    public void setDefRebounds(double defRebounds) { this.defRebounds = defRebounds; }
    public double getRebounds() { return rebounds; }
    public void setRebounds(double rebounds) { this.rebounds = rebounds; }
    public double getAssists() { return assists; }
    public void setAssists(double assists) { this.assists = assists; }
    public double getSteals() { return steals; }
    public void setSteals(double steals) { this.steals = steals; }
    public double getBlocks() { return blocks; }
    public void setBlocks(double blocks) { this.blocks = blocks; }
    public double getTurnovers() { return turnovers; }
    public void setTurnovers(double turnovers) { this.turnovers = turnovers; }
    public double getPersonalFouls() { return personalFouls; }
    public void setPersonalFouls(double personalFouls) { this.personalFouls = personalFouls; }
    public double getFlagrantFouls() { return flagrantFouls; }
    public void setFlagrantFouls(double flagrantFouls) { this.flagrantFouls = flagrantFouls; }
    public double getBlockedAtt() { return blockedAtt; }
    public void setBlockedAtt(double blockedAtt) { this.blockedAtt = blockedAtt; }
    public double getFieldGoalsMade() { return fieldGoalsMade; }
    public void setFieldGoalsMade(double fieldGoalsMade) { this.fieldGoalsMade = fieldGoalsMade; }
    public double getFieldGoalsAtt() { return fieldGoalsAtt; }
    public void setFieldGoalsAtt(double fieldGoalsAtt) { this.fieldGoalsAtt = fieldGoalsAtt; }
    public double getThreePointsMade() { return threePointsMade; }
    public void setThreePointsMade(double threePointsMade) { this.threePointsMade = threePointsMade; }
    public double getThreePointsAtt() { return threePointsAtt; }
    public void setThreePointsAtt(double threePointsAtt) { this.threePointsAtt = threePointsAtt; }
    public double getFreeThrowsMade() { return freeThrowsMade; }
    public void setFreeThrowsMade(double freeThrowsMade) { this.freeThrowsMade = freeThrowsMade; }
    public double getFreeThrowsAtt() { return freeThrowsAtt; }
    public void setFreeThrowsAtt(double freeThrowsAtt) { this.freeThrowsAtt = freeThrowsAtt; }
    public double getTwoPointsMade() { return twoPointsMade; }
    public void setTwoPointsMade(double twoPointsMade) { this.twoPointsMade = twoPointsMade; }
    public double getTwoPointsAtt() { return twoPointsAtt; }
    public void setTwoPointsAtt(double twoPointsAtt) { this.twoPointsAtt = twoPointsAtt; }
    public double getEfficiency() { return efficiency; }
    public void setEfficiency(double efficiency) { this.efficiency = efficiency; }
    public double getTrueShootingAtt() { return trueShootingAtt; }
    public void setTrueShootingAtt(double trueShootingAtt) { this.trueShootingAtt = trueShootingAtt; }
}
