package careerservice.courseskills.model;

import jakarta.persistence.ElementCollection;
import lombok.Data;

import java.util.List;

@Data
public class AssignSkillsToCourseCommand {

    private long courseId;

    @ElementCollection
    private List<AssignedSkill> skills;
}
