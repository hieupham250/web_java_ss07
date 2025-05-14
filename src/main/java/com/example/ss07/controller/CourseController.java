package com.example.ss07.controller;

import com.example.ss07.model.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private List<Course> courseList = new ArrayList<>();
    private int nextId = 1;
    @GetMapping
    public String listCourses(Model model) {
        model.addAttribute("courses", courseList);
        return "listCourse";
    }
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("course", new Course());
        return "addCourse";
    }
    @PostMapping("/add")
    public String addCourse(@ModelAttribute("course") Course course) {
        course.setId(nextId++);
        courseList.add(course);
        return "redirect:/courses";
    }
    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") int id) {
        courseList.removeIf(c -> c.getId() == id);
        return "redirect:/courses";
    }
}
