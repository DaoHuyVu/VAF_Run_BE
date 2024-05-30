package com.example.vaf_run_BE.repository;

import com.example.vaf_run_BE.ActivityDto;
import com.example.vaf_run_BE.entity.Activity;
import com.example.vaf_run_BE.entity.ActivityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;
@Repository
public interface ActivityRepository extends JpaRepository<Activity, ActivityId>,CustomActivityRepository {
    @Query("""
            SELECT
            new com.example.vaf_run_BE.entity.Activity(
            a.id.name,a.id.distance,a.id.totalTime,a.id.date,a.avgPace
            )
            FROM activity a WHERE a.id.name = :name
            """)
    List<Activity> findByName(String name);
    @Query("""
            SELECT new com.example.vaf_run_BE.ActivityDto(
            a.id.name,a.id.distance,a.id.totalTime,a.avgPace,b.groupId
            )
            FROM activity a
            join athlete b
            on a.id.name = b.name
            WHERE a.id.date = :date
            order by a.id.distance desc
            """)
    List<ActivityDto> findByDate(LocalDate date);

}
