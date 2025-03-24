package com.blc.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rankings {
    @JsonProperty("poll")
    private Poll poll;

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }
}
