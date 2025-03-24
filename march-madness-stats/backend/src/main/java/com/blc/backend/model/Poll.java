package com.blc.backend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Poll {
    @JsonProperty("rankings")
    private List<TeamRanking> rankings;

    public List<TeamRanking> getRankings() {
        return rankings;
    }

    public void setRankings(List<TeamRanking> rankings) {
        this.rankings = rankings;
    }
}
