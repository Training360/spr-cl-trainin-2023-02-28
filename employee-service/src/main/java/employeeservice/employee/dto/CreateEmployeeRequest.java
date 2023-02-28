package employeeservice.employee.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CreateEmployeeRequest {

    @Schema(description = "the name of the new employee", example = "John Doe")
    private String name;

    @Schema(description = "the id of the role of the new employee", example = "1")
    private long roleId;
}
