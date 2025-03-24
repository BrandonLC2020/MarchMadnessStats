package com.blc.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MostUnanswered {
    @JsonProperty("points")
    private int points;

    @JsonProperty("own_score")
    private int ownScore;

    @JsonProperty("opp_score")
    private int oppScore;

    // Getters and Setters
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getOwnScore() {
        return ownScore;
    }

    public void setOwnScore(int ownScore) {
        this.ownScore = ownScore;
    }

    public int getOppScore() {
        return oppScore;
    }

    public void setOppScore(int oppScore) {
        this.oppScore = oppScore;
    }
}
