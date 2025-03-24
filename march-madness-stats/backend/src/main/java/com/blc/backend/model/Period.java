package com.blc.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Period {
    @JsonProperty("type")
    private String type;

    @JsonProperty("id")
    private String id;

    @JsonProperty("number")
    private int number;

    @JsonProperty("sequence")
    private int sequence;

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

    @JsonProperty("offensive_fouls")
    private int offensiveFouls;

    @JsonProperty("tech_fouls")
    private int techFouls;

    @JsonProperty("flagrant_fouls")
    private int flagrantFouls;

    @JsonProperty("pls_min")
    private int plsMin;

    @JsonProperty("points")
    private int points;

    @JsonProperty("effective_fg_pct")
    private double effectiveFgPct;

    @JsonProperty("efficiency")
    private int efficiency;

    @JsonProperty("efficiency_game_score")
    private double efficiencyGameScore;

    @JsonProperty("points_in_paint")
    private int pointsInPaint;

    @JsonProperty("points_in_paint_att")
    private int pointsInPaintAtt;

    @JsonProperty("points_in_paint_made")
    private int pointsInPaintMade;

    @JsonProperty("points_in_paint_pct")
    private double pointsInPaintPct;

    @JsonProperty("true_shooting_att")
    private double trueShootingAtt;

    @JsonProperty("true_shooting_pct")
    private double trueShootingPct;

    @JsonProperty("fouls_drawn")
    private int foulsDrawn;

    @JsonProperty("points_off_turnovers")
    private int pointsOffTurnovers;

    @JsonProperty("second_chance_pts")
    private int secondChancePts;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

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

    public int getRebounds() {
        return rebounds;
    }

    public void setRebounds(int rebounds) {
        this.rebounds = rebounds;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(int turnovers) {
        this.turnovers = turnovers;
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

    public int getOffensiveFouls() {
        return offensiveFouls;
    }

    public void setOffensiveFouls(int offensiveFouls) {
        this.offensiveFouls = offensiveFouls;
    }

    public int getTechFouls() {
        return techFouls;
    }

    public void setTechFouls(int techFouls) {
        this.techFouls = techFouls;
    }

    public int getFlagrantFouls() {
        return flagrantFouls;
    }

    public void setFlagrantFouls(int flagrantFouls) {
        this.flagrantFouls = flagrantFouls;
    }

    public int getPlsMin() {
        return plsMin;
    }

    public void setPlsMin(int plsMin) {
        this.plsMin = plsMin;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
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

    public int getPointsInPaint() {
        return pointsInPaint;
    }

    public void setPointsInPaint(int pointsInPaint) {
        this.pointsInPaint = pointsInPaint;
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

    public int getFoulsDrawn() {
        return foulsDrawn;
    }

    public void setFoulsDrawn(int foulsDrawn) {
        this.foulsDrawn = foulsDrawn;
    }

    public int getPointsOffTurnovers() {
        return pointsOffTurnovers;
    }

    public void setPointsOffTurnovers(int pointsOffTurnovers) {
        this.pointsOffTurnovers = pointsOffTurnovers;
    }

    public int getSecondChancePts() {
        return secondChancePts;
    }

    public void setSecondChancePts(int secondChancePts) {
        this.secondChancePts = secondChancePts;
    }
}
