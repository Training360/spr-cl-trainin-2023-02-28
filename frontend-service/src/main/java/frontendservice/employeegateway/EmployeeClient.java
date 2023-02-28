package frontendservice.employeegateway;

import frontendservice.dto.CreateEmployeeCommand;
import frontendservice.dto.Employee;
import frontendservice.dto.Role;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

public interface EmployeeClient {

    @GetExchange("/api/employees")
    List<Employee> listEmployees();

    @GetExchange("/api/roles")
    List<Role> listRoles();

    @PostExchange("/api/employees")
    void createEmployee(@RequestBody CreateEmployeeCommand command);
}
