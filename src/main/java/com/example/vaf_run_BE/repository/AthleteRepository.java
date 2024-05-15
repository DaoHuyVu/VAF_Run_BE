package com.example.vaf_run_BE.repository;

import com.example.vaf_run_BE.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete,Long> {

}
