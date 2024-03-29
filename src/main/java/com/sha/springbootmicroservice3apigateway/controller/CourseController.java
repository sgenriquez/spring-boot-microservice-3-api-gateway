package com.sha.springbootmicroservice3apigateway.controller;

import com.sha.springbootmicroservice3apigateway.request.CourseServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("gateway/course")// pre-path
public class CourseController {
    @Autowired
    private CourseServiceRequest courseServiceRequest;

    @PostMapping // gateway/course
    public ResponseEntity<?> saveCourse(@RequestBody Object course, @RequestHeader HttpHeaders headers) {
       return new  ResponseEntity<>(courseServiceRequest.saveCourse(course), HttpStatus.CREATED);
    }

    @DeleteMapping("{courseId}") // gateway/course/{courseId}
    public ResponseEntity<?> deleteCourse(@PathVariable Long courseId) {
        courseServiceRequest.deleteCourse(courseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping // gateway/course
    public ResponseEntity<?> getAllCourses() {
        return ResponseEntity.ok(courseServiceRequest.getAllCourses());
    }
}
