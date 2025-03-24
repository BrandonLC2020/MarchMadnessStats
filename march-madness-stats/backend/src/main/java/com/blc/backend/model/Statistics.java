package com.blc.backend.model;

import java.util.List;

public class Statistics {
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
    private int assists;
    private int steals;
    private int blocks;
    private double assistsTurnoverRatio;
    private int personalFouls;
    private int ejections;
    private int foulouts;
    private int points;
    private int fastBreakPts;
    private int secondChancePts;
    private int teamTurnovers;
    private int pointsOffTurnovers;
    private int teamRebounds;
    private int flagrantFouls;
    private int playerTechFouls;
    private int teamTechFouls;
    private int coachTechFouls;
    private int pointsInPaint;
    private int teamOffensiveRebounds;
    private int teamDefensiveRebounds;
    private int totalRebounds;
    private int totalTurnovers;
    private int personalRebounds;
    private int playerTurnovers;
    private int fieldGoalsAtRimMade;
    private int fieldGoalsAtRimAtt;
    private double fieldGoalsAtRimPct;
    private int fieldGoalsAtMidrangeMade;
    private int fieldGoalsAtMidrangeAtt;
    private double fieldGoalsAtMidrangePct;
    private int benchPoints;
    private int biggestLead;
    private double effectiveFgPct;
    private int efficiency;
    private double efficiencyGameScore;
    private int foulsDrawn;
    private int offensiveFouls;
    private int plsMin;
    private int pointsInPaintAtt;
    private int pointsInPaintMade;
    private double pointsInPaintPct;
    private int totalFouls;
    private double trueShootingAtt;
    private double trueShootingPct;
    private int coachEjections;
    private MostUnanswered mostUnanswered;
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
