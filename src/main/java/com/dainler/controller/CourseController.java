package com.dainler.controller;

import java.util.List;

import com.dainler.model.Course;
import com.dainler.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/courses")
@AllArgsConstructor
public class CourseController {

  private final CourseRepository courseRepository;

  /*
   * // SUBSTITUI O: @Autowired E O SETTER TBM SE FOR CRIADO
   * public CourseController(CourseRepository courseRepository) {
   * this.courseRepository = courseRepository;
   * }
   */

  // @RequestMapping(method = RequestMethod.GET) MESMA COISA AS DUAS ANOTAÇÕES
  @GetMapping
  public List<Course> list() {
    return courseRepository.findAll();
  }

}
