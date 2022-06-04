package com.loiane.controller;

import javax.validation.Valid;

import com.loiane.model.Course;
import com.loiane.model.ReturnError;
import com.loiane.service.CourseService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

    private CourseService courseService;

    @GetMapping
    public ResponseEntity<Object> list() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(courseService.findAllDesc());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ReturnError(HttpStatus.INTERNAL_SERVER_ERROR,
                            HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage(), "/api/courses/GET"));
        }
    }

    @PostMapping
    @RequestMapping("create")
    public ResponseEntity<Object> create(@RequestBody @Valid Course course) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(courseService.save(course));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ReturnError(HttpStatus.INTERNAL_SERVER_ERROR,
                            HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage(), "/api/courses/create"));
        }

    }

    @PostMapping
    @RequestMapping("update")
    public ResponseEntity<Object> update(@RequestBody Course course) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(courseService.update(course));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ReturnError(HttpStatus.INTERNAL_SERVER_ERROR,
                            HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage(), "/api/courses/update"));
        }

    }

    @PostMapping
    @RequestMapping("delete")
    public ResponseEntity<Object> delete(@RequestBody Long id) {
        try {
            courseService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ReturnError(HttpStatus.INTERNAL_SERVER_ERROR,
                            HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage(), "/api/courses/delete"));
        }

    }

}
