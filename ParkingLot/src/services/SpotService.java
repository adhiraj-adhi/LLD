package services;

import dtos.CreateSpotRequestDto;
import dtos.CreateSpotResponseDto;
import models.ParkingFloor;
import models.Spot;
import models.SpotStatus;
import models.SpotType;
import repositories.ParkingFloorRepository;
import repositories.SpotRepository;

import java.util.List;
import java.util.stream.Collectors;

public class SpotService {
    private ParkingFloorRepository parkingFloorRepository;
    private SpotRepository spotRepository;

    public SpotService(ParkingFloorRepository parkingFloorRepository, SpotRepository spotRepository) {
        this.parkingFloorRepository = parkingFloorRepository;
        this.spotRepository = spotRepository;
    }

    public List<CreateSpotResponseDto> createSpot(Long floorId, List<CreateSpotRequestDto> createSpotRequestDtos) {
        // Getting Floor with floor Id:
        ParkingFloor parkingFloor = parkingFloorRepository.findById(floorId);
        if (parkingFloor==null) return null;

        List<Spot> savedSpots = createSpotRequestDtos.stream().map(createSpotRequestDto -> {
            Spot spot = new Spot();
            spot.setSpotStatus(SpotStatus.AVAILABLE);
            spot.setSpotType(createSpotRequestDto.getSpotType());
            spot.setFloorNumber(parkingFloor.getFloorNumber());
            Spot savedSpot = spotRepository.save(spot); // this will bombard DB for huge number of DB creation -> It is temporary
            parkingFloor.getSpots().add(savedSpot);
            return spot;
        }).collect(Collectors.toList());

        parkingFloorRepository.update(parkingFloor);

        return savedSpots.stream().map(savedSpot-> {
            CreateSpotResponseDto createSpotResponseDto = new CreateSpotResponseDto();
            createSpotResponseDto.setSpot(savedSpot);
            return createSpotResponseDto;
        }).toList();
    }
}
