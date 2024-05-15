package com.example.vaf_run_BE.service;

import com.example.vaf_run_BE.ActivityDto;
import com.example.vaf_run_BE.entity.Activity;
import com.example.vaf_run_BE.entity.Athlete;
import com.example.vaf_run_BE.repository.ActivityRepository;
import com.example.vaf_run_BE.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AthleteService {
    @Autowired
    private AthleteRepository athleteRepository;
    @Autowired
    private ActivityRepository activityRepository;
    public List<Athlete> getAthletes(){
        return athleteRepository.findAll();
    }
    public ActivityDto getActivity(String name){
        List<Activity> activities =  activityRepository.findByName(name);
        Float distance = 0f;
        Integer totalTime = 0;
        ActivityDto activityDto = new ActivityDto();
        for(Activity activity : activities){
            distance += activity.getId().getDistance();
            totalTime += activity.getId().getTotalTime();
        }

        float paceKm = totalTime/(distance/1000)/60;
        int paceMinute = (int) paceKm;
        int paceSecond = (int) ((paceKm - paceMinute)*60);
        String pace = String.format("%02d:%02d",paceMinute,paceSecond);

        activityDto.setName(name);
        activityDto.setDistance(distance);
        activityDto.setTotalTime(totalTime);
        activityDto.setAvgPace(pace);
        return activityDto;
    }
    public void addAthlete(String name){
        Athlete athlete = new Athlete();
        athlete.setName(name);
        athleteRepository.save(athlete);
    }
    public void addActivity(String name, Float distance, String pace,Integer totalTime, LocalDate date){
        activityRepository.addActivity(name,distance,totalTime,pace,date);
    }
    public List<ActivityDto> getActivitiesAtDate(LocalDate date){
        return activityRepository.findByDate(date).stream().map(
                activity -> new ActivityDto(
                        activity.getId().getName(),
                        activity.getId().getDistance(),
                        activity.getId().getTotalTime(),
                        activity.getAvgPace()
                )
        ).collect(Collectors.toList());
    }
}
