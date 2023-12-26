package com.maxi.backschool.dtos;

public class CourseAddDTO {

    private Long id;
    private String name;

    public CourseAddDTO() {
    }

    public CourseAddDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
}
