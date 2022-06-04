package com.loiane.service;

import java.util.List;
import java.util.Optional;

import com.loiane.model.Course;
import com.loiane.repository.CourseRepository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseService {

    private CourseRepository courseRepository;

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public Course update(Course course) {
        return courseRepository.save(course);
    }

    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

    public List<Course> findAllDesc() {
        return courseRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

}
