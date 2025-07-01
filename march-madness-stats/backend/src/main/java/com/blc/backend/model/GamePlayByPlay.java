package com.blc.backend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Main class representing the entire Play-by-Play JSON response.
 * This class is the root of the JSON object.
 */
public class GamePlayByPlay {

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("status")
    private String status;

    @JsonProperty("coverage")
    private String coverage;

    @JsonProperty("neutral_site")
    private boolean neutralSite;

    @JsonProperty("scheduled")
    private String scheduled;

    @JsonProperty("conference_game")
    private boolean conferenceGame;

    @JsonProperty("attendance")
    private int attendance;

    @JsonProperty("lead_changes")
    private int leadChanges;

    @JsonProperty("times_tied")
    private int timesTied;

    @JsonProperty("clock")
    private String clock;

    @JsonProperty("half")
    private int half;

    @JsonProperty("track_on_court")
    private boolean trackOnCourt;

    @JsonProperty("entry_mode")
    private String entryMode;

    @JsonProperty("clock_decimal")
    private String clockDecimal;

    @JsonProperty("broadcasts")
    private List<Broadcast> broadcasts;

    @JsonProperty("time_zones")
    private TimeZones timeZones;

    @JsonProperty("season")
    private Season season;

    @JsonProperty("home")
    private Team home;

    @JsonProperty("away")
    private Team away;

    @JsonProperty("periods")
    private List<Period> periods;

    @JsonProperty("deleted_events")
    private List<DeletedEvent> deletedEvents;

    // Getters and Setters for all fields
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getCoverage() { return coverage; }
    public void setCoverage(String coverage) { this.coverage = coverage; }
    public boolean isNeutralSite() { return neutralSite; }
    public void setNeutralSite(boolean neutralSite) { this.neutralSite = neutralSite; }
    public String getScheduled() { return scheduled; }
    public void setScheduled(String scheduled) { this.scheduled = scheduled; }
    public boolean isConferenceGame() { return conferenceGame; }
    public void setConferenceGame(boolean conferenceGame) { this.conferenceGame = conferenceGame; }
    public int getAttendance() { return attendance; }
    public void setAttendance(int attendance) { this.attendance = attendance; }
    public int getLeadChanges() { return leadChanges; }
    public void setLeadChanges(int leadChanges) { this.leadChanges = leadChanges; }
    public int getTimesTied() { return timesTied; }
    public void setTimesTied(int timesTied) { this.timesTied = timesTied; }
    public String getClock() { return clock; }
    public void setClock(String clock) { this.clock = clock; }
    public int getHalf() { return half; }
    public void setHalf(int half) { this.half = half; }
    public boolean isTrackOnCourt() { return trackOnCourt; }
    public void setTrackOnCourt(boolean trackOnCourt) { this.trackOnCourt = trackOnCourt; }
    public String getEntryMode() { return entryMode; }
    public void setEntryMode(String entryMode) { this.entryMode = entryMode; }
    public String getClockDecimal() { return clockDecimal; }
    public void setClockDecimal(String clockDecimal) { this.clockDecimal = clockDecimal; }
    public List<Broadcast> getBroadcasts() { return broadcasts; }
    public void setBroadcasts(List<Broadcast> broadcasts) { this.broadcasts = broadcasts; }
    public TimeZones getTimeZones() { return timeZones; }
    public void setTimeZones(TimeZones timeZones) { this.timeZones = timeZones; }
    public Season getSeason() { return season; }
    public void setSeason(Season season) { this.season = season; }
    public Team getHome() { return home; }
    public void setHome(Team home) { this.home = home; }
    public Team getAway() { return away; }
    public void setAway(Team away) { this.away = away; }
    public List<Period> getPeriods() { return periods; }
    public void setPeriods(List<Period> periods) { this.periods = periods; }
    public List<DeletedEvent> getDeletedEvents() { return deletedEvents; }
    public void setDeletedEvents(List<DeletedEvent> deletedEvents) { this.deletedEvents = deletedEvents; }
}

/**
 * Represents a broadcast network.
 */
class Broadcast {
    @JsonProperty("type")
    private String type;
    @JsonProperty("locale")
    private String locale;
    @JsonProperty("network")
    private String network;

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getLocale() { return locale; }
    public void setLocale(String locale) { this.locale = locale; }
    public String getNetwork() { return network; }
    public void setNetwork(String network) { this.network = network; }
}

/**
 * Represents the time zones for the game.
 */
class TimeZones {
    @JsonProperty("venue")
    private String venue;
    @JsonProperty("home")
    private String home;
    @JsonProperty("away")
    private String away;

    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }
    public String getHome() { return home; }
    public void setHome(String home) { this.home = home; }
    public String getAway() { return away; }
    public void setAway(String away) { this.away = away; }
}

/**
 * Represents the season information.
 */
class Season {
    @JsonProperty("id")
    private String id;
    @JsonProperty("year")
    private int year;
    @JsonProperty("type")
    private String type;
    @JsonProperty("name")
    private String name;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

/**
 * Represents a team (home or away) in the main game object.
 */
class Team {
    @JsonProperty("name")
    private String name;
    @JsonProperty("alias")
    private String alias;
    @JsonProperty("market")
    private String market;
    @JsonProperty("id")
    private String id;
    @JsonProperty("points")
    private int points;
    @JsonProperty("rank")
    private int rank;
    @JsonProperty("remaining_timeouts")
    private int remainingTimeouts;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAlias() { return alias; }
    public void setAlias(String alias) { this.alias = alias; }
    public String getMarket() { return market; }
    public void setMarket(String market) { this.market = market; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }
    public int getRank() { return rank; }
    public void setRank(int rank) { this.rank = rank; }
    public int getRemainingTimeouts() { return remainingTimeouts; }
    public void setRemainingTimeouts(int remainingTimeouts) { this.remainingTimeouts = remainingTimeouts; }
}

/**
 * Represents a period in the game.
 */
class Period {
    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    private String id;
    @JsonProperty("number")
    private int number;
    @JsonProperty("sequence")
    private int sequence;
    @JsonProperty("scoring")
    private PeriodScoring scoring;
    @JsonProperty("events")
    private List<Event> events;

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }
    public int getSequence() { return sequence; }
    public void setSequence(int sequence) { this.sequence = sequence; }
    public PeriodScoring getScoring() { return scoring; }
    public void setScoring(PeriodScoring scoring) { this.scoring = scoring; }
    public List<Event> getEvents() { return events; }
    public void setEvents(List<Event> events) { this.events = events; }
}

/**
 * Represents the scoring details within a period.
 */
class PeriodScoring {
    @JsonProperty("times_tied")
    private int timesTied;
    @JsonProperty("lead_changes")
    private int leadChanges;
    @JsonProperty("home")
    private ScoringTeam home;
    @JsonProperty("away")
    private ScoringTeam away;

    public int getTimesTied() { return timesTied; }
    public void setTimesTied(int timesTied) { this.timesTied = timesTied; }
    public int getLeadChanges() { return leadChanges; }
    public void setLeadChanges(int leadChanges) { this.leadChanges = leadChanges; }
    public ScoringTeam getHome() { return home; }
    public void setHome(ScoringTeam home) { this.home = home; }
    public ScoringTeam getAway() { return away; }
    public void setAway(ScoringTeam away) { this.away = away; }
}

/**
 * Represents a team's scoring details within a period.
 */
class ScoringTeam {
    @JsonProperty("name")
    private String name;
    @JsonProperty("market")
    private String market;
    @JsonProperty("id")
    private String id;
    @JsonProperty("points")
    private int points;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getMarket() { return market; }
    public void setMarket(String market) { this.market = market; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }
}

/**
 * Represents a single event in a period.
 */
class Event {
    @JsonProperty("id")
    private String id;
    @JsonProperty("clock")
    private String clock;
    @JsonProperty("updated")
    private String updated;
    @JsonProperty("description")
    private String description;
    @JsonProperty("sequence")
    private long sequence;
    @JsonProperty("home_points")
    private int homePoints;
    @JsonProperty("away_points")
    private int awayPoints;
    @JsonProperty("clock_decimal")
    private String clockDecimal;
    @JsonProperty("created")
    private String created;
    @JsonProperty("event_type")
    private String eventType;
    @JsonProperty("attribution")
    private Attribution attribution;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("possession")
    private Possession possession;
    @JsonProperty("on_court")
    private OnCourt onCourt;
    @JsonProperty("statistics")
    private List<Statistic> statistics;
    @JsonProperty("attempt")
    private String attempt;
    @JsonProperty("turnover_type")
    private String turnoverType;
    @JsonProperty("duration")
    private Integer duration; // Using Integer to handle potential nulls

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getClock() { return clock; }
    public void setClock(String clock) { this.clock = clock; }
    public String getUpdated() { return updated; }
    public void setUpdated(String updated) { this.updated = updated; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public long getSequence() { return sequence; }
    public void setSequence(long sequence) { this.sequence = sequence; }
    public int getHomePoints() { return homePoints; }
    public void setHomePoints(int homePoints) { this.homePoints = homePoints; }
    public int getAwayPoints() { return awayPoints; }
    public void setAwayPoints(int awayPoints) { this.awayPoints = awayPoints; }
    public String getClockDecimal() { return clockDecimal; }
    public void setClockDecimal(String clockDecimal) { this.clockDecimal = clockDecimal; }
    public String getCreated() { return created; }
    public void setCreated(String created) { this.created = created; }
    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }
    public Attribution getAttribution() { return attribution; }
    public void setAttribution(Attribution attribution) { this.attribution = attribution; }
    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }
    public Possession getPossession() { return possession; }
    public void setPossession(Possession possession) { this.possession = possession; }
    public OnCourt getOnCourt() { return onCourt; }
    public void setOnCourt(OnCourt onCourt) { this.onCourt = onCourt; }
    public List<Statistic> getStatistics() { return statistics; }
    public void setStatistics(List<Statistic> statistics) { this.statistics = statistics; }
    public String getAttempt() { return attempt; }
    public void setAttempt(String attempt) { this.attempt = attempt; }
    public String getTurnoverType() { return turnoverType; }
    public void setTurnoverType(String turnoverType) { this.turnoverType = turnoverType; }
    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }
}

/**
 * Represents attribution for an event.
 */
class Attribution {
    @JsonProperty("name")
    private String name;
    @JsonProperty("market")
    private String market;
    @JsonProperty("id")
    private String id;
    @JsonProperty("team_basket")
    private String teamBasket;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getMarket() { return market; }
    public void setMarket(String market) { this.market = market; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTeamBasket() { return teamBasket; }
    public void setTeamBasket(String teamBasket) { this.teamBasket = teamBasket; }
}

/**
 * Represents the location of an event.
 */
class Location {
    @JsonProperty("coord_x")
    private int coordX;
    @JsonProperty("coord_y")
    private int coordY;

    public int getCoordX() { return coordX; }
    public void setCoordX(int coordX) { this.coordX = coordX; }
    public int getCoordY() { return coordY; }
    public void setCoordY(int coordY) { this.coordY = coordY; }
}

/**
 * Represents possession within an event.
 */
class Possession {
    @JsonProperty("name")
    private String name;
    @JsonProperty("market")
    private String market;
    @JsonProperty("id")
    private String id;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getMarket() { return market; }
    public void setMarket(String market) { this.market = market; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}

/**
 * Represents the players on the court during an event.
 */
class OnCourt {
    @JsonProperty("home")
    private OnCourtTeam home;
    @JsonProperty("away")
    private OnCourtTeam away;

    public OnCourtTeam getHome() { return home; }
    public void setHome(OnCourtTeam home) { this.home = home; }
    public OnCourtTeam getAway() { return away; }
    public void setAway(OnCourtTeam away) { this.away = away; }
}

/**
 * Represents a team with players on the court.
 */
class OnCourtTeam {
    @JsonProperty("name")
    private String name;
    @JsonProperty("market")
    private String market;
    @JsonProperty("id")
    private String id;
    @JsonProperty("players")
    private List<Player> players;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getMarket() { return market; }
    public void setMarket(String market) { this.market = market; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public List<Player> getPlayers() { return players; }
    public void setPlayers(List<Player> players) { this.players = players; }
}

/**
 * Represents a player.
 */
class Player {
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("jersey_number")
    private String jerseyNumber;
    @JsonProperty("id")
private String id;

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getJerseyNumber() { return jerseyNumber; }
    public void setJerseyNumber(String jerseyNumber) { this.jerseyNumber = jerseyNumber; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}

/**
 * Represents a statistic associated with an event.
 */
class Statistic {
    @JsonProperty("type")
    private String type;
    @JsonProperty("made")
    private Boolean made;
    @JsonProperty("shot_type")
    private String shotType;
    @JsonProperty("three_point_shot")
    private Boolean threePointShot;
    @JsonProperty("points")
    private Integer points;
    @JsonProperty("team")
    private StatisticTeam team;
    @JsonProperty("player")
    private StatisticPlayer player;
    @JsonProperty("rebound_type")
    private String reboundType;
    @JsonProperty("shot_type_desc")
    private String shotTypeDesc;
    @JsonProperty("free_throw_type")
    private String freeThrowType;

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Boolean getMade() { return made; }
    public void setMade(Boolean made) { this.made = made; }
    public String getShotType() { return shotType; }
    public void setShotType(String shotType) { this.shotType = shotType; }
    public Boolean getThreePointShot() { return threePointShot; }
    public void setThreePointShot(Boolean threePointShot) { this.threePointShot = threePointShot; }
    public Integer getPoints() { return points; }
    public void setPoints(Integer points) { this.points = points; }
    public StatisticTeam getTeam() { return team; }
    public void setTeam(StatisticTeam team) { this.team = team; }
    public StatisticPlayer getPlayer() { return player; }
    public void setPlayer(StatisticPlayer player) { this.player = player; }
    public String getReboundType() { return reboundType; }
    public void setReboundType(String reboundType) { this.reboundType = reboundType; }
    public String getShotTypeDesc() { return shotTypeDesc; }
    public void setShotTypeDesc(String shotTypeDesc) { this.shotTypeDesc = shotTypeDesc; }
    public String getFreeThrowType() { return freeThrowType; }
    public void setFreeThrowType(String freeThrowType) { this.freeThrowType = freeThrowType; }
}

/**
 * Represents a team within a statistic.
 */
class StatisticTeam {
    @JsonProperty("name")
    private String name;
    @JsonProperty("market")
    private String market;
    @JsonProperty("id")
    private String id;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getMarket() { return market; }
    public void setMarket(String market) { this.market = market; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}

/**
 * Represents a player within a statistic.
 */
class StatisticPlayer {
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("jersey_number")
    private String jerseyNumber;
    @JsonProperty("id")
    private String id;

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getJerseyNumber() { return jerseyNumber; }
    public void setJerseyNumber(String jerseyNumber) { this.jerseyNumber = jerseyNumber; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}

/**
 * Represents a deleted event.
 */
class DeletedEvent {
    @JsonProperty("id")
    private String id;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}
