package com.example.vaf_run_BE.repository;

import com.example.vaf_run_BE.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete,Long> {
    @Query("""
            SELECT a.groupId from athlete a where a.name = :name
            """)
    List<Integer> findGroupIdByName(String name);
}
