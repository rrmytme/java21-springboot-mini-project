package com.dev.spring_boot_java21_mini_project.service;

import com.dev.spring_boot_java21_mini_project.model.Course;
import com.dev.spring_boot_java21_mini_project.model.CourseRegistry;
import com.dev.spring_boot_java21_mini_project.repository.CourseRegistryRepository;
import com.dev.spring_boot_java21_mini_project.repository.CourseRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepo;

    @Autowired
    CourseRegistryRepository courseRegistryRepo;

    public List<Course> availableCourses() {
        return courseRepo.findAll();
    }

    public List<CourseRegistry> enrolledStudents() {
        return courseRegistryRepo.findAll();
    }

    public void enrollCourse(String name, String emailId, String courseName) {
        CourseRegistry courseRegistry = new CourseRegistry(name,emailId,courseName);
        courseRegistryRepo.save(courseRegistry);
    }

    public void addCourses(Course course){
        courseRepo.save(course);
    }

    // get session id
    public String getSessionId(HttpServletRequest request){
        return "Session id is: "+request.getSession().getId();
   }
   // get csrf token
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
