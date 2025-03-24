package com.blc.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Scoring {
    @JsonProperty("type")
    private String type;

    @JsonProperty("number")
    private int number;

    @JsonProperty("sequence")
    private int sequence;

    @JsonProperty("points")
    private int points;

    // Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
