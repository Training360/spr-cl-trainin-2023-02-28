package careerservice.courseskills.view;

import careerservice.courseskills.model.AssignedSkill;
import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseSkillsView {

    private Long id;

    private long courseId;

    @ElementCollection
    private List<AssignedSkill> skills;
}
