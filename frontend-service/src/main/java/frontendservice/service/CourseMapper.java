package frontendservice.service;

import frontendservice.dto.CourseDetails;
import frontendservice.dto.Employee;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
@DecoratedWith(CourseMapperDecorator.class)
public interface CourseMapper {

    @Mapping(target = "enrolledEmployees", ignore = true)
    @Mapping(target = "completedEmployees", ignore = true)
    CourseDetailsDto toDto(CourseDetails course, List<Employee> employees);
}
