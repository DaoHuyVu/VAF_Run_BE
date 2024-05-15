package com.example.vaf_run_BE.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

public class CustomActivityRepositoryImpl implements CustomActivityRepository{
    @PersistenceContext
    private EntityManager manager;
    @Override
    @Transactional
    public void addActivity(String name, Float distance, Integer totalTime, String pace, LocalDate date) {
        manager.createNativeQuery("""
                INSERT IGNORE INTO activity values(?,?,?,?,?)
                """)
                .setParameter(1,name)
                .setParameter(2,distance)
                .setParameter(3,pace)
                .setParameter(4,totalTime)
                .setParameter(5,date)
                .executeUpdate();
    }

}
