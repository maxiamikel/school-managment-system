package com.maxi.backschool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.backschool.dtos.CourseAddDTO;
import com.maxi.backschool.dtos.CourseDesativateDTO;
import com.maxi.backschool.dtos.CourseUpdateDTO;
import com.maxi.backschool.entities.Course;
import com.maxi.backschool.services.CourseServiceImpl;

@RestController
@RequestMapping("/api/school")
public class CourseController {

    @Autowired
    private CourseServiceImpl courseService;

    @GetMapping("course/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Course obj = courseService.findByCourseId(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("course/add")
    public ResponseEntity<?> addNewCourse(@RequestBody CourseAddDTO obj) {
        return ResponseEntity.ok().body(courseService.addNewCourse(obj));
    }

    @GetMapping("course/all")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(courseService.findAll());
    }

    @Modifying
    @PutMapping("/course/update")
    public ResponseEntity<?> updateCourse(@RequestBody CourseUpdateDTO obj) {
        courseService.updateCourse(obj);
        return ResponseEntity.ok().body(obj.getClass().getSimpleName() + " updated successfully");
    }

    @Modifying
    @PutMapping("/course/desativate")
    public ResponseEntity<?> desativateCourse(@RequestBody CourseDesativateDTO obj) {
        courseService.deativateCourse(obj);
        return ResponseEntity.ok().body("DEACTIVATED");
    }

    @Modifying
    @PutMapping("/course/ativate")
    public ResponseEntity<?> ativateCourse(@RequestBody CourseDesativateDTO obj) {
        courseService.ativateCourse(obj);
        return ResponseEntity.ok().body(obj.getId() + " ACTIVATED");
    }

    @GetMapping("/course/name/{name}")
    public ResponseEntity<?> fifndCourseByName(@PathVariable String name) {
        return ResponseEntity.ok().body(courseService.findByName(name));
    }
}
