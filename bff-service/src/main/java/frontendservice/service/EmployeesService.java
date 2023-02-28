package frontendservice.service;

import frontendservice.employeesgateway.Role;
import frontendservice.employeesgateway.CreateEmployeeCommand;
import frontendservice.employeesgateway.Employee;
import frontendservice.employeesgateway.EmployeeClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeesService {

    private EmployeeClient employeeClient;

    public List<Employee> listEmployees() {
        return employeeClient.listEmployees();
    }

    public List<Role> listRoles() {
        return employeeClient.listRoles();
    }

    public void createEmployee(CreateEmployeeCommand command) {
        employeeClient.createEmployee(command);
    }

}
