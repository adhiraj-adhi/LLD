package controllers;

import dtos.CreateSpotRequestDto;
import dtos.CreateSpotResponseDto;
import services.SpotService;

import java.util.List;
import java.util.stream.Collectors;

public class SpotController {
    private SpotService spotService;
    public SpotController(SpotService spotService) {
        this.spotService = spotService;
    }

    public List<CreateSpotResponseDto> createSpot(Long floorId,
                        List<CreateSpotRequestDto> createSpotRequestDtos) {
        return spotService.createSpot(floorId, createSpotRequestDtos);
    }
}
