package frontendservice.coursegateway;

import frontendservice.dto.Course;
import frontendservice.dto.CourseDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface CourseClient {

    @GetExchange("/api/courses")
    List<Course> listAllCourses();

    @GetExchange("/api/courses/{id}")
    CourseDetails findCourseById(@PathVariable("id") long id);
}
