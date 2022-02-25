package com.ms.app.coursesmicroservice.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.ms.app.coursesmicroservice.models.entity.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {

}
