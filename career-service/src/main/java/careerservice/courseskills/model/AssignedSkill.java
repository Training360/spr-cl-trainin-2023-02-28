package careerservice.courseskills.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class AssignedSkill {

    private int level;

    private long skillId;
}
