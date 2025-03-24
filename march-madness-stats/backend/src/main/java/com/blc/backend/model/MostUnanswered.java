package com.blc.backend.model;

public class MostUnanswered {
    private int points;
    private int ownScore;
    private int oppScore;

    // Getters and Setters
    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }

    public int getOwnScore() { return ownScore; }
    public void setOwnScore(int ownScore) { this.ownScore = ownScore; }

    public int getOppScore() { return oppScore; }
    public void setOppScore(int oppScore) { this.oppScore = oppScore; }
}
