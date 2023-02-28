package frontendservice.service;

import frontendservice.employeesgateway.Employee;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class CourseMapperDecorator implements CourseMapper {

    @Autowired
    @Qualifier("delegate")
    private CourseMapper delegate;

    @Override
    public CourseDetails toDto(frontendservice.coursegateway.CourseDetails courseDetails, List<Employee> employees) {
        var dto = delegate.toDto(courseDetails, employees);
        var map = employees.stream().collect(Collectors.toMap(Employee::getId, Function.identity()));
        dto.enrolledEmployees = courseDetails.getEnrolledEmployees().stream().map(map::get).toList();
        dto.completedEmployees = courseDetails.getCompletedEmployees().stream().map(map::get).toList();
        return dto;
    }
}
