package frontendservice.employeesgateway;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

public interface EmployeeClient {

    @GetExchange("/api/employees")
    List<Employee> listEmployees();

    @PostExchange("/api/employees")
    Employee createEmployee(@RequestBody CreateEmployeeCommand command);

    @GetExchange("/api/employees/{employeeId:\\d+}")
    Employee findEmployeeById(@PathVariable Long employeeId);

    @GetExchange(value = "/api/roles")
    List<Role> listRoles();
}
