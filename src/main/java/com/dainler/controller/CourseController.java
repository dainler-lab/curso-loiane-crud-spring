package com.dainler.controller;

import java.util.List;

import com.dainler.model.Course;
import com.dainler.repository.CourseRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
  public @ResponseBody List<Course> list() {
    return courseRepository.findAll();
  }

  /*
   * @PostMapping
   * public ResponseEntity<Course> create(@RequestBody Course course) {
   * return
   * ResponseEntity.status(HttpStatus.CREATED).body(courseRepository.save(course))
   * ;
   * }
   */

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public Course create(@RequestBody Course course) {
    return courseRepository.save(course);
  }

}
