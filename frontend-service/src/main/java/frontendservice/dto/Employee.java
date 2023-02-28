package frontendservice.dto;

import lombok.Data;

@Data
public class Employee {

    private Long id;

    private String name;

    private Role role;
}
