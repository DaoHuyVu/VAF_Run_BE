package com.example.vaf_run_BE.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity(name = "activity")
@NoArgsConstructor
public class Activity {
    @EmbeddedId
    private ActivityId id;
    private String avgPace;
    public Activity(String name,Float distance,Integer totalTime,LocalDate date,String avgPace){
        id = new ActivityId(name,distance,totalTime,date);
        this.avgPace = avgPace;
    }
}
