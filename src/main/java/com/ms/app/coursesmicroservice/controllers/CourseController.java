package com.ms.app.coursesmicroservice.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.app.commons.controllers.CommonController;
import com.ms.app.commonsstudents.models.entity.Student;
import com.ms.app.coursesmicroservice.models.entity.Course;
import com.ms.app.coursesmicroservice.services.CourseService;

@RestController
public class CourseController extends CommonController<Course, CourseService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editCourse(@RequestBody Course course, @PathVariable Long id) {
		Optional<Course> optional = this._service.findById(id);
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Course courseToDataBase = optional.get();
		courseToDataBase.setName(course.getName());
		return ResponseEntity.status(HttpStatus.CREATED).body(this._service.save(courseToDataBase));
	}

	@PutMapping("/{id}/add-students")
	public ResponseEntity<?> addStudents(@RequestBody List<Student> students, @PathVariable Long id) {
		Optional<Course> optional = this._service.findById(id);
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Course courseToDataBase = optional.get();
		students.forEach(s -> {
			courseToDataBase.addStudent(s);
		});
		return ResponseEntity.status(HttpStatus.CREATED).body(this._service.save(courseToDataBase));
	}

	@PutMapping("/{id}/remove-student")
	public ResponseEntity<?> removeStudentFromCourse(@RequestBody Student student, @PathVariable Long id) {
		Optional<Course> optional = this._service.findById(id);
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Course courseToDataBase = optional.get();
		courseToDataBase.removeStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(this._service.save(courseToDataBase));
	}

}
