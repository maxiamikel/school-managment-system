package com.maxi.backschool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.backschool.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    /*
     * @Query("SELECT s FROM Student s WHERE s.email = :email")
     * public List<Student> findStudentByEmail(@Param("email") String email);
     * 
     * @Query("SELECT s FROM Student s WHERE s.active =true ORDER BY s.name ASC")
     * public List<Student> findAllStudents();
     */
}
