package employeeservice.employee.service;

import employeeservice.employee.dto.EmployeeDto;
import employeeservice.employee.model.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDto toDto(Employee employee);

    List<EmployeeDto> toDto(List<Employee> employees);

}
