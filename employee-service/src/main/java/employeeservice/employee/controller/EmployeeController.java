package employeeservice.employee.controller;

import employeeservice.employee.dto.CreateEmployeeRequest;
import employeeservice.employee.dto.EmployeeDto;
import employeeservice.employee.dto.UpdateEmployeeRequest;
import employeeservice.employee.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
@Slf4j
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping
//    @SneakyThrows
    public List<EmployeeDto> employees(@RequestHeader HttpHeaders headers, Principal principal) {

        if (principal != null) {
            log.info("Logged in user: {}", principal.getName());
        }
//        else {
//            throw new IllegalStateException("Log exception");
//        }

//        if (new Random().nextInt(3) != 0) {
//            Thread.sleep(5000);
//        }

        log.debug("Headers: {}", headers);
        return employeeService.listEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDto findEmployeeById(@PathVariable("id") long id) {
        return employeeService.findEmployeeById(id);
    }

    @PostMapping // nem idempotens
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "creates an employee")
    public EmployeeDto createEmployee(@RequestBody CreateEmployeeRequest request, @RequestHeader HttpHeaders headers) {
        log.debug("Headers: {}", headers);
        return employeeService.createEmployee(request);
    }

    @PutMapping("/{id}") // idempotens
    public EmployeeDto updateEmployee(@PathVariable("id") long id, @RequestBody UpdateEmployeeRequest request) {
        return employeeService.updateEmployee(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable("id") long id) {
        employeeService.deleteEmployee(id);
    }

}
