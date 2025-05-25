package com.dev.spring_boot_java21_mini_project.controller;

import com.dev.spring_boot_java21_mini_project.model.Course;
import com.dev.spring_boot_java21_mini_project.model.CourseRegistry;
import com.dev.spring_boot_java21_mini_project.service.CourseService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/public/courses")
    public List<Course> availableCourses(){
        return courseService.availableCourses();
    }

    @GetMapping("/admin/courses/enrolled")
    public List<CourseRegistry> enrolledStudents(){
        return courseService.enrolledStudents();
    }

    @PostMapping("/public/courses/register")
    public String enrollCourse(@RequestParam("name") String name,
                               @RequestParam("emailId") String emailId,
                               @RequestParam("courseName") String courseName){
        courseService.enrollCourse(name,emailId,courseName);
        return "Congratulations! "+name+" Enrollment Successful for "+courseName;

    }

    @PostMapping("/user/add-courses")
    public String addCourses(@RequestBody Course course){
        courseService.addCourses(course);
        return "Course added successfully!";
    }

    @GetMapping("/")
    public String homePage(HttpServletRequest request){
        return "Session id is: "+request.getSession().getId();
    }

    @GetMapping("csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
