package careerservice.employeeskills.model;

import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignSkillsToEmployeeCommand {

    private long employeeId;

    @ElementCollection
    private List<AssignedSkill> skills;
}
