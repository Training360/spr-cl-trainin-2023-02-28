package careerservice.completecourse.service;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompleteCourseMapper {
    List<careerservice.employeeskills.model.AssignedSkill> toEmployeeAssignedSkills(List<careerservice.courseskills.model.AssignedSkill> skills);
}
