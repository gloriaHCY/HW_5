package com.example.HW_5;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface SightRepository
        extends MongoRepository<Sight,String> {

    Optional<List<Sight>> findSightsByZone(String zone);


}
