package com.blc.backend.model;

public class Period {
    private String type;
    private String id;
    private int number;
    private int sequence;
    private String minutes;
    private int fieldGoalsMade;
    private int fieldGoalsAtt;
    private double fieldGoalsPct;
    private int threePointsMade;
    private int threePointsAtt;
    private double threePointsPct;
    private int twoPointsMade;
    private int twoPointsAtt;
    private double twoPointsPct;
    private int blockedAtt;
    private int freeThrowsMade;
    private int freeThrowsAtt;
    private double freeThrowsPct;
    private int offensiveRebounds;
    private int defensiveRebounds;
    private int rebounds;
    private int assists;
    private int turnovers;
    private int steals;
    private int blocks;
    private double assistsTurnoverRatio;
    private int personalFouls;
    private int offensiveFouls;
    private int techFouls;
    private int flagrantFouls;
    private int plsMin;
    private int points;
    private double effectiveFgPct;
    private int efficiency;
    private double efficiencyGameScore;
    private int pointsInPaint;
    private int pointsInPaintAtt;
    private int pointsInPaintMade;
    private double pointsInPaintPct;
    private double trueShootingAtt;
    private double trueShootingPct;
    private int foulsDrawn;
    private int pointsOffTurnovers;
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
