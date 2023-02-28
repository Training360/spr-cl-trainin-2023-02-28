package employeeservice.employee.service;

import employeeservice.NotFoundException;
import employeeservice.employee.dto.CreateEmployeeRequest;
import employeeservice.employee.dto.EmployeeDto;
import employeeservice.employee.dto.UpdateEmployeeRequest;
import employeeservice.employee.model.Employee;
import employeeservice.role.service.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeService {
    private EmployeeMapper employeeMapper;

    private EmployeeRepository employeeRepository;

    private RoleRepository roleRepository;

    public EmployeeDto createEmployee(CreateEmployeeRequest request) {
        var role = roleRepository.findById(request.getRoleId())
                .orElseThrow(() -> new NotFoundException("Role not found with id: " + request.getRoleId()));
        var employee = new Employee(request.getName(), role);
        employeeRepository.save(employee);
        return employeeMapper.toDto(employee);
    }

    public List<EmployeeDto> listEmployees() {
        log.debug("List employees");
        return employeeMapper.toDto(employeeRepository.findAll());
    }

    public EmployeeDto findEmployeeById(long id) {
        var employeeDto = employeeMapper.toDto(employeeRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Employee not found with id: " + id)));
        return employeeDto;
    }

    @Transactional
    public EmployeeDto updateEmployee(long id, UpdateEmployeeRequest request) {
        var employeeToModify = employeeRepository.getById(id);
        employeeToModify.setName(request.getName());
        var role = roleRepository.findById(request.getRoleId())
                .orElseThrow(() -> new NotFoundException("Role not found with id: " + id));
        employeeToModify.setRole(role);
        return employeeMapper.toDto(employeeToModify);
    }

    public void deleteEmployee(long id) {
        var employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee not found with id: " + id));
        employeeRepository.delete(employee);
    }
}
