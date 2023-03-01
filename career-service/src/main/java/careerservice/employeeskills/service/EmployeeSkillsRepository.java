package careerservice.employeeskills.service;

import careerservice.employeeskills.model.EmployeeSkills;
import careerservice.employeeskills.view.EmployeeSkillsView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployeeSkillsRepository extends JpaRepository<EmployeeSkills, Long> {

    Optional<EmployeeSkills> findByEmployeeId(long employeeId);

    @Query("select new careerservice.employeeskills.view.EmployeeSkillsView(s.id, s.employeeId, s.skills) from EmployeeSkills s join s.skills")
    Optional<EmployeeSkillsView> findViewByEmployeeId(long employeeId);

}
