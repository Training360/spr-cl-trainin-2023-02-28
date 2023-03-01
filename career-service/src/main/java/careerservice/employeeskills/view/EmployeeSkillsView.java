package careerservice.employeeskills.view;

import careerservice.employeeskills.model.AssignedSkill;
import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSkillsView {

    private Long id;

    private long employeeId;

    @ElementCollection
    private List<AssignedSkill> skills;
}
