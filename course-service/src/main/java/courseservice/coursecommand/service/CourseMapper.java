package courseservice.coursecommand.service;

import courseservice.coursecommand.dto.CourseDetailsView;
import courseservice.coursecommand.dto.CourseView;
import courseservice.coursecommand.model.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseView toView(Course course);

    CourseDetailsView toDetailsView(Course course);

}
