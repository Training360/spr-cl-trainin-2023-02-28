package frontendservice.service;

import frontendservice.dto.CourseDetails;
import frontendservice.dto.Employee;
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
    private CourseMapper deleagate;

    @Override
    public CourseDetailsDto toDto(CourseDetails course, List<Employee> employees) {
        var dto = deleagate.toDto(course, employees);
        var map = employees.stream().collect(Collectors.toMap(Employee::getId, Function.identity()));
        dto.enrolledEmployees = course.getEnrolledEmployees().stream().map(map::get).toList();
        dto.completedEmployees = course.getCompletedEmployees().stream().map(map::get).toList();
        return dto;
    }
}
