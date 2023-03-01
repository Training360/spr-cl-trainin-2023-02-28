package careerservice.employeeskills.controller;

import careerservice.employeeskills.model.AssignSkillsToEmployeeCommand;
import careerservice.employeeskills.service.EmployeeSkillsService;
import careerservice.employeeskills.view.EmployeeSkillsView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class EmployeeSkillsController {

    private EmployeeSkillsService service;

    @GetMapping("/api/employee-skills/{employeeId}")
    public EmployeeSkillsView findViewByEmployeeId(@PathVariable long employeeId) {
        return service.findViewByEmployeeId(employeeId);
    }

    @PostMapping("/api/employee-skills")
    public EmployeeSkillsView assignSkills(@RequestBody AssignSkillsToEmployeeCommand command) {
        return service.assignSkills(command);
    }

}
