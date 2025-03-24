package com.blc.backend.model;

import java.util.List;

public class Player {
    private String id;
    private String status;
    private String fullName;
    private String firstName;
    private String lastName;
    private String abbrName;
    private int height; // in inches
    private int weight; // in pounds
    private String position;
    private String primaryPosition;
    private String experience;
    private String birthPlace;
    private String updated;
    private League league;
    private List<Season> seasons;

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAbbrName() { return abbrName; }
    public void setAbbrName(String abbrName) { this.abbrName = abbrName; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getPrimaryPosition() { return primaryPosition; }
    public void setPrimaryPosition(String primaryPosition) { this.primaryPosition = primaryPosition; }

    public String getExperience() { return experience; }
    public void setExperience(String experience) { this.experience = experience; }

    public String getBirthPlace() { return birthPlace; }
    public void setBirthPlace(String birthPlace) { this.birthPlace = birthPlace; }

    public String getUpdated() { return updated; }
    public void setUpdated(String updated) { this.updated = updated; }

    public League getLeague() { return league; }
    public void setLeague(League league) { this.league = league; }

    public List<Season> getSeasons() { return seasons; }
    public void setSeasons(List<Season> seasons) { this.seasons = seasons; }

    // Nested League class
    public static class League {
        private String id;
        private String name;
        private String alias;

        // Getters and setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getAlias() { return alias; }
        public void setAlias(String alias) { this.alias = alias; }
    }

    // Nested Season class
    public static class Season {
        private String id;
        private int year;
        private String type;
        private List<TeamStats> teams;

        // Getters and setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public int getYear() { return year; }
        public void setYear(int year) { this.year = year; }

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public List<TeamStats> getTeams() { return teams; }
        public void setTeams(List<TeamStats> teams) { this.teams = teams; }

        // Nested TeamStats class
        public static class TeamStats {
            private String id;
            private String name;
            private String market;
            private String alias;
            private TotalStats total;
            private AverageStats average;

            // Getters and setters
            public String getId() { return id; }
            public void setId(String id) { this.id = id; }

            public String getName() { return name; }
            public void setName(String name) { this.name = name; }

            public String getMarket() { return market; }
            public void setMarket(String market) { this.market = market; }

            public String getAlias() { return alias; }
            public void setAlias(String alias) { this.alias = alias; }

            public TotalStats getTotal() { return total; }
            public void setTotal(TotalStats total) { this.total = total; }

            public AverageStats getAverage() { return average; }
            public void setAverage(AverageStats average) { this.average = average; }

            // Nested TotalStats class
            public static class TotalStats {
                private int gamesPlayed;
                private int gamesStarted;
                private int minutes;
                private int fieldGoalsMade;
                private int fieldGoalsAtt;
                private double fieldGoalsPct;
                private int twoPointsMade;
                private int twoPointsAtt;
                private double twoPointsPct;
                private int threePointsMade;
                private int threePointsAtt;
                private double threePointsPct;
                private int blockedAtt;
                private int freeThrowsMade;
                private int freeThrowsAtt;
                private double freeThrowsPct;
                private int offensiveRebounds;
                private int defensiveRebounds;
                private int rebounds;
                private int assists;
                private int turnovers;
                private double assistsTurnoverRatio;
                private int steals;
                private int blocks;
                private int personalFouls;
                private int techFouls;
                private int points;
                private int flagrantFouls;
                private int ejections;
                private int foulouts;
                private double trueShootingAtt;
                private double trueShootingPct;
                private int efficiency;

                // Getters and setters
                public int getGamesPlayed() { return gamesPlayed; }
                public void setGamesPlayed(int gamesPlayed) { this.gamesPlayed = gamesPlayed; }

                public int getGamesStarted() { return gamesStarted; }
                public void setGamesStarted(int gamesStarted) { this.gamesStarted = gamesStarted; }

                public int getMinutes() { return minutes; }
                public void setMinutes(int minutes) { this.minutes = minutes; }

                public int getFieldGoalsMade() { return fieldGoalsMade; }
                public void setFieldGoalsMade(int fieldGoalsMade) { this.fieldGoalsMade = fieldGoalsMade; }

                public int getFieldGoalsAtt() { return fieldGoalsAtt; }
                public void setFieldGoalsAtt(int fieldGoalsAtt) { this.fieldGoalsAtt = fieldGoalsAtt; }

                public double getFieldGoalsPct() { return fieldGoalsPct; }
                public void setFieldGoalsPct(double fieldGoalsPct) { this.fieldGoalsPct = fieldGoalsPct; }

                public int getTwoPointsMade() { return twoPointsMade; }
                public void setTwoPointsMade(int twoPointsMade) { this.twoPointsMade = twoPointsMade; }

                public int getTwoPointsAtt() { return twoPointsAtt; }
                public void setTwoPointsAtt(int twoPointsAtt) { this.twoPointsAtt = twoPointsAtt; }

                public double getTwoPointsPct() { return twoPointsPct; }
                public void setTwoPointsPct(double twoPointsPct) { this.twoPointsPct = twoPointsPct; }

                public int getThreePointsMade() { return threePointsMade; }
                public void setThreePointsMade(int threePointsMade) { this.threePointsMade = threePointsMade; }

                public int getThreePointsAtt() { return threePointsAtt; }
                public void setThreePointsAtt(int threePointsAtt) { this.threePointsAtt = threePointsAtt; }

                public double getThreePointsPct() { return threePointsPct; }
                public void setThreePointsPct(double threePointsPct) { this.threePointsPct = threePointsPct; }

                public int getBlockedAtt() { return blockedAtt; }
                public void setBlockedAtt(int blockedAtt) { this.blockedAtt = blockedAtt; }

                public int getFreeThrowsMade() { return freeThrowsMade; }
                public void setFreeThrowsMade(int freeThrowsMade) { this.freeThrowsMade = freeThrowsMade; }

                public int getFreeThrowsAtt() { return freeThrowsAtt; }
                public void setFreeThrowsAtt(int freeThrowsAtt) { this.freeThrowsAtt = freeThrowsAtt; }

                public double getFreeThrowsPct() { return freeThrowsPct; }
                public void setFreeThrowsPct(double freeThrowsPct) { this.freeThrowsPct = freeThrowsPct; }

                public int getOffensiveRebounds() { return offensiveRebounds; }
                public void setOffensiveRebounds(int offensiveRebounds) { this.offensiveRebounds = offensiveRebounds; }

                public int getDefensiveRebounds() { return defensiveRebounds; }
                public void setDefensiveRebounds(int defensiveRebounds) { this.defensiveRebounds = defensiveRebounds; }

                public int getRebounds() { return rebounds; }
                public void setRebounds(int rebounds) { this.rebounds = rebounds; }

                public int getAssists() { return assists; }
                public void setAssists(int assists) { this.assists = assists; }

                public int getTurnovers() { return turnovers; }
                public void setTurnovers(int turnovers) { this.turnovers = turnovers; }

                public double getAssistsTurnoverRatio() { return assistsTurnoverRatio; }
                public void setAssistsTurnoverRatio(double assistsTurnoverRatio) { this.assistsTurnoverRatio = assistsTurnoverRatio; }

                public int getSteals() { return steals; }
                public void setSteals(int steals) { this.steals = steals; }

                public int getBlocks() { return blocks; }
                public void setBlocks(int blocks) { this.blocks = blocks; }

                public int getPersonalFouls() { return personalFouls; }
                public void setPersonalFouls(int personalFouls) { this.personalFouls = personalFouls; }

                public int getTechFouls() { return techFouls; }
                public void setTechFouls(int techFouls) { this.techFouls = techFouls; }

                public int getPoints() { return points; }
                public void setPoints(int points) { this.points = points; }

                public int getFlagrantFouls() { return flagrantFouls; }
                public void setFlagrantFouls(int flagrantFouls) { this.flagrantFouls = flagrantFouls; }

                public int getEjections() { return ejections; }
                public void setEjections(int ejections) { this.ejections = ejections; }

                public int getFoulouts() { return foulouts; }
                public void setFoulouts(int foulouts) { this.foulouts = foulouts; }

                public double getTrueShootingAtt() { return trueShootingAtt; }
                public void setTrueShootingAtt(double trueShootingAtt) { this.trueShootingAtt = trueShootingAtt; }

                public double getTrueShootingPct() { return trueShootingPct; }
                public void setTrueShootingPct(double trueShootingPct) { this.trueShootingPct = trueShootingPct; }

                public int getEfficiency() { return efficiency; }
                public void setEfficiency(int efficiency) { this.efficiency = efficiency; }
            }

            // Nested AverageStats class
            public static class AverageStats {
                private double minutes;
                private double points;
                private double offRebounds;
                private double defRebounds;
                private double rebounds;
                private double assists;
                private double steals;
                private double blocks;
                private double turnovers;
                private double personalFouls;
                private double flagrantFouls;
                private double blockedAtt;
                private double fieldGoalsMade;
                private double fieldGoalsAtt;
                private double threePointsMade;
                private double threePointsAtt;
                private double freeThrowsMade;
                private double freeThrowsAtt;
                private double twoPointsMade;
                private double twoPointsAtt;
                private double efficiency;
                private double trueShootingAtt;

                // Getters and setters
                public double getMinutes() { return minutes; }
                public void setMinutes(double minutes) { this.minutes = minutes; }

                public double getPoints() { return points; }
                public void setPoints(double points) { this.points = points; }

                public double getOffRebounds() { return offRebounds; }
                public void setOffRebounds(double offRebounds) { this.offRebounds = offRebounds; }

                public double getDefRebounds() { return defRebounds; }
                public void setDefRebounds(double defRebounds) { this.defRebounds = defRebounds; }

                public double getRebounds() { return rebounds; }
                public void setRebounds(double rebounds) { this.rebounds = rebounds; }

                public double getAssists() { return assists; }
                public void setAssists(double assists) { this.assists = assists; }

                public double getSteals() { return steals; }
                public void setSteals(double steals) { this.steals = steals; }

                public double getBlocks() { return blocks; }
                public void setBlocks(double blocks) { this.blocks = blocks; }

                public double getTurnovers() { return turnovers; }
                public void setTurnovers(double turnovers) { this.turnovers = turnovers; }

                public double getPersonalFouls() { return personalFouls; }
                public void setPersonalFouls(double personalFouls) { this.personalFouls = personalFouls; }

                public double getFlagrantFouls() { return flagrantFouls; }
                public void setFlagrantFouls(double flagrantFouls) { this.flagrantFouls = flagrantFouls; }

                public double getBlockedAtt() { return blockedAtt; }
                public void setBlockedAtt(double blockedAtt) { this.blockedAtt = blockedAtt; }

                public double getFieldGoalsMade() { return fieldGoalsMade; }
                public void setFieldGoalsMade(double fieldGoalsMade) { this.fieldGoalsMade = fieldGoalsMade; }

                public double getFieldGoalsAtt() { return fieldGoalsAtt; }
                public void setFieldGoalsAtt(double fieldGoalsAtt) { this.fieldGoalsAtt = fieldGoalsAtt; }

                public double getThreePointsMade() { return threePointsMade; }
                public void setThreePointsMade(double threePointsMade) { this.threePointsMade = threePointsMade; }

                public double getThreePointsAtt() { return threePointsAtt; }
                public void setThreePointsAtt(double threePointsAtt) { this.threePointsAtt = threePointsAtt; }

                public double getFreeThrowsMade() { return freeThrowsMade; }
                public void setFreeThrowsMade(double freeThrowsMade) { this.freeThrowsMade = freeThrowsMade; }

                public double getFreeThrowsAtt() { return freeThrowsAtt; }
                public void setFreeThrowsAtt(double freeThrowsAtt) { this.freeThrowsAtt = freeThrowsAtt; }

                public double getTwoPointsMade() { return twoPointsMade; }
                public void setTwoPointsMade(double twoPointsMade) { this.twoPointsMade = twoPointsMade; }

                public double getTwoPointsAtt() { return twoPointsAtt; }
                public void setTwoPointsAtt(double twoPointsAtt) { this.twoPointsAtt = twoPointsAtt; }

                public double getEfficiency() { return efficiency; }
                public void setEfficiency(double efficiency) { this.efficiency = efficiency; }

                public double getTrueShootingAtt() { return trueShootingAtt; }
                public void setTrueShootingAtt(double trueShootingAtt) { this.trueShootingAtt = trueShootingAtt; }
            }
        }
    }
}
