package careerservice.skill.controller;

import careerservice.skill.model.CreateSkillCommand;
import careerservice.skill.service.SkillService;
import careerservice.skill.view.SkillView;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SkillController {

    private SkillService skillService;

    public List<SkillView> listSkills() {
        return skillService.listSkills();
    }

    public SkillView create(CreateSkillCommand command) {
        return skillService.create(command);
    }
}
