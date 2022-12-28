package com.example.HW_5;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class SightController {
    private final SightService sightService;

    @GetMapping("/zone/{input}")
    public ResponseEntity<Optional<List<Sight>>> getProduct(@PathVariable("input") String input){

        Optional<List<Sight>> sights=sightService.getZoneSights(input);

        return ResponseEntity.ok().body(sights);
    }

}
