package careerservice.courseskills.controller;

import careerservice.courseskills.model.AssignSkillsToCourseCommand;
import careerservice.courseskills.service.CourseSkillsService;
import careerservice.courseskills.view.CourseSkillsView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CourseSkillsController {

    private CourseSkillsService service;

    @GetMapping("/api/course-skills/{courseId}")
    public CourseSkillsView findViewByCourseId(@PathVariable long courseId) {
        return service.findViewByCourseId(courseId);
    }

    @PostMapping("/api/course-skills")
    public CourseSkillsView assignSkills(@RequestBody AssignSkillsToCourseCommand command) {
        return service.assignSkills(command);
    }

}
