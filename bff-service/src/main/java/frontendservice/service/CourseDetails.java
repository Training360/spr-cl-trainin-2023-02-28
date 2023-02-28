package frontendservice.service;

import frontendservice.employeesgateway.Employee;
import lombok.Data;

import java.util.List;

@Data
public class CourseDetails {

    private String description;

    private String syllabus;

    private int limit;

    List<Employee> enrolledEmployees;

    List<Employee> completedEmployees;
}
