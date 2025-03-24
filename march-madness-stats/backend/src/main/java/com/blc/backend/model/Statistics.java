package com.blc.backend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Statistics {
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

    @JsonProperty("assists")
    private int assists;

    @JsonProperty("steals")
    private int steals;

    @JsonProperty("blocks")
    private int blocks;

    @JsonProperty("assists_turnover_ratio")
    private double assistsTurnoverRatio;

    @JsonProperty("personal_fouls")
    private int personalFouls;

    @JsonProperty("ejections")
    private int ejections;

    @JsonProperty("foulouts")
    private int foulouts;

    @JsonProperty("points")
    private int points;

    @JsonProperty("fast_break_pts")
    private int fastBreakPts;

    @JsonProperty("second_chance_pts")
    private int secondChancePts;

    @JsonProperty("team_turnovers")
    private int teamTurnovers;

    @JsonProperty("points_off_turnovers")
    private int pointsOffTurnovers;

    @JsonProperty("team_rebounds")
    private int teamRebounds;

    @JsonProperty("flagrant_fouls")
    private int flagrantFouls;

    @JsonProperty("player_tech_fouls")
    private int playerTechFouls;

    @JsonProperty("team_tech_fouls")
    private int teamTechFouls;

    @JsonProperty("coach_tech_fouls")
    private int coachTechFouls;

    @JsonProperty("points_in_paint")
    private int pointsInPaint;

    @JsonProperty("team_offensive_rebounds")
    private int teamOffensiveRebounds;

    @JsonProperty("team_defensive_rebounds")
    private int teamDefensiveRebounds;

    @JsonProperty("total_rebounds")
    private int totalRebounds;

    @JsonProperty("total_turnovers")
    private int totalTurnovers;

    @JsonProperty("personal_rebounds")
    private int personalRebounds;

    @JsonProperty("player_turnovers")
    private int playerTurnovers;

    @JsonProperty("field_goals_at_rim_made")
    private int fieldGoalsAtRimMade;

    @JsonProperty("field_goals_at_rim_att")
    private int fieldGoalsAtRimAtt;

    @JsonProperty("field_goals_at_rim_pct")
    private double fieldGoalsAtRimPct;

    @JsonProperty("field_goals_at_midrange_made")
    private int fieldGoalsAtMidrangeMade;

    @JsonProperty("field_goals_at_midrange_att")
    private int fieldGoalsAtMidrangeAtt;

    @JsonProperty("field_goals_at_midrange_pct")
    private double fieldGoalsAtMidrangePct;

    @JsonProperty("bench_points")
    private int benchPoints;

    @JsonProperty("biggest_lead")
    private int biggestLead;

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

    @JsonProperty("pls_min")
    private int plsMin;

    @JsonProperty("points_in_paint_att")
    private int pointsInPaintAtt;

    @JsonProperty("points_in_paint_made")
    private int pointsInPaintMade;

    @JsonProperty("points_in_paint_pct")
    private double pointsInPaintPct;

    @JsonProperty("total_fouls")
    private int totalFouls;

    @JsonProperty("true_shooting_att")
    private double trueShootingAtt;

    @JsonProperty("true_shooting_pct")
    private double trueShootingPct;

    @JsonProperty("coach_ejections")
    private int coachEjections;

    @JsonProperty("most_unanswered")
    private MostUnanswered mostUnanswered;

    @JsonProperty("periods")
    private List<Period> periods;

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public int getFieldGoalsMade() {
        return fieldGoalsMade;
    }

    public void setFieldGoalsMade(int fieldGoalsMade) {
        this.fieldGoalsMade = fieldGoalsMade;
    }

    public int getFieldGoalsAtt() {
        return fieldGoalsAtt;
    }

    public void setFieldGoalsAtt(int fieldGoalsAtt) {
        this.fieldGoalsAtt = fieldGoalsAtt;
    }

    public double getFieldGoalsPct() {
        return fieldGoalsPct;
    }

    public void setFieldGoalsPct(double fieldGoalsPct) {
        this.fieldGoalsPct = fieldGoalsPct;
    }

    public int getThreePointsMade() {
        return threePointsMade;
    }

    public void setThreePointsMade(int threePointsMade) {
        this.threePointsMade = threePointsMade;
    }

    public int getThreePointsAtt() {
        return threePointsAtt;
    }

    public void setThreePointsAtt(int threePointsAtt) {
        this.threePointsAtt = threePointsAtt;
    }

    public double getThreePointsPct() {
        return threePointsPct;
    }

    public void setThreePointsPct(double threePointsPct) {
        this.threePointsPct = threePointsPct;
    }

    public int getTwoPointsMade() {
        return twoPointsMade;
    }

    public void setTwoPointsMade(int twoPointsMade) {
        this.twoPointsMade = twoPointsMade;
    }

    public int getTwoPointsAtt() {
        return twoPointsAtt;
    }

    public void setTwoPointsAtt(int twoPointsAtt) {
        this.twoPointsAtt = twoPointsAtt;
    }

    public double getTwoPointsPct() {
        return twoPointsPct;
    }

    public void setTwoPointsPct(double twoPointsPct) {
        this.twoPointsPct = twoPointsPct;
    }

    public int getBlockedAtt() {
        return blockedAtt;
    }

    public void setBlockedAtt(int blockedAtt) {
        this.blockedAtt = blockedAtt;
    }

    public int getFreeThrowsMade() {
        return freeThrowsMade;
    }

    public void setFreeThrowsMade(int freeThrowsMade) {
        this.freeThrowsMade = freeThrowsMade;
    }

    public int getFreeThrowsAtt() {
        return freeThrowsAtt;
    }

    public void setFreeThrowsAtt(int freeThrowsAtt) {
        this.freeThrowsAtt = freeThrowsAtt;
    }

    public double getFreeThrowsPct() {
        return freeThrowsPct;
    }

    public void setFreeThrowsPct(double freeThrowsPct) {
        this.freeThrowsPct = freeThrowsPct;
    }

    public int getOffensiveRebounds() {
        return offensiveRebounds;
    }

    public void setOffensiveRebounds(int offensiveRebounds) {
        this.offensiveRebounds = offensiveRebounds;
    }

    public int getDefensiveRebounds() {
        return defensiveRebounds;
    }

    public void setDefensiveRebounds(int defensiveRebounds) {
        this.defensiveRebounds = defensiveRebounds;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getSteals() {
        return steals;
    }

    public void setSteals(int steals) {
        this.steals = steals;
    }

    public int getBlocks() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    public double getAssistsTurnoverRatio() {
        return assistsTurnoverRatio;
    }

    public void setAssistsTurnoverRatio(double assistsTurnoverRatio) {
        this.assistsTurnoverRatio = assistsTurnoverRatio;
    }

    public int getPersonalFouls() {
        return personalFouls;
    }

    public void setPersonalFouls(int personalFouls) {
        this.personalFouls = personalFouls;
    }

    public int getEjections() {
        return ejections;
    }

    public void setEjections(int ejections) {
        this.ejections = ejections;
    }

    public int getFoulouts() {
        return foulouts;
    }

    public void setFoulouts(int foulouts) {
        this.foulouts = foulouts;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getFastBreakPts() {
        return fastBreakPts;
    }

    public void setFastBreakPts(int fastBreakPts) {
        this.fastBreakPts = fastBreakPts;
    }

    public int getSecondChancePts() {
        return secondChancePts;
    }

    public void setSecondChancePts(int secondChancePts) {
        this.secondChancePts = secondChancePts;
    }

    public int getTeamTurnovers() {
        return teamTurnovers;
    }

    public void setTeamTurnovers(int teamTurnovers) {
        this.teamTurnovers = teamTurnovers;
    }

    public int getPointsOffTurnovers() {
        return pointsOffTurnovers;
    }

    public void setPointsOffTurnovers(int pointsOffTurnovers) {
        this.pointsOffTurnovers = pointsOffTurnovers;
    }

    public int getTeamRebounds() {
        return teamRebounds;
    }

    public void setTeamRebounds(int teamRebounds) {
        this.teamRebounds = teamRebounds;
    }

    public int getFlagrantFouls() {
        return flagrantFouls;
    }

    public void setFlagrantFouls(int flagrantFouls) {
        this.flagrantFouls = flagrantFouls;
    }

    public int getPlayerTechFouls() {
        return playerTechFouls;
    }

    public void setPlayerTechFouls(int playerTechFouls) {
        this.playerTechFouls = playerTechFouls;
    }

    public int getTeamTechFouls() {
        return teamTechFouls;
    }

    public void setTeamTechFouls(int teamTechFouls) {
        this.teamTechFouls = teamTechFouls;
    }

    public int getCoachTechFouls() {
        return coachTechFouls;
    }

    public void setCoachTechFouls(int coachTechFouls) {
        this.coachTechFouls = coachTechFouls;
    }

    public int getPointsInPaint() {
        return pointsInPaint;
    }

    public void setPointsInPaint(int pointsInPaint) {
        this.pointsInPaint = pointsInPaint;
    }

    public int getTeamOffensiveRebounds() {
        return teamOffensiveRebounds;
    }

    public void setTeamOffensiveRebounds(int teamOffensiveRebounds) {
        this.teamOffensiveRebounds = teamOffensiveRebounds;
    }

    public int getTeamDefensiveRebounds() {
        return teamDefensiveRebounds;
    }

    public void setTeamDefensiveRebounds(int teamDefensiveRebounds) {
        this.teamDefensiveRebounds = teamDefensiveRebounds;
    }

    public int getTotalRebounds() {
        return totalRebounds;
    }

    public void setTotalRebounds(int totalRebounds) {
        this.totalRebounds = totalRebounds;
    }

    public int getTotalTurnovers() {
        return totalTurnovers;
    }

    public void setTotalTurnovers(int totalTurnovers) {
        this.totalTurnovers = totalTurnovers;
    }

    public int getPersonalRebounds() {
        return personalRebounds;
    }

    public void setPersonalRebounds(int personalRebounds) {
        this.personalRebounds = personalRebounds;
    }

    public int getPlayerTurnovers() {
        return playerTurnovers;
    }

    public void setPlayerTurnovers(int playerTurnovers) {
        this.playerTurnovers = playerTurnovers;
    }

    public int getFieldGoalsAtRimMade() {
        return fieldGoalsAtRimMade;
    }

    public void setFieldGoalsAtRimMade(int fieldGoalsAtRimMade) {
        this.fieldGoalsAtRimMade = fieldGoalsAtRimMade;
    }

    public int getFieldGoalsAtRimAtt() {
        return fieldGoalsAtRimAtt;
    }

    public void setFieldGoalsAtRimAtt(int fieldGoalsAtRimAtt) {
        this.fieldGoalsAtRimAtt = fieldGoalsAtRimAtt;
    }

    public double getFieldGoalsAtRimPct() {
        return fieldGoalsAtRimPct;
    }

    public void setFieldGoalsAtRimPct(double fieldGoalsAtRimPct) {
        this.fieldGoalsAtRimPct = fieldGoalsAtRimPct;
    }

    public int getFieldGoalsAtMidrangeMade() {
        return fieldGoalsAtMidrangeMade;
    }

    public void setFieldGoalsAtMidrangeMade(int fieldGoalsAtMidrangeMade) {
        this.fieldGoalsAtMidrangeMade = fieldGoalsAtMidrangeMade;
    }

    public int getFieldGoalsAtMidrangeAtt() {
        return fieldGoalsAtMidrangeAtt;
    }

    public void setFieldGoalsAtMidrangeAtt(int fieldGoalsAtMidrangeAtt) {
        this.fieldGoalsAtMidrangeAtt = fieldGoalsAtMidrangeAtt;
    }

    public double getFieldGoalsAtMidrangePct() {
        return fieldGoalsAtMidrangePct;
    }

    public void setFieldGoalsAtMidrangePct(double fieldGoalsAtMidrangePct) {
        this.fieldGoalsAtMidrangePct = fieldGoalsAtMidrangePct;
    }

    public int getBenchPoints() {
        return benchPoints;
    }

    public void setBenchPoints(int benchPoints) {
        this.benchPoints = benchPoints;
    }

    public int getBiggestLead() {
        return biggestLead;
    }

    public void setBiggestLead(int biggestLead) {
        this.biggestLead = biggestLead;
    }

    public double getEffectiveFgPct() {
        return effectiveFgPct;
    }

    public void setEffectiveFgPct(double effectiveFgPct) {
        this.effectiveFgPct = effectiveFgPct;
    }

    public int getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }

    public double getEfficiencyGameScore() {
        return efficiencyGameScore;
    }

    public void setEfficiencyGameScore(double efficiencyGameScore) {
        this.efficiencyGameScore = efficiencyGameScore;
    }

    public int getFoulsDrawn() {
        return foulsDrawn;
    }

    public void setFoulsDrawn(int foulsDrawn) {
        this.foulsDrawn = foulsDrawn;
    }

    public int getOffensiveFouls() {
        return offensiveFouls;
    }

    public void setOffensiveFouls(int offensiveFouls) {
        this.offensiveFouls = offensiveFouls;
    }

    public int getPlsMin() {
        return plsMin;
    }

    public void setPlsMin(int plsMin) {
        this.plsMin = plsMin;
    }

    public int getPointsInPaintAtt() {
        return pointsInPaintAtt;
    }

    public void setPointsInPaintAtt(int pointsInPaintAtt) {
        this.pointsInPaintAtt = pointsInPaintAtt;
    }

    public int getPointsInPaintMade() {
        return pointsInPaintMade;
    }

    public void setPointsInPaintMade(int pointsInPaintMade) {
        this.pointsInPaintMade = pointsInPaintMade;
    }

    public double getPointsInPaintPct() {
        return pointsInPaintPct;
    }

    public void setPointsInPaintPct(double pointsInPaintPct) {
        this.pointsInPaintPct = pointsInPaintPct;
    }

    public int getTotalFouls() {
        return totalFouls;
    }

    public void setTotalFouls(int totalFouls) {
        this.totalFouls = totalFouls;
    }

    public double getTrueShootingAtt() {
        return trueShootingAtt;
    }

    public void setTrueShootingAtt(double trueShootingAtt) {
        this.trueShootingAtt = trueShootingAtt;
    }

    public double getTrueShootingPct() {
        return trueShootingPct;
    }

    public void setTrueShootingPct(double trueShootingPct) {
        this.trueShootingPct = trueShootingPct;
    }

    public int getCoachEjections() {
        return coachEjections;
    }

    public void setCoachEjections(int coachEjections) {
        this.coachEjections = coachEjections;
    }

    public MostUnanswered getMostUnanswered() {
        return mostUnanswered;
    }

    public void setMostUnanswered(MostUnanswered mostUnanswered) {
        this.mostUnanswered = mostUnanswered;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    public void setPeriods(List<Period> periods) {
        this.periods = periods;
    }
}
