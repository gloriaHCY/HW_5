package com.example.HW_5;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SightService {

    private final SightRepository sightRepository;
    public Optional<List<Sight>> getZoneSights(String input) {

        return sightRepository.findSightsByZone(input);
    }
}
