package courseservice.coursecommand.controller;

import courseservice.coursecommand.dto.CourseDetailsView;
import courseservice.coursecommand.dto.CreateCourseCommand;
import courseservice.coursecommand.dto.CourseView;
import courseservice.coursecommand.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

    private CourseService courseService;

    @GetMapping
    public List<CourseView> findAllCourses() {
        return courseService.findAllCourses();
    }

    @GetMapping("/{id}")
    public CourseDetailsView findCourseById(@PathVariable("id") long id) {
        return courseService.findCourseById(id);
    }

    @PostMapping // nem idempotens
    @ResponseStatus(HttpStatus.CREATED)
    public CourseView create(@RequestBody CreateCourseCommand command) {
        return courseService.createCourse(command);
    }


}
