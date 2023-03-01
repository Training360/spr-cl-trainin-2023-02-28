package careerservice.employeeskills.service;

import careerservice.employeeskills.model.EmployeeSkills;
import careerservice.employeeskills.view.EmployeeSkillsView;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeSkillsMapper {
    EmployeeSkillsView toView(EmployeeSkills result);
}
