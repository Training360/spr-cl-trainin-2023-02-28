package careerservice.skill.service;

import careerservice.skill.model.CreateSkillCommand;
import careerservice.skill.model.Skill;
import careerservice.skill.view.SkillView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    private SkillRepository repository;

    private SkillMapper skillMapper;

    public SkillView create(CreateSkillCommand command) {
        var skill = Skill.create(command);
        repository.save(skill);
        return skillMapper.toView(skill);
    }

    public List<SkillView> listSkills() {
        return repository.findAllView();
    }
}
