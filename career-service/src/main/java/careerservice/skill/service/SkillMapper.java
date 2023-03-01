package careerservice.skill.service;

import careerservice.skill.model.Skill;
import careerservice.skill.view.SkillView;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkillMapper {
    SkillView toView(Skill skill);
}
