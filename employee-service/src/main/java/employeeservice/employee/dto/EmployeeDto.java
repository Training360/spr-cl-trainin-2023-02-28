package employeeservice.employee.dto;

import employeeservice.role.dto.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto implements Serializable {

    private Long id;

    private String name;

    private RoleDto role;
}
