package com.maxi.backschool.dtos;

import com.maxi.backschool.entities.Course;

public class CourseDesativateDTO {

    private Long id;

    public CourseDesativateDTO() {
        // super();
    }

    public CourseDesativateDTO(Course obj) {
        this.id = obj.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
