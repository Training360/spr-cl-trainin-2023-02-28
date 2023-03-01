package careerservice.employeeskills.service;

import careerservice.NotFoundException;
import careerservice.employeeskills.model.AssignSkillsToEmployeeCommand;
import careerservice.employeeskills.model.AssignedSkill;
import careerservice.employeeskills.model.EmployeeSkills;
import careerservice.employeeskills.view.EmployeeSkillsView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeSkillsService {

    private EmployeeSkillsRepository repository;

    private EmployeeSkillsMapper mapper;

    public EmployeeSkillsView findViewByEmployeeId(long employeeId) {
//        return repository.findViewByEmployeeId(employeeId)
        var skills = repository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new NotFoundException("Skills not found for employee %d".formatted(employeeId)));
        return mapper.toView(skills);
    }

    @Transactional
    public EmployeeSkillsView assignSkills(AssignSkillsToEmployeeCommand command) {
        var skills = repository.findByEmployeeId(command.getEmployeeId());
        EmployeeSkills result;
        if (skills.isEmpty()) {
            result = EmployeeSkills.create(command);
            repository.save(result);
        }
        else {
            result = skills.get();
            result.addSkills(command.getSkills());
        }
        return mapper.toView(result);
    }
}
