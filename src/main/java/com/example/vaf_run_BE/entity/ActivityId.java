package com.example.vaf_run_BE.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ActivityId {
    private String name;
    private Float distance;
    private Integer totalTime;
    private LocalDate date;
}
