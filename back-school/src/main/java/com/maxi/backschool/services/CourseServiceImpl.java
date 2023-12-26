package com.maxi.backschool.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.backschool.dtos.CourseAddDTO;
import com.maxi.backschool.dtos.CourseDesativateDTO;
import com.maxi.backschool.dtos.CourseUpdateDTO;
import com.maxi.backschool.entities.Course;
import com.maxi.backschool.repositories.CourseRepository;
import com.maxi.backschool.services.exceptions.EntityCreateViolationException;
import com.maxi.backschool.services.exceptions.EntitySearchNotFoundException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course addNewCourse(CourseAddDTO obj) {
        List<Course> list = courseRepository.findCourseByName(obj.getName());
        if (list.size() != 0 || !list.isEmpty()) {
            throw new EntityCreateViolationException(obj.getName() + " name already exist");
        }

        Course newCourse = new Course();
        newCourse.setName(obj.getName());
        newCourse = courseRepository.save(newCourse);
        return newCourse;
    }

    @Override
    public Course findByCourseId(Long id) {
        Course obj = findById(id);
        if (obj != null) {
            return obj;
        } else {
            throw new EntitySearchNotFoundException("Entity ID [" + id + "] not found in the database");
        }
    }

    private Course findById(Long id) {
        Optional<Course> obj = courseRepository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        }
        return null;
    }

    @Override
    public List<Course> findAll() {
        List<Course> list = courseRepository.findAll();
        if (list.size() != 0) {
            return list;
        } else {
            throw new EntitySearchNotFoundException("No content to show, empty list");
        }
    }

    @Override
    public void updateCourse(CourseUpdateDTO course) {
        Course obj = findByCourseId(course.getId());
        if (course.getId() != obj.getId()) {
            throw new EntitySearchNotFoundException("The informated ID[" + course.getId() + "] is not found");
        } else {
            obj.setName(course.getName());
            obj = courseRepository.saveAndFlush(obj);
        }
    }

    @Override
    public void deativateCourse(CourseDesativateDTO obj) {
        Course course = findByCourseId(obj.getId());
        if (course.getId() != null) {
            course.setActive(false);
            courseRepository.saveAndFlush(course);
        } else {
            throw new EntityCreateViolationException("Entyti status is ACTIVATE");
        }
    }

    public List<Course> findByName(String name) {
        return courseRepository.findCourseByNameLike(name);
    }

    @Override
    public void ativateCourse(CourseDesativateDTO obj) {
        Course course = findByCourseId(obj.getId());
        if (course.getId() != null) {
            course.setActive(true);
            courseRepository.saveAndFlush(course);
        } else {
            throw new EntityCreateViolationException("Entyti status is ACTIVATE");
        }
    }

}
