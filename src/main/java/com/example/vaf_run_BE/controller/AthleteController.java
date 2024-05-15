package com.example.vaf_run_BE.controller;

import com.example.vaf_run_BE.service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin(originPatterns = "*")
@SuppressWarnings("unused")
public class AthleteController {
    @Autowired
    private AthleteService athleteService;
    @GetMapping("athletes/{name}/activity")
    public ResponseEntity<?> getActivity(@PathVariable("name") String name) {
        return ResponseEntity.ok().body(athleteService.getActivity(name));
    }
    @PostMapping("athlete")
    public ResponseEntity<?> addAthlete(
            @RequestParam("name") String name
    ){
        athleteService.addAthlete(name);
        return ResponseEntity.ok().body(null);
    }
    @GetMapping("athletes/activity")
    public ResponseEntity<?> getActivitiesAtDate(
            @RequestParam("date") LocalDate date
    ){
        return ResponseEntity.ok().body(athleteService.getActivitiesAtDate(date));
    }
    @PostMapping("athletes/activity")
    public ResponseEntity<?> addActivity(
            @RequestParam("name") String name,
            @RequestParam("distance") Float distance,
            @RequestParam("totalTime") Integer totalTime ,
            @RequestParam("pace") String pace,
            @RequestParam("date") String date
            ){
        athleteService.addActivity(name,distance,pace,totalTime,LocalDate.parse(date));
        return ResponseEntity.ok().body(null);
    }
    @GetMapping("athletes")
    public ResponseEntity<?> getAthletes(){
        return ResponseEntity.ok().body(athleteService.getAthletes());
    }
}
