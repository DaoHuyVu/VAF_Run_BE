package com.example.vaf_run_BE;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class ActivityDto {
    private String name;
    private Float distance;
    private Integer totalTime;
    private String avgPace;
    private Integer groupId;
}
