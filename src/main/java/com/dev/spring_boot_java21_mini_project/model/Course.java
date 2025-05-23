package com.dev.spring_boot_java21_mini_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Course {
    @Id
    private String courseId;
    private String courseName;
    private String trainer;
    private int durationInWeeks;

    public Course() {
    }

    public Course(String courseName, String trainer, int durationInWeeks) {
        this.courseName = courseName;
        this.trainer = trainer;
        this.durationInWeeks = durationInWeeks;
    }
}
