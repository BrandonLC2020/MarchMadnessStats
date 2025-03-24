package com.blc.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Season {

    @JsonProperty("id")
    private String id;
    
    @JsonProperty("year")
    private int startYear;
    
    @JsonProperty("start_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String startDate;
    
    @JsonProperty("end_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String endDate;
    
    @JsonProperty("status")
    private String status;
    
    @JsonProperty("type")
    private Type type;

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int year) {
        this.startYear = year;
    }

    public void setYear(int year) {
        this.startYear = year;
    }

    public int getYear() {
        return this.startYear;
    }

     // Calculate and return the end year (1 more than the start year)
     public int getEndYear() {
        return this.startYear + 1;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    // Nested class for Type
    public static class Type {

        @JsonProperty("code")
        private String code;

        @JsonProperty("name")
        private String name;

        // Getters and setters
        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
