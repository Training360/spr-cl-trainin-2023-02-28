package frontendservice.service;

import frontendservice.dto.CreateEmployeeCommand;
import frontendservice.dto.Employee;
import frontendservice.dto.Role;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeesService {

    public List<Employee> listEmployees() {
        return null;
    }

    public List<Role> listRoles() {
        return null;
    }

    public void createEmployee(CreateEmployeeCommand command) {        }

}
