package careerservice.courseskills.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
public class CourseSkills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long courseId;

    @ElementCollection
    private List<AssignedSkill> skills;

    private CourseSkills(long courseId, List<AssignedSkill> skills) {
        this.courseId = courseId;
        this.skills = skills;
    }

    public static CourseSkills create(AssignSkillsToCourseCommand command) {
        return new CourseSkills(command.getCourseId(), command.getSkills());
    }

    public void addSkills(List<AssignedSkill> skillsToAdd) {
        var skillsById = skills.stream()
                .collect(Collectors.toMap(AssignedSkill::getSkillId, Function.identity()));

        for (var skillToAdd: skillsToAdd) {
            var existingSkill = skillsById.get(skillToAdd.getSkillId());
            if (existingSkill == null) {
                skills.add(skillToAdd);
            }
            else {
                if (existingSkill.getLevel() < skillToAdd.getLevel()) {
                    existingSkill.setLevel(skillToAdd.getLevel());
                }
            }

        }
    }
}
