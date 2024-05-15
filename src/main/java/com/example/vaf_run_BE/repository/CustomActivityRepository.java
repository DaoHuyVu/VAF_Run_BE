package com.example.vaf_run_BE.repository;

import java.time.LocalDate;
@FunctionalInterface
interface CustomActivityRepository {
    void addActivity(String name, Float distance, Integer totalTime, String pace, LocalDate date);

}
