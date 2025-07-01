package com.blc.backend.model;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class TeamProfileTest {

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        // ObjectMapper is the main class from Jackson to work with JSON
        objectMapper = new ObjectMapper();
    }

    @Test
    void canDeserializeFromJson() {
        // A sample JSON string mimicking an API response
        String json = """
        {
          "id": "c10544de-e3bd-4776-ba2e-83df8c017fd1",
          "name": "Hawkeyes",
          "market": "Iowa",
          "alias": "IOWA",
          "founded": 1847,
          "venue": {
            "id": "04c2567a-3a02-462b-b06b-5a4216dd30af",
            "name": "Carver-Hawkeye Arena",
            "capacity": 15500
          },
          "players": [
            {
              "id": "1b2259c6-01d3-4fe8-8b7c-359a222b6d4c",
              "full_name": "Brock Harding",
              "position": "G",
              "jersey_number": "2"
            }
          ]
        }
        """;

        // Attempt to deserialize the JSON into our TeamProfile object
        TeamProfile teamProfile = assertDoesNotThrow(() -> objectMapper.readValue(json, TeamProfile.class));

        // Assert that the object and its fields were populated correctly
        assertThat(teamProfile).isNotNull();
        assertThat(teamProfile.getId()).isEqualTo("c10544de-e3bd-4776-ba2e-83df8c017fd1");
        assertThat(teamProfile.getName()).isEqualTo("Hawkeyes");
        assertThat(teamProfile.getMarket()).isEqualTo("Iowa");
        assertThat(teamProfile.getFounded()).isEqualTo(1847);

        assertThat(teamProfile.getVenue()).isNotNull();
        assertThat(teamProfile.getVenue().getName()).isEqualTo("Carver-Hawkeye Arena");
        assertThat(teamProfile.getVenue().getCapacity()).isEqualTo(15500);

        assertThat(teamProfile.getPlayers()).isNotNull().hasSize(1);
        TeamProfile.Player firstPlayer = teamProfile.getPlayers().get(0);
        assertThat(firstPlayer.getFullName()).isEqualTo("Brock Harding");
        assertThat(firstPlayer.getJerseyNumber()).isEqualTo("2");
    }

    @Test
    void canSerializeToJson() throws JsonProcessingException {
        // Create a test object programmatically
        TeamProfile teamProfile = createTestTeamProfile();

        // Serialize the object to a JSON string
        String json = objectMapper.writeValueAsString(teamProfile);

        // Assert that the JSON string contains the expected data
        assertThat(json).isNotNull();
        assertThat(json).contains("\"id\":\"test-id\"");
        assertThat(json).contains("\"name\":\"Test Team\"");
        assertThat(json).contains("\"venue\":{");
        assertThat(json).contains("\"name\":\"Test Arena\"");
        assertThat(json).contains("\"players\":[");
        assertThat(json).contains("\"full_name\":\"Test Player\"");
    }

    private TeamProfile createTestTeamProfile() {
        TeamProfile teamProfile = new TeamProfile();
        teamProfile.setId("test-id");
        teamProfile.setName("Test Team");
        teamProfile.setMarket("Test Market");
        teamProfile.setAlias("TEST");
        teamProfile.setFounded(2024);

        TeamProfile.Venue venue = new TeamProfile.Venue();
        venue.setId("venue-id");
        venue.setName("Test Arena");
        venue.setCapacity(10000);
        teamProfile.setVenue(venue);

        TeamProfile.Player player = new TeamProfile.Player();
        player.setId("player-id");
        player.setFullName("Test Player");
        player.setPosition("F");
        teamProfile.setPlayers(Collections.singletonList(player));

        return teamProfile;
    }
}