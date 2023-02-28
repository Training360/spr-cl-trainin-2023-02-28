package frontendservice.service;

import frontendservice.dto.Employee;
import lombok.Data;

import java.util.List;

@Data
public class CourseDetailsDto {

    private Long id;

    private String name;

    private String description;

    private String syllabus;

    private int limit;

    List<Employee> enrolledEmployees;

    List<Employee> completedEmployees;
}
