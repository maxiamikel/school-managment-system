package com.maxi.backschool.services;

import java.util.List;

import com.maxi.backschool.dtos.CourseAddDTO;
import com.maxi.backschool.dtos.CourseDesativateDTO;
import com.maxi.backschool.dtos.CourseUpdateDTO;
import com.maxi.backschool.entities.Course;

public interface CourseService {

    public Course findByCourseId(Long id);

    public Course addNewCourse(CourseAddDTO obj);

    public List<Course> findAll();

    public void updateCourse(CourseUpdateDTO obj);

    public void deativateCourse(CourseDesativateDTO obj);

    public void ativateCourse(CourseDesativateDTO obj);

    // public List<Course> findByName(String name);

}
