package com.ms.app.coursesmicroservice.services;

import org.springframework.stereotype.Service;

import com.ms.app.commons.services.CommonServiceImpl;
import com.ms.app.coursesmicroservice.models.entity.Course;
import com.ms.app.coursesmicroservice.models.repository.CourseRepository;

@Service
public class CourseServiceImpl extends CommonServiceImpl<Course, CourseRepository> implements CourseService {

}
