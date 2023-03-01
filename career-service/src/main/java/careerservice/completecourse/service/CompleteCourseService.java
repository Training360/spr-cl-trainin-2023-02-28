package careerservice.completecourse.service;

import careerservice.courseskills.service.CourseSkillsService;
import careerservice.employeeskills.model.AssignSkillsToEmployeeCommand;
import careerservice.employeeskills.service.EmployeeSkillsService;
import careerservice.employeeskills.view.EmployeeSkillsView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CompleteCourseService {

    private CourseSkillsService courseSkillsService;

    private EmployeeSkillsService employeeSkillsService;

    private CompleteCourseMapper completeCourseMapper;

    @Transactional
    public EmployeeSkillsView completeCourse(CompleteCourseCommand command) {
        var courseSkills = courseSkillsService.findViewByCourseId(command.getCourseId());
        var assignSkillsCommand = new AssignSkillsToEmployeeCommand(command.getEmployeeId(), completeCourseMapper.toEmployeeAssignedSkills(courseSkills.getSkills()));
        return employeeSkillsService.assignSkills(assignSkillsCommand);
    }
}
