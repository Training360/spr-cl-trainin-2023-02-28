package frontendservice.service;

import frontendservice.dto.CreateEmployeeCommand;
import frontendservice.dto.Employee;
import frontendservice.dto.Role;
import frontendservice.employeegateway.EmployeeClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeesService {

    private EmployeeClient employeeClient;

    public List<Employee> listEmployees() {
        return employeeClient.listEmployees();
    }

    public List<Role> listRoles() {
        return employeeClient.listRoles();
    }

    public void createEmployee(CreateEmployeeCommand command) {
        var employee = employeeClient.createEmployee(command);
        log.debug("Employee created with id: {}", employee.getId());
    }

}
