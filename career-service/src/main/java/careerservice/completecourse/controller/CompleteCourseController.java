package careerservice.completecourse.controller;

import careerservice.completecourse.service.CompleteCourseCommand;
import careerservice.completecourse.service.CompleteCourseService;
import careerservice.employeeskills.view.EmployeeSkillsView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CompleteCourseController {

    private CompleteCourseService completeCourseService;

    @PostMapping("/api/complete-course")
    public EmployeeSkillsView completeCourse(@RequestBody CompleteCourseCommand command) {
        return completeCourseService.completeCourse(command);
    }
}
