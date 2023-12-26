package com.maxi.backschool;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.maxi.backschool.repositories.StudentRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
class BackSchoolApplicationTests {

	@Autowired
	StudentRepository repo;

	@Test
	void contextLoads() {

	}

	@Test
	@Transactional
	@Rollback(true)
	public void check_persist_new_student_with_exists_email() {

		// final StudentRepository repo;

	}
}
