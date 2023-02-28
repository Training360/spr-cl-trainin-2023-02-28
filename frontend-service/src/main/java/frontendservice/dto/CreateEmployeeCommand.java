package frontendservice.dto;

import lombok.Data;

@Data
public class CreateEmployeeCommand {

    private String name;

    private long roleId;
}
