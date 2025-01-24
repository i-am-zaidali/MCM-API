package com.crayyy_zee.MissionChiefMetrics.Scraper;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class MissionChiefScraper {
    private final UriComponentsBuilder MISSION_CHIEF_BASE_URI = UriComponentsBuilder.fromUriString(
            "https://www.missionchief.com");

    private final URI ALLIANCE_LEADERBOARD_URL = MISSION_CHIEF_BASE_URI.cloneBuilder()
            .path("/alliances")
            .build()
            .toUri();

    // Alliance ID is a path variable
    private final UriComponentsBuilder ALLIANCE_MEMBERS_URL = MISSION_CHIEF_BASE_URI.cloneBuilder()
            .path("/verband/mitglieder");

}
