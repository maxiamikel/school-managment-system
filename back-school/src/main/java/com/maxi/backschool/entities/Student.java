package com.maxi.backschool.entities;

import java.time.LocalDate;

import com.maxi.backschool.enums.UserGender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "student")
public class Student extends User {

    @NotBlank(message = "Tuition is required")
    @Column(name = "tuition")
    private String tuition;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Student() {
        super();
    }

    public Student(String tuition) {
        this.tuition = tuition;
        // this.course = course;
    }

    public Student(String name, String email, String foneNumber, UserGender gender, LocalDate birthDay,
            LocalDate registrationDate, String tuition, Course course) {
        super(name, email, foneNumber, gender, birthDay, registrationDate);
        this.tuition = tuition;
        this.course = course;
    }

    public String getTuition() {
        return tuition;
    }

    public void setTuition(String tuition) {
        this.tuition = tuition;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
