package employeeservice.employee.model;

import employeeservice.role.model.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Role role;

    public Employee(String name, Role role) {
        this.name = name;
        this.role = role;
    }

}
