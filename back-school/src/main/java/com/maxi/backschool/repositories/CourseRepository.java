package com.maxi.backschool.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maxi.backschool.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c FROM Course c WHERE c.active = true")
    List<Course> findAll();

    @Query("SELECT c FROM Course c WHERE c.name = :name ")
    List<Course> findCourseByName(@Param("name") String name);

    @Query("SELECT c FROM Course c WHERE c.name LIKE %:name% AND c.active = true")
    public List<Course> findCourseByNameLike(@Param("name") String name);

}
