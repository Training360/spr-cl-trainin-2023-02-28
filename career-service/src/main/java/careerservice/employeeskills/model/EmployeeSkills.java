package careerservice.employeeskills.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
public class EmployeeSkills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long employeeId;

    @ElementCollection
    private List<AssignedSkill> skills;

    private EmployeeSkills(long employeeId, List<AssignedSkill> skills) {
        this.employeeId = employeeId;
        this.skills = skills;
    }

    public static EmployeeSkills create(AssignSkillsToEmployeeCommand command) {
        return new EmployeeSkills(command.getEmployeeId(), command.getSkills());
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
