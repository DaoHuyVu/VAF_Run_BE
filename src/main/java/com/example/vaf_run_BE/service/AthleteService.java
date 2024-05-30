package com.example.vaf_run_BE.service;

import com.example.vaf_run_BE.ActivityDto;
import com.example.vaf_run_BE.entity.Activity;
import com.example.vaf_run_BE.entity.Athlete;
import com.example.vaf_run_BE.repository.ActivityRepository;
import com.example.vaf_run_BE.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
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

        int groupId = athleteRepository.findGroupIdByName(name).getFirst();

        activityDto.setName(name);
        activityDto.setDistance(distance);
        activityDto.setTotalTime(totalTime);
        activityDto.setAvgPace(pace);
        activityDto.setGroupId(groupId);
        return activityDto;
    }
    @Transactional
    public void addAthlete(String name){
        Athlete athlete = new Athlete();
        athlete.setName(name);
        athleteRepository.save(athlete);
    }
    @Transactional
    public void addActivity(String name, Float distance, String pace,Integer totalTime, LocalDate date){
        activityRepository.addActivity(name,distance,totalTime,pace,date);
    }
    public List<ActivityDto> getActivities(LocalDate date){
        return activityRepository.findByDate(date);
    }
}
