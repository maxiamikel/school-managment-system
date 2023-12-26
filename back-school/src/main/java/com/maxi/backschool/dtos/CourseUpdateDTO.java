package com.maxi.backschool.dtos;

import com.maxi.backschool.entities.Course;

public class CourseUpdateDTO {

    private Long id;
    private String name;

    public CourseUpdateDTO() {
        super();
    }

    public CourseUpdateDTO(Course obj) {
        this.id = obj.getId();
        this.name = obj.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
