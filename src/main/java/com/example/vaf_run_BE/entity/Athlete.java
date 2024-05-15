package com.example.vaf_run_BE.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;
import org.hibernate.query.NativeQuery;

@Data
@Entity(name = "athlete")
@Setter
public class Athlete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name="group_id")
    private Integer groupId;
}
