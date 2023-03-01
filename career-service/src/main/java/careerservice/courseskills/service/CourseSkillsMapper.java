package careerservice.courseskills.service;

import careerservice.courseskills.model.CourseSkills;
import careerservice.courseskills.view.CourseSkillsView;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseSkillsMapper {
    CourseSkillsView toView(CourseSkills result);
}
