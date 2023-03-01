package employeeservice.employee.service;

import employeeservice.NotFoundException;
import employeeservice.employee.dto.CreateEmployeeRequest;
import employeeservice.employee.dto.EmployeeDto;
import employeeservice.employee.dto.UpdateEmployeeRequest;
import employeeservice.employee.model.Employee;
import employeeservice.role.service.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.*;
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

    @CacheEvict(value = "employees", allEntries = true)
    public EmployeeDto createEmployee(CreateEmployeeRequest request) {
        var role = roleRepository.findById(request.getRoleId())
                .orElseThrow(() -> new NotFoundException("Role not found with id: " + request.getRoleId()));
        var employee = new Employee(request.getName(), role);
        employeeRepository.save(employee);
        return employeeMapper.toDto(employee);
    }

    @Cacheable("employees")
    public List<EmployeeDto> listEmployees() {
        log.debug("List employees");
        return employeeMapper.toDto(employeeRepository.findAll());
    }

    @Cacheable("employee")
    public EmployeeDto findEmployeeById(long id) {
        var employeeDto = employeeMapper.toDto(employeeRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Employee not found with id: " + id)));
        return employeeDto;
    }

    @CacheEvict(value = "employees", allEntries = true)
    @Transactional
    @CachePut(value = "employee", key = "#id")
    public EmployeeDto updateEmployee(long id, UpdateEmployeeRequest request) {
        var employeeToModify = employeeRepository.getById(id);
        employeeToModify.setName(request.getName());
        var role = roleRepository.findById(request.getRoleId())
                .orElseThrow(() -> new NotFoundException("Role not found with id: " + id));
        employeeToModify.setRole(role);
        return employeeMapper.toDto(employeeToModify);
    }

    @Caching(evict = {
        @CacheEvict(value = "employees", allEntries = true),
        @CacheEvict(value = "employee", key = "#id")
    })
    public void deleteEmployee(long id) {
        var employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee not found with id: " + id));
        employeeRepository.delete(employee);
    }
}
